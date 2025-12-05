package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.CrossConnection;

public class ProducerNode extends Node implements IProducerNode {
    public ProducerNode() {
        super(new CrossConnection());
    }
}
