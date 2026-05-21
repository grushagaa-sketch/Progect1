package a04_18.anotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrepareGameMain {

    public static void main(String[] args) {
        Class clazz = Game.class;

        //1) исследуем аннотации над классом
        System.out.println("1) исследуем аннотации над классом");
        Annotation[] classAnnotations = clazz.getAnnotations();
        for (Annotation a : classAnnotations) {
            System.out.println(a);
        }

        if (clazz.isAnnotationPresent(GameState.class)) {
            System.out.println("обнаружили наличие");
        }

        //2) исследуем аннотации над методами
        System.out.println("2) исследуем аннотации над методами");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            Annotation[] methodAnnotations = method.getAnnotations();
            if (methodAnnotations.length > 0) {
                for (Annotation a : classAnnotations) {
                    System.out.println(a);
                }

                System.out.println(method.isAnnotationPresent(ToString.class));
            }
        }

        //3) исследуем аннотации над членами класса
        System.out.println("3) исследуем аннотации над членами класса");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            if (fieldAnnotations.length > 0) {
                for (Annotation a : fieldAnnotations) {
                    System.out.println(a);
                    if (a instanceof DefaultValue) {
                        System.out.println(((DefaultValue)a).value());
                    }
                }

                System.out.println(field.isAnnotationPresent(DefaultValue.class));
            }
        }

    }


}
