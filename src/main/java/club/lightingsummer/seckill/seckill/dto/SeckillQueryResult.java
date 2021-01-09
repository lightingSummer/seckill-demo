package club.lightingsummer.seckill.seckill.dto;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description： 返回信息
 */
public class SeckillQueryResult<T> {
    private boolean success;

    private T data;

    private String error;

    public SeckillQueryResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillQueryResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
