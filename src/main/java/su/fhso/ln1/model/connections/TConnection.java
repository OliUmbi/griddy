package su.fhso.ln1.model.connections;

public class TConnection extends Connection {
    @Override
    public boolean connects(Orientation orientation) {
        return switch(orientation){
            case  NORTH -> getRotation() % 4 == 1 || getRotation() % 4 == 2 ||getRotation() % 4 == 3;
            case SOUTH -> getRotation() % 4 == 0 || getRotation() % 4 == 1 || getRotation() % 4 == 3;
            case EAST ->  getRotation() % 4 == 0 || getRotation() % 4 == 2 || getRotation() % 4 == 3;
            case WEST -> getRotation() % 4 == 0 || getRotation() % 4 == 1 ||  getRotation() % 4 == 2;
        };
    }
}
