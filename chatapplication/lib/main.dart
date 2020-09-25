import 'package:chatapplication/Widgets/convo_screen.dart';
import 'package:chatapplication/helper/authencate.dart';
import 'package:chatapplication/helper/helper.dart';
import 'package:flutter/material.dart';
import 'Widgets/chatscreen.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  bool userIsLoggedIn = false;
  @override
  void initState() {
    getLoggedInState();
    super.initState();
  }
  getLoggedInState()async{
    await HelperFunctions.getUserLoggedSharedPreference().then((value){
      setState(() {
        userIsLoggedIn = value;
      });
    });
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'GapShap App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        scaffoldBackgroundColor: Color(0xff1F1F1F),
        primarySwatch: Colors.red,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
        home: userIsLoggedIn != null ?  userIsLoggedIn ? ChatRoom() : Authenticate()
            : Container(
        child: Center(
        child: Authenticate(),
    ),),
    );
  }
}
