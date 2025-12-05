package su.fhso.ln1.model.connections;

public class StraightConnection implements Connection {

    @Override
    public boolean connects(Orientation orientation) {
        return false;
    }
}
