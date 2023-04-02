package nz.ac.auckland.se281;

public abstract class Policy {

  // creating enums for policy types
  public enum PolicyType {
    POLICY_HOME,
    POLICY_CAR,
    POLICY_LIFE
  };

  // private shared policy variables
  private Profile policyOwner;
  private int sumInsured;
  private PolicyType policyType;

  public Policy(int sumInsured, PolicyType policyType, Profile policyOwner) {
    this.sumInsured = sumInsured;
    this.policyType = policyType;
    this.policyOwner = policyOwner;
  }

  public Profile getOwner() {
    return this.policyOwner;
  }

  public PolicyType getType() {
    return this.policyType;
  }

  public int getSumInsured() {
    return this.sumInsured;
  }

  public abstract int getBasePremium();
}
