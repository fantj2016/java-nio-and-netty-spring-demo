package com.reflection.detail;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Fant.J.
 * 2018/2/7 17:01
 */
public class Reflection_DynamicProx {

    public static void main(String[] args) {
        CommonDao commonDao = new CommonDaoImpl();
        InvocationHandler handler = new MyInvocationHandler(commonDao);
        CommonDao proxy = (CommonDao) Proxy.newProxyInstance(
                commonDao.getClass().getClassLoader(),
                commonDao.getClass().getInterfaces(),
                handler);
        proxy.insert(2,3);
        proxy.insert(3,3);
        proxy.delete(5,2);
    }

    /**
     * 重写InvocationHandler
     * 将代理上的所有方法调用转发
     * 相当于 Method一章节中，我们讲到的反射实例化
     * aClass.getMethod("setName", String.class);
     * 然后调用ethod.invoke(people,"Fant.J");
     */
    static final class MyInvocationHandler implements InvocationHandler{
        //这个就是我们要代理的真实对象
        private Object subject;

        //构造方法，需要把我们要代理的真实对象 传进来 供给invoke方法使用
        public MyInvocationHandler(Object subject)
        {
            this.subject = subject;
        }

        /**
         * 重写invoke方法
         * @param proxy 代理对象
         * @param method 代理方法
         * @param args 代理方法传入的参数
         * @return 返回反射结果
         * @throws Throwable
         */

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //do something "dynamic"
            System.out.println("方法【" + method.getName() + "】开始执行, 参数为" + Arrays.asList(args) + "...");
            long start = System.currentTimeMillis();
            Object result = method.invoke(subject, args);
            long end = System.currentTimeMillis();
            System.out.println("方法【" + method.getName() + "】执行完成,运算结果为:" + result + ", 用时" + (end - start) + "毫秒!");
            return result;

        }
    }
    static interface CommonDao{
        public int insert(int a,int b);
        public int delete(int a,int b);
    }
    static class CommonDaoImpl implements CommonDao{
        @Override
        public int insert(int a, int b) {
            return a+b;
        }

        @Override
        public int delete(int a, int b) {
            return a-b;
        }
    }
}
