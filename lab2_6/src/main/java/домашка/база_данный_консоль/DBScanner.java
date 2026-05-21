package домашка.база_данный_консоль;

import a04_11.DB.Many;
import a04_11.DB.NewDataBase;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class DBScanner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NewDataBase db = new NewDataBase();

    public void work() throws Exception {
        while (true) {
            System.out.println("доступные действия: \n" +
                    "1) добавление в бд\n" +
                    "2) поиск по id\n" +
                    "3) удаление по id\n" +
                    "4) изменение данных(изменить существующую запись)\n" +
                    "5) ввод всех данных в файл students.html\n" +
                    "6) остановка работы программы\n" +
                    "введите номер выбранного действия:\n");


            int action = scanner.nextInt();
            if (action == 6) break;
            switch (action) {
                case 1:
                    add();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    deliteById();
                    break;
                case 4:
                    change();
                    break;
                case 5:
                    saveAllInFile();
                    break;
                default:
                    System.out.println("вы что то не то ввели");

            }
        }
    }

    public void add() throws IOException {
        System.out.println("добавляем запись. введите id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("укажите тип: 1 - доход, -1 - расход: ");
        byte type = scanner.nextByte();
        scanner.nextLine();

        System.out.println("введите название: ");
        String name = scanner.nextLine();

        System.out.println("введите сумму: ");
        float summ = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("при необходимости укажите комментарий: ");
        String comment = scanner.nextLine();

        Many many = new Many(id, type, name, new Date(), summ, comment);
        db.save(many);
        System.out.println("данные успешно сохранены");
    }

    public void findById() throws Exception {
        System.out.println("ищем запись. введите id:");
        int id = scanner.nextInt();
        Many many = db.findById(id);
        System.out.println(many);
    }

    public void deliteById() throws Exception {
        System.out.println("удаляем запись. введите id:");
        int id = scanner.nextInt();
        db.deteteById(id);
        System.out.println("данные успешно удалены");
    }

    public void change() throws Exception {
        System.out.println("меняем запись. введите id:");
        int id = scanner.nextInt();

        Many many = db.findById(id);
        System.out.println("текущие данные:\n" + many);
        System.out.println("введите новые данные");

        System.out.println("укажите тип: 1 - доход, -1 - расход(текущее значение:" + many.getType() + "): ");
        byte type = scanner.nextByte();
        scanner.nextLine();

        System.out.println("введите название(текущее значение:" + many.getName() + "): ");
        String name = scanner.nextLine();

        System.out.println("введите сумму(текущее значение:" + many.getSumm() + "): ");
        float summ = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("укажите комментарий(текущее значение:" + many.getComment() + "): ");
        String comment = scanner.nextLine();

        db.deteteById(id);
        db.save(new Many(id, type, name, new Date(), summ, comment));
        System.out.println("данные успешно обновлены");

    }

    public void saveAllInFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.html"));
             DataInputStream dis = new DataInputStream(new FileInputStream("many.tbl"))) {

            bw.write("<!DOCTYPE html>\n");
            bw.write("<html>\n");
            bw.write("<head>\n");
            bw.write("    <meta charset=\"utf-8\"/>\n");
            bw.write("</head>\n");
            bw.write("<body>\n");
            bw.write("<h1>Доходы/Расходы</h1>\n");
            bw.write("<table border=\"1\">\n");
            bw.write("    <table>\n");
            bw.write("        <th>id</th><th>Тип</th><th>Название</th><th>Сумма</th><th>Дата</th><th>Примечание</th>\n");
            bw.write("    </tr>\n");


            while (dis.available() > 0) {
                int currentId = dis.readInt();
                int flag = dis.readByte();
                int size = dis.readInt();

                if (flag == 1) {
                    byte[] buffer = new byte[size];
                    dis.readFully(buffer);

                    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer))) {
                        Many many = (Many) ois.readObject();

                        bw.write("    <tr>\n");
                        bw.write("        <td>" + many.getId() + "</td>\n");
                        bw.write("        <td>" + (many.getType() == 1 ? "Доход" : "Расход") + "</td>\n");
                        bw.write("        <td>" + many.getName() + "</td>\n");
                        bw.write("        <td>" + many.getSumm() + "</td>\n");
                        bw.write("        <td>" + many.getDate() + "</td>\n");
                        bw.write("        <td>" + (many.getComment() == null || many.getComment().isEmpty() ? "-" : many.getComment()) + "</td>\n");
                        bw.write("    </tr>\n");
                    }
                } else {
                    dis.skipBytes(size);
                }
            }

            bw.write("</table>\n");
            bw.write("</body>\n");
            bw.write("</html>");


        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка десериализации: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

