package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.*;

public class NodeWithConnectionType extends Node {

    private final String type;

    public NodeWithConnectionType(Connection connection) {
        super(connection);
        if (connection instanceof CrossConnection) type = "X";
        else if (connection instanceof StraightConnection) type = "I";
        else if (connection instanceof CornerConnection) type = "L";
        else if (connection instanceof TConnection) type = "T";
        else {
            System.err.println("not implemented connection type " + connection);
            type = null;
        }
    }

    public String getType() {
        return type;
    }
}
