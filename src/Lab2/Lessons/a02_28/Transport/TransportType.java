package Lab2.Lessons.a02_28.Transport;

public enum TransportType {
    bus("Автобус"),
    tram("Трамвай"),
    trolleybus("Троллейбус");

    private String name;

    TransportType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
