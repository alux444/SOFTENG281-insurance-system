package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  // specific car policy variables :
  private String makeAndModel;
  private String licensePlate;
  private boolean breakdown;

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
    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    int breakdownFee = 0;
    if (breakdown == true) {
      breakdownFee = 80;
    }
    if (ownerAge < 25) {
      return (this.getSumInsured() * 15 / 100) + breakdownFee;
    } else {
      return (this.getSumInsured() / 10) + breakdownFee;
    }
  }
}
