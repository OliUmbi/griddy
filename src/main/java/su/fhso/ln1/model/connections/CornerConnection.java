package su.fhso.ln1.model.connections;

public class CornerConnection extends Connection {

    public CornerConnection() {
    }

    public CornerConnection(int rotation) {
        super(rotation);
    }

    @Override
    public boolean connects(Orientation orientation) {
        return switch(orientation){
            case NORTH -> getRotation() % 4 == 1 || getRotation() % 4 == 2;
            case SOUTH -> getRotation() % 4 == 0 || getRotation() % 4 == 3;
            case EAST -> getRotation() % 4 == 2 || getRotation() % 4 == 3;
            case WEST -> getRotation() % 4 == 0 || getRotation() % 4 == 1;
        };
    }
}
