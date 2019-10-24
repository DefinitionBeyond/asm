package com.tao.util;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author liutao
 * @path src/com.tao.util
 * @date 2019/10/24  0:00
 */
public class MethodUtil extends ClassVisitor implements Opcodes{

    public MethodUtil(ClassVisitor classVisitor) {
        super(Opcodes.ASM4,classVisitor);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        if(null!=cv) {
            cv.visit(i, i1, s, s1, s2, strings);
        }
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        if(null!=cv && "testName".equals(name)){
            return cv.visitMethod(access, name + "1", desc, signature, exceptions);
        }


        if(null!=cv && "testContent".equals(name)){
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            MethodVisitor newMethod = null;
            //访问需要修改的方法
            newMethod = new AsmMethodVisit(mv);
            return newMethod;
        }

        return super.visitMethod(access,name,desc,signature,exceptions);
    }
}
