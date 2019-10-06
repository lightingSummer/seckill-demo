package club.lightingsummer.seckill.seckill.service.impl;

import club.lightingsummer.seckill.seckill.dao.GoodMapper;
import club.lightingsummer.seckill.seckill.dao.RecordMapper;
import club.lightingsummer.seckill.seckill.dto.Exposer;
import club.lightingsummer.seckill.seckill.dto.SeckillExecution;
import club.lightingsummer.seckill.seckill.enums.SeckillStateEnum;
import club.lightingsummer.seckill.seckill.exception.RepeatKillException;
import club.lightingsummer.seckill.seckill.exception.SeckillCloseException;
import club.lightingsummer.seckill.seckill.exception.SeckillException;
import club.lightingsummer.seckill.seckill.model.Good;
import club.lightingsummer.seckill.seckill.model.Record;
import club.lightingsummer.seckill.seckill.service.SeckillService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description：
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String salt = "dha6ui04sd8fs43d";

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Good> getSeckilList() {
        PageHelper.startPage(0, 5);
        return goodMapper.selectSeckillGoods();
    }

    @Override
    public Good getSeckillById(long seckillId) {
        return goodMapper.selectGoodById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Good seckillGood = goodMapper.selectGoodById(seckillId);
        if (seckillGood == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckillGood.getStartTime();
        Date endTime = seckillGood.getEndTime();
        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        String md5 = getMD5(seckillId);
        return new Exposer(false, md5, seckillId);
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        Date now = new Date();
        try {
            int updateCnt = goodMapper.reduceNumber(seckillId, now);
            if (updateCnt <= 0) {
                throw new SeckillCloseException("seckill close");
            } else {
                // 记录秒杀记录
                int insertCnt = recordMapper.insertSuccessKilled(seckillId, userPhone);
                if (insertCnt <= 0) {
                    throw new RepeatKillException("seckill repeated");
                } else {
                    Record record = recordMapper.selectById(seckillId);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, record);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("seckill error :" + e.getMessage());
        }
    }
}
