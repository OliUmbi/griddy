package su.fhso.ln1.view;

import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Clickable;
import ch.trick17.gui.component.Drawable;
import ch.trick17.gui.component.Shape;
import su.fhso.ln1.model.nodes.Node;

public class UiProducer implements Drawable, Clickable {

    private final int x;
    private final int y;
    private final Node node;

    public UiProducer(int x, int y, Node node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }

    @Override
    public void onLeftClick(double v, double v1) {
        node.updateOrientation(1);
    }

    @Override
    public void onRightClick(double v, double v1) {
        node.updateOrientation(-1);
    }

    @Override
    public void draw(Gui gui) {

    }

    @Override
    public Shape getInteractiveArea(Gui gui) {
        return null;
    }
}
