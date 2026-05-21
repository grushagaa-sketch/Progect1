package a04_11.DB;

import java.io.Serializable;
import java.util.Date;

public class Many implements Serializable {
    private int id;
    private byte type; //1 доход, -1 расход
    private  String name;
    private Date date;
    private float summ;
    private String comment;

    public Many() {
    }

    public Many(int id, byte type, String name, Date date, float summ, String comment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.date = date;
        this.summ = summ;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Many{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", summ=" + summ +
                ", comment='" + comment + '\'' +
                '}';
    }
}
