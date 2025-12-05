package su.fhso.ln1.view;

import su.fhso.ln1.model.Graph;
import su.fhso.ln1.model.nodes.Node;

public class View {

    private final int width;
    private final int height;
    private final Graph graph;

    public View(int width, int height, Graph graph) {
        this.width = width;
        this.height = height;
        this.graph = graph;
    }

    public void start() {
        Node[][] node = graph.getNodes();

        // create components from nodes

        // start gui
    }
}
