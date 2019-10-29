package com.tao.classload;

/**
 * @author liutao
 * @path src/com.tao.classload
 * @date 2019/10/25  23:25
 */
public class MyClassLoad extends ClassLoader {

    public Class<?> defineClassPublic(String name, byte[] b, int off, int len) throws ClassFormatError {
        Class<?> clazz = defineClass(name, b, off, len);
        return clazz;
    }
}
