package a04_11.DB;

import java.io.*;

public class DataBaseUtils {
    private static final String FILE_NAME = "many.tbl";

    public void save(Many many) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream os = null;
        DataOutputStream dos = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(fos);
            os.writeObject(many);
            byte[] array = bos.toByteArray();

            fos = new FileOutputStream(FILE_NAME, true);
            dos = new DataOutputStream(fos);

            dos.writeInt(many.getId());
            dos.writeByte(1);
            dos.writeInt(array.length);
            dos.write(array);
        } finally {
            if (dos != null) {
                dos.close();
            } else if (fos != null) {
                fos.close();
            }

        }

    }
}
