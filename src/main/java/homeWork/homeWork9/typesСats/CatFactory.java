package homeWork.homeWork9.typesСats;

import homeWork.homeWork9.annotations.Blochable;
import homeWork.homeWork9.annotations.LuckyCat;
import homeWork.homeWork9.annotations.Paw;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CatFactory {

    public CatFactory(Class[] array) {
        produceFarsh(array);
    }

    public void produceFarsh(Class[] array) {
        for (Class clazz : array) {
            if (clazz.isAnnotationPresent(Blochable.class)) {
                System.out.println(clazz.getName() + " идет на фарш (@Blochable)");
            } else {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(LuckyCat.class)) {
                        if (field.getAnnotation(LuckyCat.class).lucky()) {
                            System.out.println(clazz.getName() + " будет жить (@Lucky - true)");
                        } else {
                            System.out.println(clazz.getName() + " умрет (@Lucky - false)");
                        }
                    }
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method m : methods) {
                        if (m.isAnnotationPresent(Paw.class)) {
                            if (m.getAnnotation(Paw.class).amount() == 2) {
                                System.out.println(clazz.getName() + " будет жить (@Paw=2)");
                            }
                        }
                    }
                }
            }
        }
    }
}
