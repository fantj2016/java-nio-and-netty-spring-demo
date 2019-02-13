import com.reflection.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * 5
 * 1 5 4 8 20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获取第一行
        int n = scanner.nextInt();
        scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        //分割
        String[] result = data.split(" ");
        int[] array = new int[n];
        //转换成数字数组
        for (int i = 0 ;i<n;i++){
            array[i] = Integer.valueOf(result[i]);
        }
        int second = Math.abs(array[1]-array[0]);
        int temp;
        int min = second;
        //对获取到的数据进行遍历并做一些操作
        for (int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){
                temp = array[j]-array[i];
                temp = Math.abs(temp);
                min = min>temp?temp:min;
                if (min ==0){
                    break;
                }
            }
        }
        System.out.print(min);
    }
}
