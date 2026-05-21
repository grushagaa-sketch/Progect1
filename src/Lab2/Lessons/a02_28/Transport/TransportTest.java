package Lab2.Lessons.a02_28.Transport;

import java.util.List;

public class TransportTest {
    public static void main(String[] args) {
        TransportService service = new TransportService();

        List<Transport> transports = service.readAll();
        /*
        for (Transport t: transports) {
            System.out.println(t);
        }*/

        PrintService printer = new PrintService();

        printer.printSortedByNumber(transports);
        printer.printSortedByRoutNumber(transports);
        printer.numberOfRouts(transports);
        printer.numberOfTransports(transports);
        printer.numberOfTransportsOnRouts(transports);

    }

}
