package club.lightingsummer.seckill.seckill;

import club.lightingsummer.seckill.seckill.dto.Exposer;
import club.lightingsummer.seckill.seckill.dto.SeckillExecution;
import club.lightingsummer.seckill.seckill.model.Good;
import club.lightingsummer.seckill.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckilListTest() {
        List<Good> list = seckillService.getSeckilList();
        logger.info("list={}", list);
    }

    @Test
    public void getSeckillByIdTest() {
        long id = 1000;
        Good good = seckillService.getSeckillById(id);
        logger.info("seckill={}", good);
    }

    @Test
    public void exportSeckillUrlTest() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
        // exposed=false, md5='104130e8a02758954be0119f1b1a13be', seckillId=1000, now=0, start=0, end=0
    }

    @Test
    public void executeSeckillTest() {
        long id = 1000;
        long phone = 15863793066L;
        String md5 = "104130e8a02758954be0119f1b1a13be";
        SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
        logger.info("result={}",execution);
    }
}
