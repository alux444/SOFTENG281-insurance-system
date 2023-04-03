package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  // arraylist for storing profiles
  private ArrayList<Profile> profileDatabase = new ArrayList<Profile>();

  // loaded profile status
  private boolean loadedStatus = false;
  private Profile loadedProfile = null;

  public Database() {
    profileDatabase = new ArrayList<Profile>();
  }

  // adds profile to the database, returning true if a profile is added
  public void addProfile(Profile newProfile) {
    if (loadedStatus == true) {
      // checks if a profile is loaded, if so, sends error message.
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile.getUsername());
      return;
    }
    // checks username length (atleast 3 characters) sends error message if fail.
    if ((newProfile.getUsername()).length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(newProfile.getUsername());
      return;
    }
    for (int i = 0; i < newProfile.getAge().length(); i++) {
      // for loop checking for 0 to 9s ONLY in age. otherwise, any letters, or characters all
      // removed (including period for decimals)
      char currentChar = newProfile.getAge().charAt(i);
      if (currentChar != '0'
          && currentChar != '1'
          && currentChar != '2'
          && currentChar != '3'
          && currentChar != '4'
          && currentChar != '5'
          && currentChar != '6'
          && currentChar != '7'
          && currentChar != '8'
          && currentChar != '9') {
        MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUsername());
        return;
      }
    }
    if (Integer.valueOf(newProfile.getAge()) < 0) {
      // checking the integer value of age - ensuring it is positive. sends error message if
      // fails.
      MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUsername());
      return;
    }
    if (profileDatabase.size() > 0) {
      // uses a for loop to go through profiles in an index, based on existing created profile
      // number. checking for duplicate usernames.
      for (int j = 0; j < profileDatabase.size(); j++) {
        Profile profileToCompare = profileDatabase.get(j);
        String nameToCompare = profileToCompare.getUsername();
        if (newProfile.getUsername().equals(nameToCompare)) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(newProfile.getUsername());
          return;
        }
      }
    }
    profileDatabase.add(newProfile);
    MessageCli.PROFILE_CREATED.printMessage(newProfile.getUsername(), newProfile.getAge());
    return;
  }

  // gets a profiles information
  public Profile getProfile(int index) {
    return profileDatabase.get(index);
  }

  // prints the information of a profile at a certain index of the database.
  public void printProfileInfo(Profile inputProfile, int index) {
    String plural = "ies";
    if (inputProfile.getPolicyAmount() == 1) {
      plural = "y";
    }
    // if the current profile is the loaded profile, print *** before the profile information.
    if (inputProfile == loadedProfile) {
      System.out.print("***");
    }
    MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
        Integer.toString(index + 1),
        "",
        inputProfile.getUsername(),
        inputProfile.getAge(),
        Integer.toString(inputProfile.getPolicyAmount()),
        plural,
        Integer.toString(inputProfile.getTotalCost()));
    for (int i = 0; i < inputProfile.getPolicyAmount(); i++) {
      inputProfile.getPolicy(i).printPolicy();
    }
  }

  public int getProfilesNumber() {
    return profileDatabase.size();
  }

  public void loadProfile(String user) {
    // go through profiles in database to find matching username
    for (Profile profile : profileDatabase) {
      if (profile.getUsername().equals(user)) {
        MessageCli.PROFILE_LOADED.printMessage(profile.getUsername());
        // once found, sets status of loaded to true and the current loaded profile to the matching
        // username.
        this.loadedStatus = true;
        this.loadedProfile = profile;
        return;
      }
    }
    // if no such profile can be found, send error message.
    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(user);
    return;
  }

  public void unloadProfile() {
    // if no profile is loaded, send error message.
    if (loadedStatus == false) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
      return;
    }
    // if a profile is loaded, send message and set loaded status to false.
    MessageCli.PROFILE_UNLOADED.printMessage(loadedProfile.getUsername());
    this.loadedStatus = false;
    this.loadedProfile = null;
    return;
  }

  public Profile getLoadedProfile() {
    return loadedProfile;
  }

  public void deleteProfile(String username) {
    // searches for profile with matching username
    for (Profile profile : profileDatabase) {
      if (profile.getUsername().equals(username)) {
        // when profile is found, ensure profile isnt loaded profile
        if (profile == loadedProfile) {
          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(username);
          return;
        }
        profileDatabase.remove(profile);
        MessageCli.PROFILE_DELETED.printMessage(username);
        return;
      }
    }
    // if no profile is found, send error message.
    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(username);
    return;
  }
}
