package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  private static ArrayList<Profile> profileDatabase = new ArrayList<Profile>();

  public Database() {}

  public static void addProfile(Profile newProfile) {
    profileDatabase.add(newProfile);
  }

  public static Profile getProfile(int index) {
    return profileDatabase.get(index);
  }

  public static void printProfileInfo(int index) {
    Profile inputProfile = Database.getProfile(index);
    String indexString = Integer.toString(index + 1);
    String username = inputProfile.getUsername();
    String age = inputProfile.getAge();
    MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(indexString, username, age);
  }
}
