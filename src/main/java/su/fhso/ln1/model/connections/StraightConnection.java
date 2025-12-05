package su.fhso.ln1.model.connections;

public class StraightConnection extends Connection {

    @Override
    public boolean connects(Orientation orientation) {
        return switch (orientation) {
            case NORTH, SOUTH -> getRotation() % 2 == 1;
            case EAST, WEST -> getRotation() % 2 == 0;
        };
    }
}
