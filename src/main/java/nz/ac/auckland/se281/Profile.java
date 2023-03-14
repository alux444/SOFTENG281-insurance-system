package nz.ac.auckland.se281;

public class Profile {

  // instance fields
  private String username;
  private String age;

  // static fields
  private static int profiles = 0;

  public Profile(String inputName, String inputAge) {
    this.username = inputName;
    this.age = inputAge;
    profiles++;
  }

  // get profile username
  public String getUsername() {
    return this.username;
  }
  // get profile age - converts age from string type to int
  public String getAge() {
    return this.age;
  }

  // checks username length (atleast 3 characters) returns a boolean true if it meets requirements
  public static boolean checkUsername(String username) {
    if (username.length() < 2) {
      return false;
    } else {
      return true;
    }
  }

  // checks age (positive number) returns a boolean true if it meets requirements
  public static boolean checkAge(String age) {
    if (Integer.valueOf(age) < 0) {
      return false;
    } else {
      return true;
    }
  }

  // get profiles number
  public static int getProfilesNumber() {
    return profiles;
  }
}
