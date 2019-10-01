package club.lightingsummer.seckill.seckill.model;

import java.util.Date;

public class Record {
    private Integer seckillId;

    private Long seckillPhone;

    private Byte state;

    private Date createTime;

    public Integer getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Integer seckillId) {
        this.seckillId = seckillId;
    }

    public Long getSeckillPhone() {
        return seckillPhone;
    }

    public void setSeckillPhone(Long seckillPhone) {
        this.seckillPhone = seckillPhone;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "seckillId=" + seckillId +
                ", seckillPhone=" + seckillPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}