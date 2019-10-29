package com.tao.util;

import com.tao.classload.MyClassLoad;
import com.tao.feild.OrgEntity;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * @author liutao
 * @path src/com.tao.util
 * @date 2019/10/25  23:21
 */
public class FieldExample {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String fullName = OrgEntity.class.getName();
        System.out.println(fullName);
        String fullNameType = fullName.replace(".", "/");
        ClassReader cr = new ClassReader(fullNameType);
        ClassWriter cw = new ClassWriter(0);
        FieldUtil mv = new FieldUtil(ASM5, cw);
        cr.accept(mv, ClassReader.SKIP_DEBUG);
        byte[] bytes = cw.toByteArray();

        MyClassLoad classLoader = new MyClassLoad();
        Class<?> cls = classLoader.defineClassPublic(fullName, bytes, 0, bytes.length);

        //创建实例对象
        Object o = cls.newInstance();
        Field name = cls.getField("name");
        name.set(o, "kobin");
        Object nameValue = name.get(o);
        System.out.println(nameValue);

        /**未将成员属性age修改为public,所以调用会报错*/
        Field age = cls.getField("age");
        age.set(o, 21);
        Object ageValue = age.get(o);
        System.out.println("age:" + ageValue);
    }
}
