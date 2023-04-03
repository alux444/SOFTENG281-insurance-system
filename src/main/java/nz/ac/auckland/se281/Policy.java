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

  // calculates discount based on amount of policies :
  // 10% for 2 policies, 20% for 3+
  public double calculateDiscount() {
    double discount = 1;
    if (this.getOwner().getPolicyAmount() == 2) {
      discount = 0.9;
    } else if (this.getOwner().getPolicyAmount() > 2) {
      discount = 0.8;
    }
    return discount;
  }

  // returns the policy owner
  public Profile getOwner() {
    return this.policyOwner;
  }

  // returns the type of policy (abstract method)
  public abstract String getType();

  // returns the sum insured.
  public int getSumInsured() {
    return this.sumInsured;
  }

  // abstract method of returning base premium (no discount)
  public abstract int getBasePremium();

  // abstract method of returning any discounts for base premium
  public abstract int getDiscountedBasePremium();

  // abstract method of printing policy info
  public abstract void printPolicy();
}
