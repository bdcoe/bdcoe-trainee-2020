import 'package:chatapplication/Widgets/signin.dart';
import 'package:chatapplication/Widgets/signup.dart';
import 'package:flutter/material.dart';

class Authenticate extends StatefulWidget {
  @override
  _AuthenticateState createState() => _AuthenticateState();
}

class _AuthenticateState extends State<Authenticate> {
  bool showSignIN = true;
  void toggleView() {
    setState(() {
      showSignIN = !showSignIN;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (showSignIN) {
      return SignIn(toggleView);
    } else {
      return SignUp(toggleView);
    }
  }
}
