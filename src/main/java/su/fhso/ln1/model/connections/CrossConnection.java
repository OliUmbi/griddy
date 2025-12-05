package su.fhso.ln1.model.connections;

public class CrossConnection implements Connection {

    @Override
    public boolean connects(Orientation orientation) {
        return true;
    }
}
