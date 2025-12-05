package su.fhso.ln1.view.components;

import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Drawable;
import su.fhso.ln1.model.nodes.PipeNode;
import su.fhso.ln1.view.View;

public class PipeView implements Drawable {

    private final int x;
    private final int y;
    private final PipeNode node;

    public PipeView(int x, int y, PipeNode node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }

    @Override
    public void draw(Gui gui) {
        gui.drawImage(getAsset(), View.getScreenX(x), View.getScreenY(y), 1, Math.PI / 2 * node.getOrientation());
    }

    private String getAsset() {
        return switch (node.getType()) {
            case "X" -> node.isPowered() ? "./pipe-x-active.png" : "./pipe-x-inactive.png";
            case "L" -> node.isPowered() ? "./pipe-l-active.png" : "./pipe-l-inactive.png";
            case "T" -> node.isPowered() ? "./pipe-t-active.png" : "./pipe-t-inactive.png";
            case "I" -> node.isPowered() ? "./pipe-i-active.png" : "./pipe-i-inactive.png";
            default -> "./pipe-x-inactive.png";
        };
    }
}
