package su.fhso.ln1.model.connections;

public abstract class Connection {

    private int rotation;

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public abstract boolean connects(Orientation orientation);
}
