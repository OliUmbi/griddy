package su.fhso.ln1.view;

import ch.trick17.gui.impl.swing.Window;
import su.fhso.ln1.Griddy;
import su.fhso.ln1.model.Graph;
import su.fhso.ln1.model.nodes.*;
import su.fhso.ln1.view.components.ConsumerView;
import su.fhso.ln1.view.components.PipeView;
import su.fhso.ln1.view.components.ProducerView;
import su.fhso.ln1.view.components.SwitchView;

public class View {

    public final static int FPS = 60;
    private static final int NODE_WIDTH = 50;

    private final Graph graph;

    public View(Graph graph) {
        this.graph = graph;
    }

    public void start() {


        Window window = new Window("Geothermal", getScreenWidth(), getScreenHeight());
        window.setFullScreen(false);
        window.setResizable(false);
        window.open();

        createComponents(window);

        window.refreshAndClear(1000 / FPS);
        window.runUntilClosed();
    }

    private void createComponents(Window window) {
        INode[][] node = graph.getNodes();

        for (int x = 0; x < node.length; x++) {
            for (int y = 0; y < node[x].length; y++) {

                if (node[x][y] instanceof PipeNode pipeNode) {
                    window.addComponent(new PipeView(x, y, pipeNode));
                }

                if (node[x][y] instanceof SwitchNode switchNode) {
                    window.addComponent(new SwitchView(x, y, switchNode));
                }

                if (node[x][y] instanceof ConsumerNode consumerNode) {
                    window.addComponent(new ConsumerView(x, y, consumerNode));
                }

                if (node[x][y] instanceof ProducerNode producerNode) {
                    window.addComponent(new ProducerView(x, y, producerNode));
                }
            }
        }
    }

    private int getScreenWidth() {
        return Griddy.WIDTH * NODE_WIDTH;
    }

    private int getScreenHeight() {
        return Griddy.HEIGHT * NODE_WIDTH;
    }

    public static int getNodeWidth() {
        return NODE_WIDTH;
    }

    public static int getScreenX(int x) {
        return x * NODE_WIDTH;
    }

    public static int getScreenY(int y) {
        return y * NODE_WIDTH;
    }
}
