package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.CrossConnection;

public class ConsumerNode extends Node implements IConsumerNode {
    public ConsumerNode() {
        super(new CrossConnection());
    }
}
