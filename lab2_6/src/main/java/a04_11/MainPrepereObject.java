package a04_11;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainPrepereObject {
    public static void main(String[] args) throws Exception {
        Game game = new Game("Gamer");

        //1) определяем какого типа объект
        System.out.println("1)--------------------------------");
        System.out.println(game.getClass());
        Class clazz = game.getClass();
        System.out.println(clazz.equals(Game.class));

        //2) публичные члены класса
        System.out.println("2)--------------------------------");
        Field[] fields = clazz.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }

        //3) все члены класса
        System.out.println("3)--------------------------------");
        Field[] all_fields = clazz.getDeclaredFields();
        for (Field field: all_fields) {
            field.setAccessible(true);
            System.out.println(field.getType()+":"+field.getName() + " : " + field.get(game));
        }

        //3') значение членов класса через геттеры
        System.out.println("3')--------------------------------");
        all_fields = clazz.getDeclaredFields();
        for (Field field: all_fields) {
            //1 ищем для члена класса его геттер
            String gettrName = "get" + field.getName().substring(0,1).toUpperCase()
                    + field.getName().substring(1);
            Method getter  = clazz.getMethod(gettrName);
            //2 вызываем геттер, получаем значение
            Object value =getter.invoke(game);
            System.out.println(field.getType()+":"+field.getName() + " : " + value);
        }

        //4) предки
        System.out.println("4)--------------------------------");
        System.out.println(clazz.getSuperclass());

        //5) интерфейсы
        System.out.println("5)--------------------------------");
        Class[] interfaces = clazz.getInterfaces();
        for (Class c: interfaces) {
            System.out.println(c);
        }

        //6) публичные методы
        System.out.println("6)--------------------------------");
        Method[] met = clazz.getMethods();
        for (Method m: met) {
            System.out.println(m);
        }

        //7) методы
        System.out.println("7)--------------------------------");
        Method[] all_met = clazz.getDeclaredMethods();
        for (Method m: met) {
            System.out.println(m);
        }



    }
}
