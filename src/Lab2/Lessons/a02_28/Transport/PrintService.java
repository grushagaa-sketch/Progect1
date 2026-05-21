package Lab2.Lessons.a02_28.Transport;

import java.util.*;

public class PrintService {

    class CompareByNumber implements Comparator<Transport> {
        @Override
        public int compare(Transport o1, Transport o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
        //номера маршрутов сравниваются как строки, т.е.  1118 < 112 и т.д.
    }


    //в упорядоченном виде парковые номера и время начала движения
    public void printSortedByNumber(List<Transport> transports) {
        transports.sort(new CompareByNumber());
        for (Transport transport: transports) {
            System.out.println(transport.getNumber() + ", " + transport.getWorkTimeBegin());
        }
    }


    //в упорядоченном виде номера маршрутов, время начала и окончания движения маршрута
    public void printSortedByRoutNumber(List<Transport> transports) {
        //Анонимный экземпляр анонимного класса
        transports.sort(new Comparator<Transport>(){
            public int compare(Transport o1, Transport o2) {
                return o1.getRouteNumber().compareTo(o2.getRouteNumber());
            }
            //15<21<3 т.к. сравниваются как строки
        });

        for (Transport transport: transports) {
            System.out.println(transport.getRouteNumber() + ", " + transport.getWorkTimeBegin()+ ", "
                    + transport.getWorkTimeEnd());
        }
    }


    //кол-во разных маршрутов
    public void numberOfRouts(List<Transport> transports) {
        Set<String> set = new HashSet<>();
        for (Transport transport: transports) {
            set.add(transport.getRouteNumber());
        }
        System.out.println("Количество различных маршрутов - "+set.size());
    }


    //кол-во разных транспортных средств
    public void numberOfTransports(List<Transport> transports) {
        Map<TransportType, Integer> map = new HashMap<>();
        for (TransportType type: TransportType.values()) {
            map.put(type, 0);
        }

        for (Transport transport: transports) {
            map.replace(transport.type, map.get(transport.type)+1);
        }
        for (TransportType type: TransportType.values()) {
            System.out.println(type.getName()+": " + map.get(type));
        }
    }


    //номер маршрута и кол-во транспортных средств на нем
    public void numberOfTransportsOnRouts(List<Transport> transports) {
        Map<String, Integer> map = new HashMap<>();
        for (Transport transport: transports) {
            map.put(transport.getRouteNumber(), 0);
        }

        for (Transport transport: transports) {
            map.replace(transport.getRouteNumber(), map.get(transport.routeNumber)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
    }
}
