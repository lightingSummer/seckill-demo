package club.lightingsummer.seckill.seckill.dao;

import club.lightingsummer.seckill.seckill.model.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface GoodMapper {

    Good selectGoodById(long id);

    List<Good> selectSeckillGoods();

    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
}