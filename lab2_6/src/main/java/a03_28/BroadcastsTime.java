package a03_28;

public class BroadcastsTime {
    private int hours;
    private int minutes;

    public BroadcastsTime(String time) {
        String[] parts = time.split(":");
        this.hours = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return this.compareTo(t1) >= 0 && this.compareTo(t2) <= 0;
    }

    public int compareTo(BroadcastsTime other) {
        if (this.hours != other.hours) {
            return this.hours - other.hours;
        }
        return this.minutes - other.minutes;
    }

    private static String getCurrentTime() {
        return "12:00";
    }

    @Override
    public String toString() {
        return hours+":"+minutes;
    }

    public boolean equals(BroadcastsTime a) {
        if (a.getHours()==hours && a.minutes==minutes) return true;
        return false;
    }
}
