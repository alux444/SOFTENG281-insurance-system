package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  // specific home policy variables
  private String address;
  private boolean rental;

  public HomePolicy(Profile policyOwner, int sumInsured, String address, boolean rental) {
    super(sumInsured, Policy.PolicyType.POLICY_HOME, policyOwner);
    this.address = address;
    this.rental = rental;
  }

  @Override
  public int getBasePremium() {
    if (this.rental == true) {
      return this.getSumInsured() / 50;
    } else {
      return this.getSumInsured() / 100;
    }
  }
}
