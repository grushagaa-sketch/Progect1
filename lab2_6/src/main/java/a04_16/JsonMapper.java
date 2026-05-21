package a04_16;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JsonMapper {

    public String writeObject(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String json = "{";

        Class clazz = o.getClass();

        Field[] all_fields = clazz.getDeclaredFields();
        for (Field field : all_fields) {
            json = json + "\n";
            //1 ищем для члена класса его геттер
            String gettrName = "get" + field.getName().substring(0, 1).toUpperCase()
                    + field.getName().substring(1);
            Method getter = clazz.getMethod(gettrName);


            //2 вызываем геттер, получаем значение
            Object value = getter.invoke(o);
            json = json + "\t\"" + field.getName()+"\" : " ;
            if (field.getType().equals(String.class)) {
                json = json + "\"" + value + "\"";
            } else json = json + value;

        }
        json += "\n";
        json += "}";
        return json;
    }
}
