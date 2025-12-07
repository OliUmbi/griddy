package su.fhso.ln1.model.connections;

public class CrossConnection extends Connection {

    public CrossConnection() {
    }

    @Override
    public boolean connects(Orientation orientation) {
        return true;
    }
}
