package club.lightingsummer.seckill.seckill.dao;

import club.lightingsummer.seckill.seckill.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordMapper {

    // 插入秒杀记录
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("seckillPhone") long seckillPhone);

    // 根据秒杀id查询
    Record selectById(@Param("seckillId") long seckillId);
}