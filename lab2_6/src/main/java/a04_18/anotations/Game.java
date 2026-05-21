package a04_18.anotations;

import java.io.Serializable;


//отмечаем класс как сереализируемый
@GameState
public class Game implements Serializable {
    private double xPosition;
    private double yPosition;
    private int level;
    private int power = 100;
    public String gamerName;


    public Game() {
    }

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public Game(double xPosition, double yPosition, int level, int power) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.power = power;
        this.gamerName = gamerName;
    }

    private double getRadVect() {
        return Math.sqrt(xPosition*xPosition+yPosition*yPosition);
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getYPosition() {
        return yPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getXPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }


    @Override
    public String toString() {
        return "Game{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", level=" + level +
                ", power=" + power +
                '}';
    }
}
