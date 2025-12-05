package su.fhso.ln1.view.components;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;
import ch.trick17.gui.component.*;
import su.fhso.ln1.model.nodes.PipeNode;
import su.fhso.ln1.model.nodes.SwitchNode;
import su.fhso.ln1.view.View;

public class SwitchView implements Drawable, Clickable, Hoverable {

    private final int x;
    private final int y;
    private final SwitchNode node;

    private boolean hovered = false;

    public SwitchView(int x, int y, SwitchNode node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }

    @Override
    public void draw(Gui gui) {
        gui.setColor(hovered ? Color.parseHexCode("#f1f1f1") : Color.parseHexCode("#ffffff"));
        gui.fillRect(View.getScreenX(x), View.getScreenY(y), View.getNodeWidth(), View.getNodeWidth());
        gui.drawImage(getAsset(), x, y, 1, Math.PI / 2 * node.getOrientation());
    }

    private String getAsset() {
        return switch (node.getType()) {
            case "X" -> "switch-cross.png";
            case "L" -> "switch-corner.png";
            case "T" -> "switch-cross.png"; // todo update
            case "I" -> "switch-straight.png";
            default -> "";
        };
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
    public Shape getInteractiveArea(Gui gui) {
        return new Rectangle(View.getScreenX(x), View.getScreenY(y), View.getNodeWidth(), View.getNodeWidth());
    }

    @Override
    public void onMouseEnter() {
        hovered = true;
    }

    @Override
    public void onMouseExit() {
        hovered = false;
    }
}
