package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  // specific home policy variables
  private String address;
  private boolean rental;

  public HomePolicy(Profile policyOwner, String sumInsured, String address, String rental) {
    super(Integer.parseInt(sumInsured), Policy.PolicyType.POLICY_HOME, policyOwner);
    this.address = address;
    this.rental = false;
    String isRental = rental.toUpperCase();
    if (isRental.equals("YES") || isRental.equals("Y")) {
      this.rental = true;
    }
    policyOwner.addPolicy(this);
  }

  @Override
  public int getBasePremium() {
    // calculates base premium off rates based on if home is a rental
    if (this.rental == true) {
      return (int) (this.getSumInsured() / 50);
    }
    return (int) (this.getSumInsured() / 100);
  }

  @Override
  public int getDiscountedBasePremium() {
    double discount = this.calculateDiscount();
    return (int) (this.getBasePremium() * discount);
  }

  @Override
  public String getType() {
    return "home";
  }

  @Override
  public void printPolicy() {
    MessageCli.PRINT_DB_HOME_POLICY.printMessage(
        this.address,
        Integer.toString(this.getSumInsured()),
        Integer.toString(this.getBasePremium()),
        Integer.toString(this.getDiscountedBasePremium()));
  }
}
