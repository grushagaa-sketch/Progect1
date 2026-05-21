package Lab2.Lessons.a02_28.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // создать переменную результат типа List
        List<Node> result = new ArrayList<>();

        Graph graph = new Graph();
        graph.add(new Node("d"), new Node[0]);
        graph.add(new Node("a"), new Node("d"), new Node("c"));
        graph.add(new Node("f"), new Node("d"));
        graph.add(new Node("g"), new Node("d"), new Node("c"), new Node("f"));
        graph.add(new Node("c"), new Node[0]);
        graph.add(new Node("b"), new Node("f"), new Node("g"), new Node("a"), new Node("c"));


        // выводим результат с помощью итератора
        for (Node node : graph) {
            System.out.print(node + " ");
        }
    }
}
