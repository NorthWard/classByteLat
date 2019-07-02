package com.north.lat.classbytelat.client;


import com.north.lat.classbytelat.api.TestService;
import javassist.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaAssistTest {
    public static void main(String[] args) {
        try {
            testAop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testAop() throws Exception{
        CtClass clazz = ClassPool.getDefault().get("com.north.lat.classbytelat.api.impl.TestServiceImpl");
        CtMethod ctMethod = clazz.getDeclaredMethod("test");
        ctMethod.addLocalVariable("beg", CtClass.longType);
        ctMethod.insertBefore("long beg = System.currentTimeMillis();");
        ctMethod.insertAfter("long end = System.currentTimeMillis(); long t = (end - beg); System.out.println(\"time : \" + t); ");
        ((TestService)clazz.toClass().newInstance()).test();
        FileOutputStream fos = new FileOutputStream("g:\\TesteJavaassist.class");
        fos.write(clazz.toBytecode());
        fos.close();
    }

}
