package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // instance fields
  private String username;
  private String age;

  // policy arraylist
  private ArrayList<Policy> policies = new ArrayList<Policy>();

  // returns amount of policies
  public int getPolicyAmount() {
    return policies.size();
  }

  // returns policy of specific index
  public Policy getPolicy(int index) {
    return policies.get(index);
  }

  // calculates total cost of policies
  public int getTotalCost() {
    int cost = 0;
    for (Policy policy : policies) {
      cost += policy.getDiscountedBasePremium();
    }
    return cost;
  }

  // checks if profile already has life policy
  public boolean lifeInsured() {
    boolean insured = false;
    for (Policy policy : policies) {
      if (policy.getType() == "life") {
        insured = true;
      }
    }
    return insured;
  }

  // adds new policy for profile
  public void addPolicy(Policy policyToAdd) {
    policies.add(policyToAdd);
    MessageCli.NEW_POLICY_CREATED.printMessage(policyToAdd.getType(), this.username);
    return;
  }

  // profile constructor
  public Profile(String inputName, String inputAge) {
    this.username = inputName;
    this.age = inputAge;
  }

  // get profile username
  public String getUsername() {
    return this.username;
  }

  // get profile age - converts age from string type to int
  public String getAge() {
    return this.age;
  }
}
