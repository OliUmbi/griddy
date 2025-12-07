package su.fhso.ln1;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.model.connections.*;
import su.fhso.ln1.model.nodes.ConsumerNode;
import su.fhso.ln1.model.nodes.PipeNode;
import su.fhso.ln1.model.nodes.ProducerNode;
import su.fhso.ln1.model.nodes.SwitchNode;
import su.fhso.ln1.view.View;

import java.util.List;
import java.util.Random;

public class Griddy {

    public static final int WIDTH = 24;
    public static final int HEIGHT = 16;

    public static void main(String[] args) {

        Graph graph = new Graph();

        Random random = new Random();

        for (int x = 1; x < WIDTH - 1; x++) {
            for (int y = 1; y < HEIGHT - 1; y++) {

                if (isProducer(x, y)) {
                    graph.addNode(x, y, new ProducerNode());
                    continue;
                }

                if (isConsumer(x, y)) {
                    graph.addNode(x, y, new ConsumerNode());
                    continue;
                }

                Connection connection = switch (random.nextInt(4)) {
                    case 0 -> new StraightConnection(random.nextInt(4));
                    case 1 -> new CornerConnection(random.nextInt(4));
                    case 2 -> new CrossConnection();
                    case 3 -> new TConnection(random.nextInt(4));
                    default -> new StraightConnection(random.nextInt(4));
                };

                switch (random.nextInt(2)) {
                    case 0 -> graph.addNode(x, y, new PipeNode(connection));
                    case 1 -> graph.addNode(x, y, new SwitchNode(connection));
                }
            }
        }

        View view = new View(graph);
        view.start();
    }

    public static boolean isProducer(int x, int y) {
        List<int[]> consumers = List.of(
                new int[]{11, 7}
        );

        for (int[] consumer : consumers) {
            if (consumer[0] == x && consumer[1] == y) {
                return true;
            }
        }

        return false;
    }

    public static boolean isConsumer(int x, int y) {
        List<int[]> consumers = List.of(
                new int[]{2, 1},
                new int[]{21, 1},
                new int[]{1, 13},
                new int[]{20, 12},
                new int[]{1, 6},
                new int[]{20, 7},
                new int[]{12, 2},
                new int[]{14, 14},
                new int[]{5, 3},
                new int[]{16, 8},
                new int[]{6, 9},
                new int[]{7, 14}
        );

        for (int[] consumer : consumers) {
            if (consumer[0] == x && consumer[1] == y) {
                return true;
            }
        }

        return false;
    }
}
