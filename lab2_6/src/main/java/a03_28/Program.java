package a03_28;

public class Program {


    String channel;
    BroadcastsTime time;
    String name;
    BroadcastsTime timeEnd;

    public BroadcastsTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(BroadcastsTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Program(String channel, BroadcastsTime time, String name, BroadcastsTime timeEnd) {
        this.channel = channel;
        this.time = time;
        this.name = name;
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channel='" + channel + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Program a) {
        return name.compareTo(a.name);
    }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
    public BroadcastsTime getTime() { return time; }
    public void setTime(BroadcastsTime time) { this.time = time; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
