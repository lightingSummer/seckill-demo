package club.lightingsummer.seckill.seckill.exception;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/5 0005
 * @description： 重复秒杀异常
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
