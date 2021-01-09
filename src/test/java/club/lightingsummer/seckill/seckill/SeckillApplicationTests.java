package club.lightingsummer.seckill.seckill;

import club.lightingsummer.seckill.seckill.dao.GoodMapper;
import club.lightingsummer.seckill.seckill.dao.RecordMapper;
import club.lightingsummer.seckill.seckill.model.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillApplicationTests {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void recordTest() {
        recordMapper.insertSuccessKilled(1,15863793066L);
        //recordMapper.selectById(1);
    }

    @Test
    public void goodTest() {
        System.out.println(goodMapper.selectGoodById(1000L));
        System.out.println(goodMapper.reduceNumber(1000L, new Date()));
    }

}
