import 'package:chatapplication/Service/Auth.dart';
import 'package:chatapplication/Service/data.dart';
import 'package:chatapplication/screen/widget.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:chatapplication/helper/helper.dart';
import 'chatscreen.dart';

class SignIn extends StatefulWidget {
  final Function toggle;
  SignIn(this.toggle);
  @override
  _SignInState createState() => _SignInState();
}

class _SignInState extends State<SignIn> {
  final formKey = GlobalKey<FormState>();

  DatabaseMethods databaseMethods = new DatabaseMethods();

  AuthMethods authMethods =new AuthMethods();

  TextEditingController emailTextEditingController =
  new TextEditingController();
  TextEditingController passwordTextEditingController =
  new TextEditingController();

  bool isLoading =false;
  QuerySnapshot snapshotUserInfo;
  signIn(){
    if(formKey.currentState.validate()){
      setState(() {
        isLoading = false;
      });

      HelperFunctions.saveUserEmailSharedPreference(
          emailTextEditingController.text);
      databaseMethods.getUserByUserEmail(emailTextEditingController.text).then((val){
        snapshotUserInfo = val;
        HelperFunctions.saveUserNameSharedPreference(snapshotUserInfo.documents[0].data["name"]);
      });
      setState(() {
        isLoading = true;
      });

      authMethods.signInWithEmailAndPassword( emailTextEditingController.text,
          passwordTextEditingController.text).then((val){
            if(val != null){
              HelperFunctions.saveUserLoggedSharedPreference(true);
              Navigator.pushReplacement(
                  context, MaterialPageRoute(builder: (context) => ChatRoom()
              ));
            }
      });

    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBarMain(context),
      body: SingleChildScrollView(
        child: Container(
          height: MediaQuery.of(context).size.height - 50,
          alignment: Alignment.bottomCenter,
          padding: EdgeInsets.symmetric(
            horizontal: 20,
          ),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Image.asset(
                "images/png.png",
              ),
              Form(
                key: formKey,
                child: Column(children: [
                  TextFormField(
                    validator: (val) {
                      return RegExp(
                          r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+")
                          .hasMatch(val)
                          ? null
                          : "Please provide a correct Email";
                    },
                    controller: emailTextEditingController,
                    style: simpleTextDeco(),
                    decoration: textFieldDeco("E-mail"),
                  ),
                  TextFormField(
                    obscureText: true,
                    validator: (val) {
                      return val.length > 6
                          ? null
                          : "Please enter atleast 8 characters";
                    },
                    controller: passwordTextEditingController,
                    style: simpleTextDeco(),
                    decoration: textFieldDeco("Password"),
                  ),
                ],),
              ),
              SizedBox(
                height: 8,
              ),
              Container(
                alignment: Alignment.centerRight,
                child: Container(
                    padding: EdgeInsets.symmetric(horizontal: 8, vertical: 8),
                    child: Text(
                      "Forgot Password ?",
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 18,
                          fontFamily: "Bhaloo"),
                    )),
              ),
              SizedBox(
                height: 8,
              ),
              GestureDetector(
                onTap: (){
                  signIn();
                },
                child: Container(
                  alignment: Alignment.center,
                  width :MediaQuery.of(context).size.width,
                  padding: EdgeInsets.symmetric(vertical: 20),
                  decoration: BoxDecoration(
                      gradient: LinearGradient(colors: [
                        const Color(0xff007EF4),
                        const Color(0xff2A75BC)
                      ]),
                      borderRadius: BorderRadius.circular(40)),

                  child: Text(
                    "Sign In",
                    style: TextStyle(color: Colors.white, fontSize: 20),
                  ),
                ),
              ),
              SizedBox(
                height: 16,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    "First time to GapShap ? ",
                    style: TextStyle(
                        color: Colors.white,
                        fontSize: 18,
                        fontFamily: "Bhaloo"),
                  ),
                  GestureDetector(
                    onTap: () {
                      widget.toggle();
                    },
                    child: Container(
                      padding: EdgeInsets.symmetric(vertical: 10),
                      child: Text(
                        "Join Us",
                        style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.w700,
                            fontSize: 18,
                            fontFamily: "Bhaloo",
                            decoration: TextDecoration.underline),
                      ),
                    ),
                  )
                ],
              ),
              SizedBox(
                height: 80,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
