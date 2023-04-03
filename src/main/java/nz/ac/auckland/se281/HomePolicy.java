package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  // specific home policy variables
  private String address;
  private boolean rental;

  public HomePolicy(Profile policyOwner, String sumInsured, String address, String rental) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_HOME, policyOwner);
    this.address = address;
    String isRental = rental.toUpperCase();
    if (isRental == "YES" || isRental == "Y") {
      this.rental = true;
    } else {
      this.rental = false;
    }
    policyOwner.addPolicy(this);
  }

  @Override
  public int getBasePremium() {
    // calculates base premium off rates based on if home is a rental
    double discount = this.calculateDiscount();
    if (this.rental == true) {
      return (int) discount * (this.getSumInsured() / 50);
    } else {
      return (int) discount * (this.getSumInsured() / 100);
    }
  }

  @Override
  public String getType() {
    return "home";
  }
}
