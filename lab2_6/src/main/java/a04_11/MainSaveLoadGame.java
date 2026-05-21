package a04_11;

import java.io.*;

public class MainSaveLoadGame {
    public static void main(String[] args) throws Exception {
        //1)проинициализировали
        Game game = new Game(10, 20, 5, 9);


        //2)
        byte[] saveGame;

        //объект, который превращает массив байт в выходной поток
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //класс трансформирующий объект оперативной памяти в выходной поток
        ObjectOutputStream os = new ObjectOutputStream(bos);

        os.writeObject(game);

        //массив байт, содержащий "слепок" объекта
        saveGame = bos.toByteArray();

        //сохраняем в файл
        FileOutputStream fos = new FileOutputStream("game.sav");
        fos.write(saveGame);
        fos.flush();
        fos.close();

        //3)
        FileInputStream fis = new FileInputStream("game.sav");
        ObjectInputStream is = new ObjectInputStream(fis);

        Game loadedGame = (Game)is.readObject();
        fis.close();
        System.out.println(loadedGame);
    }
}
