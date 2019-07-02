package com.north.lat.classbytelat.client;

import com.north.lat.classbytelat.api.impl.TestServiceImpl;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.objectweb.asm.*;

import java.io.FileOutputStream;

public class AsmTest implements Opcodes {
    public static void main(String[] args) throws Exception {
        ClassReader classReader = new ClassReader(TestServiceImpl.class.getName());
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new MethodChangeClassAdapter(Opcodes.ASM5, classWriter);
        classReader.accept(classVisitor, Opcodes.ASM5);
        FileOutputStream fos = new FileOutputStream("g:\\Tester11.class");
        fos.write(classWriter.toByteArray());
        fos.close();
    }
}
