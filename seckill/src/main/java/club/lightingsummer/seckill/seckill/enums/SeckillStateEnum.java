package club.lightingsummer.seckill.seckill.enums;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/6 0006
 * @description：
 */
public enum SeckillStateEnum {
    SUCCESS(0, "秒杀成功"),
    END(1, "秒杀结束"),
    REPEAT_KILL(2, "重复秒杀"),
    INNER_ERROR(3, "系统异常"),
    DATA_REWRITE(4, "数据篡改");

    private int state;
    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum stateOf(int index) {
        for (SeckillStateEnum state : values()) {
            if (index == state.getState()) {
                return state;
            }
        }
        return null;
    }
}
