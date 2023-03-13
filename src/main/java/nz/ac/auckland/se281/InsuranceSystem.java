package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private static int profileNum = 0;
  private static ArrayList<String> userNames = new ArrayList<String>();
  private static ArrayList<String> ages = new ArrayList<String>();

  public InsuranceSystem() {}

  public void printDatabase() {
    String profiles = Integer.toString(profileNum);
    if (profileNum == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profiles, "s", ".");
    } else if (profileNum == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profiles, "", ":");
      System.out.println(userNames.size() + ". " + userNames.get(0) + ", " + ages.get(0));
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(profiles, "s", ":");
      for (int i = 0; i < userNames.size(); i++) {
        int rank = i + 1;
        System.out.println(rank + ". " + userNames.get(i) + ", " + ages.get(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    userName = userName.toUpperCase();
    String fixedName = userName.charAt(0) + userName.substring(1, userName.length()).toLowerCase();
    // convert username to proper punctuation form (i.e aLeX -> Alex),
    if (userName.length() < 3) {
      // sends error message if the length of username is too short. (<3 characters)
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return;
    }
    if (Integer.parseInt(age) < 0) {
      // sends error message if age is not positive.
      MessageCli.INVALID_AGE.printMessage();
      return;
    }
    // after ensuring username is atleast 3 characters and age is a positive integer...
    if (profileNum > 0) {
    // checking for duplicate usernames. If username is a dupe, return error message.
      for (int i = 0; i < userNames.size(); i++) {
        if (fixedName.equals(userNames.get(i))) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(fixedName);
          return;
        }
      }
    }

    userNames.add(fixedName);
    ages.add(age);
    profileNum++;
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
