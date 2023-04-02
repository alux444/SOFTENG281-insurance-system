package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  Database profileInfos = new Database();

  public InsuranceSystem() {}

  public void printDatabase() {
    // prints database based on different scenarios : 0 profiles, 1 profile or 2+ profiles.
    // in the case of 2+ profiles, uses a for loop going through arraylist of usernames. (assumed
    // not needed for single profile, as only 1 profile.) in this case, index to print is hardcoded
    if (profileInfos.getProfilesNumber() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileInfos.getProfilesNumber()), "s", ".");
    } else if (profileInfos.getProfilesNumber() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileInfos.getProfilesNumber()), "", ":");
      // gets index value of profile and prints it using print profile.
      Profile toPrint = profileInfos.getProfile(0);
      profileInfos.printProfileInfo(toPrint, 0);
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(profileInfos.getProfilesNumber()), "s", ":");
      for (int i = 0; i < profileInfos.getProfilesNumber(); i++) {
        // uses a for loop to go through every profile index of the database to print every profile.
        Profile toPrint = profileInfos.getProfile(i);
        profileInfos.printProfileInfo(toPrint, i);
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // convert username to desired punctuation
    String upperUsername = userName.toUpperCase();
    String fixedName =
        upperUsername.charAt(0) + userName.substring(1, userName.length()).toLowerCase();

    // adds profile to the database as long as it passes all tests. sends success message.
    Profile newUser = new Profile(fixedName, age);
    profileInfos.addProfile(newUser);
  }

  public void loadProfile(String userName) {
    // convert username to desired punctuation
    String upperUsername = userName.toUpperCase();
    String fixedName =
        upperUsername.charAt(0) + userName.substring(1, userName.length()).toLowerCase();

    profileInfos.loadProfile(fixedName);
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
