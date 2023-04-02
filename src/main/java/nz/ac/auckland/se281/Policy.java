package nz.ac.auckland.se281;

public abstract class Policy {
  private int sumInsured;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }
}
