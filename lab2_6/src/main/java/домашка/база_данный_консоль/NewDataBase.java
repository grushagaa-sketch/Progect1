package домашка.база_данный_консоль;

import a04_11.DB.Many;

import java.io.*;

public class NewDataBase {
    private static final String FILE_NAME = "many.tbl";


    public void deteteById(int id) throws Exception{
        int position = 0;
        boolean find = false;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int currentId = dis.readInt();
                int flag = dis.readByte();
                int size = dis.readInt();

                if (id == currentId && flag == 1) {
                    find = true;
                    break;
                } else dis.skipBytes(size);
                position=position+4+1+4+size;
            }
        }
        if (find) {
            try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
                long offset = position+4;
                raf.seek(offset);
                raf.writeByte(0);
            }
        }
    }

    public Many findById(int id) throws Exception {
        Many result = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int currentId = dis.readInt();
                int flag = dis.readByte();
                int size = dis.readInt();

                if (id == currentId && flag == 1) {
                    byte[] buffer = new byte[size];
                    dis.readFully(buffer);
                    ObjectInputStream os = new ObjectInputStream(new ByteArrayInputStream(buffer));
                    result = (a04_11.DB.Many) os.readObject();
                    break;
                } else dis.skipBytes(size);
            }
        }
        return result;
    }

    public void save(Many many) throws IOException {
        // используем try с ресурсами который обеспечивает автоматическое закрытие
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(bos);
                FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
                DataOutputStream dos = new DataOutputStream(fos);

        ) {

            // сериализуем объект в ByteArrayOutputStream
            os.writeObject(many);

            // из ByteArrayOutputStream извлекаем массив содержащий объект many
            byte[] array = bos.toByteArray();

            // записываем id записи
            dos.writeInt(many.getId());
            // пишем 1, т.е. запись актуальна(не удалена)
            dos.writeByte(1);
            // пишем размер сериализованного объекта
            dos.writeInt(array.length);
            // пишем объект в сериализованном виде
            dos.write(array);
        }
    }
}
