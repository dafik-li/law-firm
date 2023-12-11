package com.solvd.lawfirm.reflection;

import com.solvd.lawfirm.entity.persons.SolicitorPerson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatorObject {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(CreatorObject.class);

    public void createObjectAndInvokeMethod() {
        String className = "com.solvd.lawfirm.entity.persons.SolicitorPerson";
        try {
            Class<SolicitorPerson> solicitorPersonClass = (Class<SolicitorPerson>) Class.forName(className);
            Constructor<SolicitorPerson> solicitorPersonConstructor = solicitorPersonClass
                    .getDeclaredConstructor(char.class, String.class, String.class, int.class, int.class);
            SolicitorPerson solicitorPerson = solicitorPersonConstructor
                    .newInstance('m', "marcello", "mastroianni", 100, 3);
            Method getLevelMethod = solicitorPersonClass.getDeclaredMethod("getLevel", solicitorPerson.getClass());
            LOGGER.info("\n" + "OBJECT INFORMATION" + "\n" + solicitorPerson + "\n" + "METHOD INVOKED" + "\n" + getLevelMethod);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | InvocationTargetException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
