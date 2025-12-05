package su.fhso.ln1.view.components;

import ch.trick17.gui.Gui;
import ch.trick17.gui.component.Drawable;
import su.fhso.ln1.model.nodes.Node;
import su.fhso.ln1.model.nodes.ProducerNode;
import su.fhso.ln1.view.View;

public class ProducerView implements Drawable {

    private final int x;
    private final int y;
    private final ProducerNode node;

    public ProducerView(int x, int y, ProducerNode node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }

    @Override
    public void draw(Gui gui) {
        gui.drawImage("./producer-renewable.png", View.getScreenX(x), View.getScreenY(y));
    }
}
