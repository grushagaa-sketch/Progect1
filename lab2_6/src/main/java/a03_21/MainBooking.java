package a03_21;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainBooking {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BookingData data = mapper.readValue(new File("bookings.json"), BookingData.class);
        data.getBookings().forEach(b -> System.out.println(b));


        //1
        long countF = data.getBookings().stream()
                .filter(b -> b.getId() == 150)
                .filter(p -> p.getPerson().getGender().equals("Female"))
                .count();
        System.out.println();

        //2
        data.getBookings().stream()
                .map(b -> b.getPerson().getFromcity())
                .distinct()
                .sorted((a, b) -> a.compareTo(b))
                .forEach(b -> System.out.println(b));

        //3
        long cnt = data.getBookings().stream()
                .filter(b -> b.getArrivaldate().startsWith("2021-12"))
                .count();
        System.out.println(cnt);

        //4
        data.getBookings().stream()
                .collect(Collectors.toMap(b -> b.getHotel().getName(),
                        b -> 1, (v1, v2) -> (v1 + v2)))
                .forEach((k, v) -> System.out.println(k + " " + v));

        //5
        data.getBookings().stream()
                .collect(Collectors.toMap(b -> b.getPerson().getFromcity(),
                        b -> 1, (v1, v2) -> v1 + v2))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        //6
        long cnt6 = data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity().equals("Петербург"))
                .count();
        System.out.println(cnt6);

        //7
        Hotel h7 = data.getBookings().stream()
                .filter(b -> b.getArrivaldate().startsWith("2022-01"))
                .collect(Collectors.toMap(b -> b.getHotel(), b -> 1, (v1, v2) -> v1 + v2))
                .entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue() - e2.getValue())
                .get().getKey();
        System.out.println(h7);

        //8
        data.getBookings().stream()
                .filter(b -> b.getPerson().getGender() != null)
                .filter(b -> b.getPerson().getGender().equals("Male"))
                .filter(b -> {
                    if (b.getPerson().getBirthdate() == null) return false;
                    int age = 2022 - Integer.parseInt(b.getPerson().getBirthdate().substring(0, 4));
                    return 1977 <= age && age <= 1987;
                })
                .map(b -> b.getPerson().getFromcity())
                .distinct()
                .forEach(b -> System.out.println(b));

        //9
        data.getBookings().stream()
                .filter(b -> {
                    if (b.getPerson().getBirthdate() == null || b.getArrivaldate() == null) return false;
                    int age = Integer.parseInt(b.getArrivaldate().substring(0, 4)) - Integer.parseInt(b.getPerson().getBirthdate().substring(0, 4));
                    return age <= 14;
                })
                .map(b -> b.getPerson().getFromcity())
                .distinct()
                .forEach(b -> System.out.println(b));

        //10
        data.getBookings().stream()
                .filter(b -> b.getPerson().getBirthdate() != null)
                .filter(b -> b.getPerson().getGender() != null)
                .collect(Collectors.toMap(b -> b.getPerson(), b -> 1, (v1, v2) -> v1 + v2))
                .entrySet().stream()
                .filter(b -> b.getValue() > 3)
                .forEach(e ->
                        System.out.println(e.getKey() + ": " + e.getValue()));


        //11
        data.getBookings().stream()
                .filter(b -> b.getPerson().getGender() != null)
                .filter(b -> b.getPerson().getGender().equals("Female"))
                .filter(b -> b.getPerson().getFromcity().equals("Санкт-Петербург"))
                .filter(b -> b.getDeparturedate().startsWith("2022-02") || b.getDeparturedate().startsWith("2022-03"))
                .map(b -> b.getHotel().getName())
                .distinct()
                .forEach(System.out::println);

        //12
        data.getBookings().stream()
                .filter(b -> b.getPerson().getBirthdate() != null)
                .collect(Collectors.toMap(b -> b.getPerson().getGroup(), b -> 1, (v1, v2) -> v1 + v2))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        //13
        data.getBookings().stream()
                .filter(b -> b.getHotel().getId() == 123)
                .filter(b -> b.getPerson().getFromcity().equals("Самарская область"))
                .filter(b -> b.getDeparturedate().startsWith("2023-04") || b.getDeparturedate().startsWith("2023-05"))
                .distinct()
                .forEach(e -> System.out.println(e.getPerson()));

        //14 гостиница: список городов людей которые в ней остановились
        data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity() != null)
                // группируем по названию гостиницы
                .collect(Collectors.groupingBy(b -> b.getHotel().getName()))//Map<String, List<Booking>>

                .entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue().stream()
                                .map(b -> b.getPerson().getFromcity())
                                .collect(Collectors.toSet())
                ))

                .forEach((k, v) -> {
                    System.out.println(k);
                    v.stream().forEach(b -> System.out.print(b+", "));
                    System.out.println();
                });

        //15 город: список гостиниц
        data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity()!=null)
                .collect(Collectors.groupingBy(b -> b.getPerson().getFromcity()))

                .entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().stream().map(b -> b.getHotel().getName()).collect(Collectors.toSet())
                        ))
                .forEach((k,v) -> {
                    System.out.println(k);
                    v.stream().forEach(a -> System.out.print(a+", "));
                    System.out.println();
                });



    }
}
