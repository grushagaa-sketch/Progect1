package домашка.аннотации;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Game game1 = new Game(1.0, 5.,null,4, null);
        System.out.println(JsonMapper.makeJson(game1));
    }
}
