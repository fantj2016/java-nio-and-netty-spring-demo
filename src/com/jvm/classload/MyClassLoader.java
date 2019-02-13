package com.jvm.classload;

import java.io.InputStream;

/**
 * 只加载当前包下的类，不是当前包下的交给上面的类加载器
 * Created by Fant.J.
 */
public class MyClassLoader {
        ClassLoader classLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                //拿出类的简单名称
                String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream ins = getClass().getResourceAsStream(filename);

                if (ins == null){
                    return super.loadClass(name);
                }
                try {
                    byte [] buff = new byte[ins.available()];
                    ins.read(buff);
                    // 将字节码转换成类对象
                    return defineClass(name,buff,0,buff.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException();
                }
            }
        };
}
