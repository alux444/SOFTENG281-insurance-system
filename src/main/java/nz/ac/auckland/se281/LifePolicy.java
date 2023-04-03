package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  public LifePolicy(Profile policyOwner, String sumInsured) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_LIFE, policyOwner);
    // first, ensure owner of life policy isnt over maximum
    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    if (ownerAge > 100) {
      MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(this.getOwner().getUsername());
      return;
    }
  }

  @Override
  public int getBasePremium() {
    // calculates base premium by using owner age.
    double discount = this.calculateDiscount();

    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    double percentToCalculate = 1 + (ownerAge / 100);
    return (int) ((discount * percentToCalculate) * (this.getSumInsured()));
  }
}
