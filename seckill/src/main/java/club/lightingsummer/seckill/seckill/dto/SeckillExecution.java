package club.lightingsummer.seckill.seckill.dto;

import club.lightingsummer.seckill.seckill.enums.SeckillStateEnum;
import club.lightingsummer.seckill.seckill.model.Record;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description： 秒杀返回类
 */
public class SeckillExecution {
    // 秒杀id
    private long seckillId;
    // 秒杀状态
    private int state;
    // 状态信息
    private String stateInfo;
    // 秒杀记录
    private Record record;

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, Record record) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.record = record;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
