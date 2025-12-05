package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.Connection;
public class SwitchNode extends NodeWithConnectionType implements ISwitchNode {

    public SwitchNode(Connection connection) {
        super(connection);
    }
}
