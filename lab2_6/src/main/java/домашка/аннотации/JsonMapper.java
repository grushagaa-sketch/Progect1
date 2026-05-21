package домашка.аннотации;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JsonMapper {

    public static Object getValue(Object o, Field field) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //проверяем @PrintByGetter - аннотация говорит о том, что
        //нельзя использовать значение поля напрямую,а получать значение через его геттер
        if (field.isAnnotationPresent(PrintByGetter.class)) {
            String gettrName = "get" + field.getName().substring(0, 1).toUpperCase()
                    + field.getName().substring(1);
            Method getter = o.getClass().getMethod(gettrName);
            return  getter.invoke(o);
        } else {
            field.setAccessible(true);
            return field.get(o);
        }
    }

    public static String makeJson(Object o) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
/*
С помощью аннотаций придать дополнительную функциональность
механизма преобразования объекта в JSON

@Transient - игнорировать поле (в json оно не должно попасть)

@PrintNullValueAs("null") - если значение члена класса null, то эта аннотация
говорит о том, что надо выводить вместо пустого значения

@PrintByGetter - аннотация говорит о том, что нельзя использовать значение поля напрямую,
а получать значение через его геттер

*/
        if (o==null) return "null";

        String json = "{";

        Class clazz = o.getClass();

        Field[] all_fields = clazz.getDeclaredFields();
        for (Field field : all_fields) {
            //проверяем @Transient - игнорировать поле (в json оно не должно попасть)
            if (field.isAnnotationPresent(Transient.class)) continue;

            json = json + "\n";

            String field_name = field.getName();
            json+="\t\""+field_name+"\": ";
            Object value = getValue(o, field);

            if (value==null && field.isAnnotationPresent(PrintNullValueAs.class)) {
                PrintNullValueAs a = field.getAnnotation(PrintNullValueAs.class);
                json+="\""+a.value()+"\"";
            } else {
                json+="\""+value+"\"";
            }


        }
        json += "\n";
        json += "}";
        return json;
    }
}
