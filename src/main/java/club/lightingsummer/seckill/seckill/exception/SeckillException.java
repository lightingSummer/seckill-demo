package club.lightingsummer.seckill.seckill.exception;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description： 业务异常
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
