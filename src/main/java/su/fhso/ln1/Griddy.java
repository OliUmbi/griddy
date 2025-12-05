package su.fhso.ln1;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.view.View;

public class Griddy {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode();
        graph.addNode();
        graph.addNode();

        View view = new View(graph);
        view.start();

    }
}
