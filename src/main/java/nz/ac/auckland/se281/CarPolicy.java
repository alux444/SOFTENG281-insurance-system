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
    policyOwner.addPolicy(this);
  }

  @Override
  public int getBasePremium() {
    // calcaultes base premium off owners age and if breakdown warranty is applied.
    int ownerAge = Integer.parseInt((this.getOwner()).getAge());
    int breakdownFee = 0;
    if (breakdown == true) {
      breakdownFee = 80;
    }
    if (ownerAge < 25) {
      return (int) (this.getSumInsured() * 15 / 100) + breakdownFee;
    } else {
      return (int) (this.getSumInsured() / 10) + breakdownFee;
    }
  }

  @Override
  public int getDiscountedBasePremium() {
    double discount = this.calculateDiscount();
    return (int) (this.getBasePremium() * discount);
  }

  @Override
  public String getType() {
    return "car";
  }

  @Override
  public void printPolicy() {
    MessageCli.PRINT_DB_CAR_POLICY.printMessage(
        this.makeAndModel,
        Integer.toString(this.getSumInsured()),
        Integer.toString(this.getBasePremium()),
        Integer.toString(this.getDiscountedBasePremium()));
  }
}
