package nz.ac.auckland.se281;

public abstract class Policy {

  // creating enums for policy types
  private enum PolicyType {
    POLICY_HOME,
    POLICY_CAR,
    POLICY_LIFE
  };

  // private shared policy variables
  private int sumInsured;
  private PolicyType type;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public int getSumInsured() {
    return this.sumInsured;
  }

  public abstract int getBasePremium();
}
