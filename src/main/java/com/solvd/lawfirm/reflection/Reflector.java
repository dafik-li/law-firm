package com.solvd.lawfirm.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflector {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private final static Logger LOGGER = (Logger) LogManager.getLogger(Reflector.class);
    private final String className = "com.solvd.lawfirm.controller.Generator";

    public void getClassInformation() {
        try {
            Class<?> c = Class.forName(className);
            LOGGER.info("CLASS: " + c.getCanonicalName());
            LOGGER.info("MODIFIERS: " + Modifier.toString(c.getModifiers()));
            LOGGER.info("TYPE PARAMETERS: ");
            TypeVariable[] tv = c.getTypeParameters();
            if (tv.length != 0) {
                Arrays.stream(tv).peek(typeVariable -> System.out.println(typeVariable.getName()))
                        .forEach(TypeVariable::getName);
            } else {
                LOGGER.info("  -- No Type Parameters --  ");
            }
            LOGGER.info("IMPLEMENTED INTERFACES: ");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs)
                    LOGGER.info(intf.toString());
            } else {
                LOGGER.info("  -- No Implemented Interfaces --  ");
            }
            LOGGER.info("INHERITANCE PATH: ");
            List<Class> l = new ArrayList<Class>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l)
                    LOGGER.info(cl.getCanonicalName());
            } else {
                LOGGER.info("  -- No Super Classes --  ");
            }
            LOGGER.info("ANNOTATIONS: ");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    LOGGER.info(a.toString());
            } else {
                LOGGER.info("  -- No Annotations --  ");
            }
            LOGGER.info("FIELDS: ");
            Field[] fld = c.getDeclaredFields();
            if (fld.length != 0) {
                getFieldInformation();
            } else {
                LOGGER.info("  -- No Fields --  ");
            }
            LOGGER.info("METHODS: ");
            Method[] mth = c.getDeclaredMethods();
            if (mth.length != 0) {
                getMethodInformation();
            } else {
                LOGGER.info("  -- No Methods --  ");
            }
            LOGGER.info("CONSTRUCTOR: ");
            Constructor<?>[] cnstr = c.getDeclaredConstructors();
            if (cnstr.length != 0) {
                getConstructorInformation();
            } else {
                LOGGER.info("  -- No Constructor --  ");
            }
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
    public void getMethodInformation() {
        try {
            Class<?> c = Class.forName(className);
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                LOGGER.info(m.getName());
                LOGGER.info(m.toGenericString());
                LOGGER.info("Modifier - " + Modifier.toString(m.getModifiers()));
                LOGGER.info("ReturnType - " + m.getReturnType());
                LOGGER.info("GenericReturnType - " + m.getGenericReturnType());
                Class<?>[] pType = m.getParameterTypes();
                Type[] gpType = m.getGenericParameterTypes();
                if (gpType.length != 0 && pType.length != 0) {
                    for (int i = 0; i < pType.length; i++) {
                        LOGGER.info("ParameterType - " + pType[i]);
                        LOGGER.info("GenericParameterType - " + gpType[i]);
                    }
                } else {
                    LOGGER.info("  -- No ParameterTypes --  ");
                }
                Class<?>[] xType = m.getExceptionTypes();
                Type[] gxType = m.getGenericExceptionTypes();
                if (gxType.length != 0 && xType.length != 0) {
                    for (int i = 0; i < xType.length; i++) {
                        LOGGER.info("ExceptionType - " + xType[i]);
                        LOGGER.info("GenericExceptionType - " + gxType[i]);
                    }
                } else {
                    LOGGER.info("  -- No ExceptionTypes --  ");
                }
            }
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
    public void getFieldInformation() {
        try {
            Class<?> c = Class.forName(className);
            Field[] allFields = c.getDeclaredFields();
            for (Field f : allFields) {
                LOGGER.info(f.getName());
                LOGGER.info(f.toGenericString());
                LOGGER.info("Modifier - " + Modifier.toString(f.getModifiers()));
                LOGGER.info("Type - " + f.getType());
                LOGGER.info("GenericType - " + f.getGenericType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getConstructorInformation() {
        try {
            Class<?> c = Class.forName(className);
            Constructor<?>[] cnstr = c.getDeclaredConstructors();
            for (Constructor<?> con : cnstr) {
                LOGGER.info(con.getName());
                LOGGER.info(con.toGenericString());
                LOGGER.info("Modifier - " + Modifier.toString(con.getModifiers()));
                Class<?>[] pType = con.getParameterTypes();
                Type[] gpType = con.getGenericParameterTypes();
                if (gpType.length != 0 && pType.length != 0) {
                    for (int i = 0; i < pType.length; i++) {
                        LOGGER.info("ParameterType - " + pType[i]);
                        LOGGER.info("GenericParameterType - " + gpType[i]);
                    }
                } else {
                    LOGGER.info("  -- No ParameterTypes --  ");
                }
                Class<?>[] xType = con.getExceptionTypes();
                Type[] gxType = con.getGenericExceptionTypes();
                if (gxType.length != 0 && xType.length != 0) {
                    for (int i = 0; i < xType.length; i++) {
                        LOGGER.info("ExceptionType - " + xType[i]);
                        LOGGER.info("GenericExceptionType - " + gxType[i]);
                    }
                } else {
                    LOGGER.info("  -- No ExceptionTypes --  ");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
