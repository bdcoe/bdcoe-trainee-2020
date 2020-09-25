import 'package:shared_preferences/shared_preferences.dart';

class HelperFunctions{
  static String sharedPreferenceUserLoggedKey = "ISLOGGEDIN";
  static String sharedPreferenceUserNameKey ="USERNAMEKEY";
  static String sharedPreferenceUserEmailKey ="EMAILKEY";

  //saving data to sharedPreference
static Future<bool> saveUserLoggedSharedPreference(bool isUserLoggedIn) async{
  SharedPreferences prefs = await SharedPreferences.getInstance();
  return await prefs.setBool(sharedPreferenceUserLoggedKey, isUserLoggedIn);
}
static Future<bool> saveUserNameSharedPreference(String userName) async{
  SharedPreferences prefs = await SharedPreferences.getInstance();
  return await prefs.setString(sharedPreferenceUserNameKey, userName);
}
  static Future<bool> saveUserEmailSharedPreference(String userEmail) async{
    SharedPreferences prefs = await SharedPreferences.getInstance();
    return await prefs.setString(sharedPreferenceUserEmailKey, userEmail);
  }
  //get from shared
  static Future<bool> getUserLoggedSharedPreference() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    return prefs.getBool(sharedPreferenceUserLoggedKey);
  }
  static Future<String> getUserNameSharedPreference() async{
    SharedPreferences prefs = await SharedPreferences.getInstance();
    return prefs.getString(sharedPreferenceUserNameKey);
}
  static Future<String> getUserEmailSharedPreference() async{
    SharedPreferences prefs = await SharedPreferences.getInstance();
    return prefs.getString(sharedPreferenceUserEmailKey);
  }
}