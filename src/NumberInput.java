
import java.util.Scanner;

/**
 * 判断输入的数字是否合法
 * Created by Fant.J.
 * 2018/2/3 8:58
 */
public class NumberInput {
    /** 常量1：num等于0 */
    public static final int NUM_EQUALS_0 = 0;
    /** 常量2：num大于0 */
    public static final int NUM_MORETHAN_0 = 1;
    /** 常量3： num小于0 */
    public static final int NUM_LITTLETHAN_0 = -1;

    /**
     * 该方法中实例化一个Scanner对象来获取输入的整数
     * @return num值
     * @throws MyException 自定义异常类
     */
    public int number() throws MyException {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num==NUM_EQUALS_0){
            //方法一：
            //抛出异常/
            throw new MyException(NUM_EQUALS_0,"num不能为0");
        }else if (num < NUM_EQUALS_0){
            //方法二：
            //抛出异常
            throw new MyException(NUM_LITTLETHAN_0,"num不能小于0");
        }else {
            //输入合法
            System.out.println("输入合法");
            System.out.println("状态码:"+NUM_MORETHAN_0);
            return num;
        }
    }
}
