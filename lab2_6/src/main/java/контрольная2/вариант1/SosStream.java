package контрольная2.вариант1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

//Реализовать класс, наследующий от InputStream, описывающий бесконечный поток байт
//в котором передается циклически сигнал SOS и координаты объектов (символами),
//потерпевших аварию (данные предварительно считать из файла через Reader,
//каждое сообщение на отдельной строке). Операция close() завершает бесконечный цикл.

public class SosStream extends InputStream {
    private final List<String> messages;
    private int currentMessageIndex = 0;
    private int charPosition = 0;
    private boolean closed = false;
    private String currentMessage;

    public SosStream(Reader reader) throws IOException {
        messages = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                messages.add(line);
            }
        }

        if (messages.isEmpty()) {
            throw new IOException("Данных нет");
        }

        currentMessage = "SOS " + messages.get(0) + "\n";
    }

    @Override
    public int read() throws IOException {
        if (closed) {
            return -1;
        }

        if (charPosition >= currentMessage.length()) {
            currentMessageIndex++;

            if(currentMessageIndex>messages.size()-1) {
                currentMessageIndex=0;
            }

            currentMessage = "SOS " + messages.get(currentMessageIndex) + "\n";
            charPosition = 0;
        }

        return currentMessage.charAt(charPosition++);
    }

    @Override
    public void close(){
        closed = true;
    }
}


