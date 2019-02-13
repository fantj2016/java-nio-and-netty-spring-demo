package com.jvm.methodInvoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class TestMethodHandle {
    class GrandFather {
        void thinking() {
            System.out.println(" i am grandfather");
        }
    }
    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println(" i am father");
        }
    }
    class Son extends Father {
        @Override
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }
    }
    public static void main(String[] args) {
        (new TestMethodHandle().new Son()).thinking();
    }
}