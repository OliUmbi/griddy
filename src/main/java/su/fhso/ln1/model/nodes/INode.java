package su.fhso.ln1.model.nodes;

public interface INode {

    int getOrientation();

    boolean isPowered();

    void updateOrientation(int change);
}
