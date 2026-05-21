package Lab2.Lessons.a02_28.Transport;

public class Tram extends Transport {
    public Tram(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TransportType.tram, number, routeNumber, workTimeBegin, workTimeEnd);
    }
}
