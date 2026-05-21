package a04_04;

import java.io.*;

public class TestBufferdFileReader {
    public static String change(String str, String oldStr, String newStr) {
            String[] list = str.split(oldStr);
            return list[0] + newStr + list[1];
    }

    public static void main(String[] args) {
        try {
            //1. Подсчитать кол-во строк
            //2. Найти самую длинную и самую короткую строку
            //3. Создать новый файл с тем же содержимым, но в кодировке cp2151
            //4. Создать новый файл, заменив названия ключей
            //arrivaldate -> arrivalDate,
            //stayingdate -> stayingDate,
            //departuredate -> departureDate
            int cnt = 0;
            String longest = "";
            String shortest = "";
            int max_length = Integer.MIN_VALUE;
            int min_length = Integer.MAX_VALUE;

            BufferedReader reader = new BufferedReader(new FileReader("bookings.json"));

            //3
            File bookingsCP1251 = new File("bookings_cp1251.json");
            OutputStream os = new FileOutputStream(bookingsCP1251);
            //4
            File bookings_new = new File("bookings_new.json");
            OutputStream os2 = new FileOutputStream(bookings_new);

            String str;

            while ((str = reader.readLine()) != null) {
                //System.out.println(str);
                //1
                cnt += 1;

                //2
                int len = str.length();
                if (len > max_length) {
                    max_length = len;
                    longest = str;
                }
                if (len < min_length) {
                    min_length = len;
                    shortest = str;
                }

                //3
                byte[] data = str.getBytes("CP1251");
                os.write(data);
                os.write("\n".getBytes("CP1251"));

                //4
                String newStr = str;
                String[] oldStrs = {"arrivaldate", "stayingdate", "departuredate"};
                String[] newStrs = {"arrivalDate", "stayingDate", "departureDate"};
                for (int i=0; i<oldStrs.length; i++) {
                    if (str.contains(oldStrs[i])) {
                        newStr = change(str, oldStrs[i], newStrs[i]);
                    }
                }
                os2.write(newStr.getBytes());
                os2.write("\n".getBytes());

            }
            reader.close();
            os.flush();//?
            os.close();
            os2.flush();
            os2.close();

            System.out.println("количество строк: " + cnt);
            System.out.println("самая длинная строка:" + longest);
            System.out.println("самая короткая строка: " + shortest);

            if (bookingsCP1251.exists() && bookingsCP1251.length() > 0) {
                System.out.println("файл успешно создан");
            }

            if (bookings_new.exists() && bookings_new.length() > 0) {
                System.out.println("файл 2 успешно создан");
                System.out.println(bookings_new.getAbsolutePath());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}


