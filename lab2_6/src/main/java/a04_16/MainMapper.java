package a04_16;

import a04_11.Game;

import java.lang.reflect.InvocationTargetException;

public class MainMapper {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Game game = new Game("Gamer");
        JsonMapper mapper = new JsonMapper();
        System.out.println(mapper.writeObject(game));

        //сформировать по объекту json в котором имена полей и значения берутся из членов класса
    }
}
