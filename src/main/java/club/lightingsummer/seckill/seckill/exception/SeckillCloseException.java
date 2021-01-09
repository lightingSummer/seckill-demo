package club.lightingsummer.seckill.seckill.exception;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description： 秒杀关闭异常
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
