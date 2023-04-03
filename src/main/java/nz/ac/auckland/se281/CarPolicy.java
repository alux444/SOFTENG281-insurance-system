package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  // specific car policy variables :
  private String makeAndModel;
  private String licensePlate;
  private boolean breakdown;

  // car policy constructor - takes specific car policy variables and sets them.
  public CarPolicy(
      Profile policyOwner,
      String sumInsured,
      String makeAndModel,
      String licensePlate,
      String breakdown) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_CAR, policyOwner);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    String warranty = breakdown.toUpperCase();
    if (warranty == "YES" || warranty == "Y") {
      this.breakdown = true;
    } else {
      this.breakdown = false;
    }
  }

  @Override
  public int getBasePremium() {
    // calcaultes base premium off owners age and if breakdown warranty is applied.

    // discounts for if owner has multiple policies.
    double discount = 1;
    if (this.getOwner().getPolicyAmount() == 2) {
      discount = 0.9;
    } else if (this.getOwner().getPolicyAmount() > 2) {
      discount = 0.8;
    }
    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    int breakdownFee = 0;
    if (breakdown == true) {
      breakdownFee = 80;
    }
    if (ownerAge < 25) {
      return (int) discount * ((this.getSumInsured() * 15 / 100) + breakdownFee);
    } else {
      return (int) discount * ((this.getSumInsured() / 10) + breakdownFee);
    }
  }
}
