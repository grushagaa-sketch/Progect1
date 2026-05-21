package a04_11.DB;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            NewDataBase db1 = new NewDataBase();

            Many many1 = new Many(1,(byte)1,"зп1",new Date(), 1000000,  "");
            Many many2 = new Many(2,(byte)-1,"автобус",new Date(), 100000,  "");
            Many many3 = new Many(3,(byte)1,"зп2",new Date(), 1000000,  "");
            Many many4 = new Many(4,(byte)-1,"дом",new Date(), 100000,  "");

            db1.save(many1);
            db1.save(many2);
            db1.save(many3);
            db1.save(many4);


            System.out.println(db1.findById(4));
            db1.deteteById(4);
            System.out.println(db1.findById(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
