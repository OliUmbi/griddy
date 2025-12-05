package su.fhso.ln1;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.view.View;

public class Griddy {

    public static void main(String[] args) {

        final int WIDTH = 30;
        final int HEIGHT = 20;

        Graph graph = new Graph(WIDTH, HEIGHT);
        graph.addNode();
        graph.addNode();
        graph.addNode();

        View view = new View(WIDTH, HEIGHT, graph);
        view.start();

    }
}
