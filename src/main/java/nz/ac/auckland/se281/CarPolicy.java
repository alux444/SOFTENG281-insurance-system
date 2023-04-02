package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  // specific car policy variables :
  private String makeAndModel;
  private String licensePlate;
  private boolean breakdown;

  public CarPolicy(Profile policyOwner, int sumInsured, String makeAndModel, String licensePlate, boolean breakdown) {
    super(sumInsured, Policy.PolicyType.POLICY_CAR, policyOwner);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdown = breakdown;
  }
}
