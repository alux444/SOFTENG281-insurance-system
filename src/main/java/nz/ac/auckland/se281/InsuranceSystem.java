package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  public InsuranceSystem() {
    Database profileInfo = new Database();
  }

  public void printDatabase() {
    // prints database based on different scenarios : 0 profiles, 1 profile or 2+ profiles.
    // in the case of 2+ profiles, uses a for loop going through arraylist of usernames. (assumed
    // not needed for single profile, as only 1 profile.)

    if (Profile.getProfilesNumber() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(Profile.getProfilesNumber()), "s", ".");
    } else if (Profile.getProfilesNumber() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(Profile.getProfilesNumber()), "", ":");
      Database.printProfileInfo(0);

    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          Integer.toString(Profile.getProfilesNumber()), "s", ":");
      for (int i = 0; i < Profile.getProfilesNumber(); i++) {
        Database.printProfileInfo(i);
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // convert username to desired punctuation
    String upperUsername = userName.toUpperCase();
    String fixedName =
        upperUsername.charAt(0) + userName.substring(1, userName.length()).toLowerCase();

    if (Profile.checkUsername(userName) == false) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(fixedName);
      return;
    }

    if (Profile.checkAge(age) == false) {
      MessageCli.INVALID_AGE.printMessage(age, fixedName);
      return;
    }

    if (Profile.checkDuplicate(fixedName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(fixedName);
    }

    Profile confirmedProfile = new Profile(fixedName, age);
    Database.addProfile(confirmedProfile);
    MessageCli.PROFILE_CREATED.printMessage(fixedName, age);
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
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
