package su.fhso.ln1.view;

import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Clickable;
import ch.trick17.gui.component.Drawable;
import ch.trick17.gui.component.Shape;
import su.fhso.ln1.model.nodes.PipeNode;

public class UiPipe implements Drawable, Clickable {

    private final int x;
    private final int y;
    private final PipeNode node;

    public UiPipe(int x, int y, PipeNode node) {
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

        switch (node.getType()) {
            case "X" -> gui.drawImage("cross.png", x, y);
            case "L" -> gui.drawImage("L.png", x, y);
            case "T" -> gui.drawImage("t.png", x, y);
            case "I" -> gui.drawImage("i.png", x, y);
        }
    }

    @Override
    public Shape getInteractiveArea(Gui gui) {
        return null;
    }
}
