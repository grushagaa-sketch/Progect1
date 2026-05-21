package a03_28;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("variant1.csv");
        List<String> lines = Files.readAllLines(path);

        //5
        List<Program> programs = new ArrayList<>();

        String currChan = null;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("#")) {
                currChan = lines.get(i);
            } else if (lines.get(i).matches("\\d{2}:\\d{2}")) {
                String time = lines.get(i);
                String name = lines.get(i + 1);

                if (i+2 < lines.size() &&!lines.get(i + 2).startsWith("#")) {
                    String timeEnd = lines.get(i + 2);
                } else {
                    String timeEnd = "05:00";
                }


                Program p = new Program(currChan, new BroadcastsTime(time), name, new BroadcastsTime(time));
                programs.add(p);
            }


        }
        //Map<BroadcastsTime, List<Program>> map = new HashMap<>();

        //4
        programs.stream()
                .collect(Collectors.groupingBy(p -> p.getTime()))

                .entrySet().stream()
                .forEach((e) -> {
                    System.out.println(e.getKey());
                    e.getValue().stream()
                            .forEach(a -> System.out.print(a + ", "));
                });

        //6
        programs.stream().sorted((a, b) -> a.compareTo(b))
                .forEach(b -> System.out.println(b.getChannel() + " " + b.getTime()));

        //7
        BroadcastsTime now = new BroadcastsTime("13:00");
        programs.stream()
                .filter(p -> p.getTime().equals(now))
                .forEach(p -> System.out.println(p));

        //8
        String someName = "...";
        programs.stream()
                .filter(p -> now.between(p.getTime(), p.getTimeEnd()))
                .forEach(p -> System.out.println(p));

        //9
        String someChannel = "...";
        programs.stream()
                .filter(p -> p.getTime().equals(now))
                .filter(p -> p.getChannel().equals(someChannel))
                .forEach(p -> System.out.println(p));

        //10
        String someChannel2 = "...";

        programs.stream()
                .filter(p -> p.getTime().between(new BroadcastsTime("10:00"), new BroadcastsTime("12:00")))
                .filter(p -> p.getChannel().equals(someChannel2))
                .forEach(p -> System.out.println(p));
    }
}
