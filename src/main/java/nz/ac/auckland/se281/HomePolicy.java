package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  // specific home policy variables
  private String address;
  private boolean rental;

  public HomePolicy(Profile policyOwner, String sumInsured, String address, String rental) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_HOME, policyOwner);
    this.address = address;
    if (rental == "yes") {
      this.rental = true;
    } else {
      this.rental = false;
    }
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
