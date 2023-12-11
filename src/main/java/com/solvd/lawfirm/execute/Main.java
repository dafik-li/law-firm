package com.solvd.lawfirm.execute;

import com.solvd.lawfirm.reflection.CreatorObject;
import com.solvd.lawfirm.reflection.Reflector;

public class Main {
    public static void main(String[] args) throws Exception {
        /*Generator generator = new Generator();
        generator.getResult();
         */
        Reflector reflector = new Reflector();
        CreatorObject creatorObject = new CreatorObject();
        reflector.getClassInformation();
        creatorObject.createObjectAndInvokeMethod();
    }
}