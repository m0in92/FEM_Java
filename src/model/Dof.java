package model;

public class Dof {

    public int dofNum;
    // value can be interpreted as the force or displacement.
    public double value;

    public Dof(int dofNum, double value) {
        this.dofNum = dofNum;
        this.value = value;
    }
}
