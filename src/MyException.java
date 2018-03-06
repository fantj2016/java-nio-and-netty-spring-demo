
/**
 * 自定义异常
 * Created by Fant.J.
 * 2018/2/3 8:55
 */
public class MyException extends Exception{
    //错误代码
    private int errCode;
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    /**
     * 自定义异常构造方法
     * @param errCode 错误代码
     * @param message 错误信息
     */
    public MyException(int errCode,String message) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
