package club.lightingsummer.seckill.seckill.service;

import club.lightingsummer.seckill.seckill.dto.Exposer;
import club.lightingsummer.seckill.seckill.dto.SeckillExecution;
import club.lightingsummer.seckill.seckill.exception.RepeatKillException;
import club.lightingsummer.seckill.seckill.exception.SeckillCloseException;
import club.lightingsummer.seckill.seckill.exception.SeckillException;
import club.lightingsummer.seckill.seckill.model.Good;

import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description： 从使用者角度来定义接口
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     */
    List<Good> getSeckilList();

    /**
     * 查询单个秒杀记录
     */
    Good getSeckillById(long seckillId);

    /**
     * 秒杀开始时输出秒杀接口地址
     * 否则输出秒杀时间和系统时间
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;
}
