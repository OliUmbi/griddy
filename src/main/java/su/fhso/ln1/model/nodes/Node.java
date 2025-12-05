package su.fhso.ln1.model.nodes;

import su.fhso.ln1.model.connections.Connection;


public abstract class Node implements INode {
    private final Connection connection;
    protected boolean isPowered = false;

    private Runnable onUpdate;

    protected Node(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getOrientation() {
        return connection.getRotation();
    }

    @Override
    public void updateOrientation(int change) {
        connection.setRotation(connection.getRotation() + change);
        onUpdate.run();
    }

    @Override
    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }

    public void setOnUpdate(Runnable onUpdate) {
        this.onUpdate = onUpdate;
    }

    public Connection getConnection() {
        return connection;
    }
}
