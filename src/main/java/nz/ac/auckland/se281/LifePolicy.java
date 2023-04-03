package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  public LifePolicy(Profile policyOwner, String sumInsured) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_LIFE, policyOwner);
    policyOwner.addPolicy(this);
  }

  @Override
  public int getBasePremium() {
    // calculates base premium by using owner age.
    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    double percentToCalculate = 1 + ((double) ownerAge / 100);
    return (int) ((percentToCalculate / 100) * (this.getSumInsured()));
  }

  @Override
  public int getDiscountedBasePremium() {
    double discount = this.calculateDiscount();
    return (int) (this.getBasePremium() * discount);
  }

  @Override
  public String getType() {
    return "life";
  }

  @Override
  public void printPolicy() {
    MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
        Integer.toString(this.getSumInsured()),
        Integer.toString(this.getBasePremium()),
        Integer.toString(this.getDiscountedBasePremium()));
  }
}
