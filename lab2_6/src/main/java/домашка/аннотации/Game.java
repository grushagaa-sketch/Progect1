package домашка.аннотации;

import a04_18.anotations.GameState;

import java.io.Serializable;



@GameState
public class Game implements Serializable {
    @Transient
    private Double xPosition;

    @PrintByGetter
    private Double yPosition;

    @PrintNullValueAs("уровень не указан")
    private Integer level;


    private Integer power = 100;

    @PrintNullValueAs("безымянный")
    public String gamerName;


    public Game() {
    }

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public Game(Double xPosition, Double yPosition, Integer level, Integer power, String gamerName) {
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
