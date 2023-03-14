package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  // arraylist for storing profiles
  private ArrayList<Profile> profileDatabase = new ArrayList<Profile>();

  // static private profiles
  private static int profiles = 0;

  public Database() {
    profileDatabase = new ArrayList<Profile>();
  }

  // adds profile to the database
  public void addProfile(Profile newProfile) {
    // checks username length (atleast 3 characters) sends error message if fail.
    if ((newProfile.getUsername()).length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(newProfile.getUsername());
      return;
    }
    for (int i = 0; i < newProfile.getAge().length(); i++) {
      // for loop checking for '.' in the case of a period in the age. sends error message if fails.
      char currentChar = newProfile.getAge().charAt(i);
      if (currentChar == '.') {
        MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUsername());
        return;
      }
      if (Integer.valueOf(newProfile.getAge()) < 0) {
        // checking the integer value of age - ensuring it is positive. sends error message if
        // fails.
        MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUsername());
        return;
      }
      if (profiles > 0) {
        // uses a for loop to go through profiles in an index, based on existing created profile
        // number. checking for duplicate usernames.
        for (int j = 0; j < profiles; j++) {
          Profile profileToCompare = profileDatabase.get(i);
          String nameToCompare = profileToCompare.getUsername();
          if (newProfile.getUsername().equals(nameToCompare)) {
            MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(newProfile.getUsername());
            return;
          }
        }
      }
      profileDatabase.add(newProfile);
      profiles++;
      MessageCli.PROFILE_CREATED.printMessage(newProfile.getUsername(), newProfile.getAge());
    }
  }

  // gets a profiles information
  public Profile getProfile(int index) {
    return profileDatabase.get(index);
  }

  // prints the information of a profile at a certain index of the database.
  public void printProfileInfo(int index) {
    Profile inputProfile = getProfile(index);
    String indexString = Integer.toString(index + 1);
    String username = inputProfile.getUsername();
    String age = inputProfile.getAge();
    MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(indexString, username, age);
  }

  public static int getProfilesNumber() {
    return profiles;
  }
}
