package su.fhso.ln1.model.nodes;

public interface Node {

    int getOrientation();

    boolean isPowered();

    void updateOrientation(int change);
}
