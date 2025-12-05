package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.Connection;

public class PipeNode extends NodeWithConnectionType implements IPipeNode {

    public PipeNode(Connection connection) {
        super(connection);
    }
}
