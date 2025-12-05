package su.fhso.ln1.model.connections;

public class CrossConnection extends Connection {

    @Override
    public boolean connects(Orientation orientation) {
        return true;
    }
}
