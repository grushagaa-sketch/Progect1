package Lab2.Lessons.a02_28.Graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class Graph implements Iterable<Node>{
    private Map<Node, Set<Node>> graphMap;

    public Graph() {
        this.graphMap = new HashMap<>();
    }

    public void add(Node o, Node ... dependencies) {
        graphMap.put(o, new HashSet<>(List.of(dependencies)));
    }

    // ищем и возвращаем узлы у которых нет зависимостей
    public Set<Node> findEmpty(){
        Set<Node> result = new HashSet<>();
        for(Map.Entry<Node, Set<Node>> o : graphMap.entrySet()){
            if(o.getValue().isEmpty()){
                result.add(o.getKey());
            }
        }
        return result;
    }

    public void removeEmptyNodes(Set<Node> nodes){
        // удаляем узлы без зависимостей
        for(Node n : nodes){
            graphMap.remove(n);
        }

        // из зависимостей удаляем узлы без зависимостей
        for(Map.Entry<Node, Set<Node>> o : graphMap.entrySet()){
            o.getValue().removeAll(nodes);
        }
    }

    public boolean isEmpty() {
        // вызываем встроенный в Map метод isEmpty
        return graphMap.isEmpty();
    }


    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            private Set<Node> current = findEmpty();

            @Override
            public boolean hasNext() {
                return !graphMap.isEmpty();
            }

            @Override
            public Node next() {
                if (current.isEmpty()) current=findEmpty();
                Node n = current.iterator().next();
                current.remove(n);
                removeEmptyNodes(Set.of(n));

                return n;
            }
        };
    }
}