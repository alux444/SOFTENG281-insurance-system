package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // instance fields
  private String username;
  private String age;

  // policy arraylist
  private ArrayList<Policy> policies = new ArrayList<Policy>();

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
