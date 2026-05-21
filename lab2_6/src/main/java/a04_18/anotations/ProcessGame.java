package a04_18.anotations;

import a04_11.Game;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ProcessGame {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 1) создаем экземпляр Game через рефлексию
        // new Game() - статически

        ProcessGame processGame = new ProcessGame();
        Game game = (Game) processGame.makeObject(Game.class);

        System.out.println(game.getGamerName());
    }


    public Object makeObject(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object result = null;
        Constructor constructor = clazz.getConstructor();
        result = constructor.newInstance();


        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields) {
            if (field.isAnnotationPresent(DefaultValue.class)) {
                field.setAccessible(true);//разрешили себе доступ
                DefaultValue annotation = field.getAnnotation(DefaultValue.class);
                field.set(result, annotation.value());//принимает(объект, значение)
            }
        }
        return result;
    }


}
