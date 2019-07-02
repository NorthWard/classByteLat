package com.north.lat.classbytelat.client;


import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;

public class MethodChangeClassAdapter  extends ClassVisitor {

    public MethodChangeClassAdapter(int api) {
        super(api);
    }

    public MethodChangeClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if("test".equalsIgnoreCase(name)){
            MethodVisitor mv = cv.visitMethod(access, name + "22", desc, signature, exceptions);
            // 这里一定要是MethodVisitor的子类, 详见ClassReader的918行
            mv = new AsmMethodVisitor(api, mv);
           /* mv = new AdviceAdapter(Opcodes.ASM5, mv, access, name, desc) {
                //方法进入时获取开始时间
                @Override public void onMethodEnter() {
                    mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                    mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                    mv.visitVarInsn(ASTORE, 1);
                }

                //方法退出时获取结束时间并计算执行时间
                @Override public void onMethodExit(int opcode) {
                    mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                    mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                    mv.visitVarInsn(ASTORE, 2);
                    mv.visitVarInsn(ALOAD, 2);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false);
                    mv.visitVarInsn(ALOAD, 1);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false);
                    mv.visitInsn(LSUB);
                    mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                    mv.visitVarInsn(ASTORE, 3);
                    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                    mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
                    mv.visitInsn(DUP);
                    mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
                    mv.visitLdcInsn("time :");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                    mv.visitVarInsn(ALOAD, 3);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                }
             };*/
            return mv;
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
