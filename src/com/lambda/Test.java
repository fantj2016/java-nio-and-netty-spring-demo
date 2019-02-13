package com.lambda;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Fant.J.
 * 2018/8/16 9:53
 */
public class Test {
    public static void main(String[] args) {

    }
    interface A1{
        void m1()throws IOException;
    }
    interface A2{
        void m2()throws SQLException;
    }
    interface A3 extends A1,A2{
        void m3() throws ClassNotFoundException;
    }
}
