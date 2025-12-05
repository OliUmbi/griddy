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
            case "X" -> "pipe-crossing.png";
            case "L" -> "pipe-corner.png";
            case "T" -> "pipe-crossing.png"; // todo update
            case "I" -> "pipe-straight.png";
            default -> "pipe-crossing.png";
        };
    }
}
