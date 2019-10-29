package com.tao.util;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC;

/**
 * @author liutao
 * @path src/com.tao.util
 * @date 2019/10/25  23:16
 */
public class FieldUtil extends ClassVisitor {

    public FieldUtil(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if ("name".equals(name)) {
            return super.visitField(ACC_PUBLIC, name, descriptor, signature, value);
        }
        return super.visitField(access, name, descriptor, signature, value);
    }
}
