package контрольная2.вариант1;


//Протестировать работу класса, написав программу которая "прослушивает эфир",
//выводит информацию в консоль и параллельно пишет лог файл в режиме добавления с использованием Writer.
//После каждого сообщения спрашивать "продолжить или завершить?".
//Программа должна иметь метод writeStat(Writer writer), принимающая на вход потомка Writer,
//и пишущая статистику во Writer (кол-во сообщений за сеанс работы программы).
//Данный метод вызвать при завершении программы, осуществить запись в файл в кодировке cp1251.

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TestSosStream {
    private static int messagesCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Reader fileReader = new FileReader("sos_data.txt");
             SosStream stream = new SosStream(fileReader);
             FileWriter logWriter = new FileWriter("log.txt", true)) {

            StringBuilder message = new StringBuilder();
            int data;
            boolean running = true;

            while (running && (data = stream.read()) != -1) {
                message.append((char) data);

                if ((char) data == '\n') {
                    messagesCount++;
                    String msg = message.toString().trim();

                    System.out.println(msg);
                    logWriter.write(msg + "\n");
                    logWriter.flush();

                    System.out.print("продолжить или завершить?\n");
                    boolean correct_command = false;
                    while (!correct_command) {
                        String input = scanner.nextLine().trim().toLowerCase();
                        if (input.equals("завершить")) {
                            running = false;
                            stream.close();
                            correct_command = true;
                        } else if (input.equals("продолжить")) {
                            correct_command = true;
                        } else {
                            System.out.println("неверная команда");
                        }
                    }

                    message = new StringBuilder();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try (FileWriter statWriter = new FileWriter("stat.txt", Charset.forName("cp1251"), true)) {
                writeStat(statWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Сообщений принято: " + messagesCount);
    }

    public static void writeStat(Writer writer) throws IOException {
        writer.write("Количество сообщений за сеанс работы программы: " + messagesCount+ "\n");
        writer.flush();
    }
}