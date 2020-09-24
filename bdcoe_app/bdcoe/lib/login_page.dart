import 'package:bdcoe/homepage.dart';
import 'package:bdcoe/signup_page.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter/material.dart';
import 'package:modal_progress_hud/modal_progress_hud.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _auth = FirebaseAuth.instance;
  String email;
  String password;
  String error;
  bool hidepass = true;

  bool spinner = false;
  void togglepass() {}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: ModalProgressHUD(
        inAsyncCall: spinner,
        child: SingleChildScrollView(
          child: Container(
            child: Column(
              children: <Widget>[
                Container(
                  height: 360,
                  decoration: BoxDecoration(
                    image: DecorationImage(
                        image: AssetImage('images/background.png'),
                        fit: BoxFit.fill),
                  ),
                  child: Stack(
                    children: <Widget>[
                      Positioned(
                        left: 40,
                        width: 80,
                        height: 200,
                        child: Container(
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage('images/light-1.png'),
                            ),
                          ),
                        ),
                      ),
                      Positioned(
                        left: 160,
                        width: 80,
                        height: 150,
                        child: Container(
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage('images/light-2.png'),
                            ),
                          ),
                        ),
                      ),
                      Positioned(
                        right: 40,
                        top: 30,
                        width: 80,
                        height: 150,
                        child: Container(
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage('images/clock.png'),
                            ),
                          ),
                        ),
                      ),
                      Positioned(
                        child: Container(
                          margin: EdgeInsets.only(top: 50),
                          child: Center(
                            child: Text(
                              'Login',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 40,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                Padding(
                  padding: EdgeInsets.all(30.0),
                  child: Column(
                    children: <Widget>[
                      showAlert(),
                      Container(
                        padding: EdgeInsets.all(5.0),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            borderRadius: BorderRadius.circular(10),
                            boxShadow: [
                              BoxShadow(
                                color: Color.fromRGBO(140, 148, 251, 0.4),
                                blurRadius: 20.0,
                              )
                            ]),
                        child: Column(
                          children: <Widget>[
                            Container(
                              padding: EdgeInsets.all(8.0),
                              decoration: BoxDecoration(
                                border: Border(
                                  bottom: BorderSide(
                                    color: Colors.grey[100],
                                  ),
                                ),
                              ),
                              child: TextField(
                                onChanged: (value) {
                                  email = value;
                                },
                                keyboardType: TextInputType.emailAddress,
                                decoration: InputDecoration(
                                  border: InputBorder.none,
                                  hintText: 'Email',
                                  hintStyle: TextStyle(
                                    color: Colors.grey[500],
                                  ),
                                ),
                              ),
                            ),
                            Container(
                              padding: EdgeInsets.all(8.0),
                              child: TextField(
                                onChanged: (value) {
                                  password = value;
                                },
                                obscureText: hidepass,
                                decoration: InputDecoration(
                                  suffixIcon: hidepass == true
                                      ? IconButton(
                                          icon: Icon(Icons.visibility_off),
                                          onPressed: () {
                                            setState(() {
                                              hidepass = !hidepass;
                                            });
                                          },
                                        )
                                      : IconButton(
                                          icon: Icon(Icons.visibility),
                                          onPressed: () {
                                            setState(() {
                                              hidepass = !hidepass;
                                            });
                                          },
                                        ),
                                  border: InputBorder.none,
                                  hintText: 'Password',
                                  hintStyle: TextStyle(
                                    color: Colors.grey[500],
                                  ),
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                      SizedBox(
                        height: 40.0,
                      ),
                      GestureDetector(
                        onTap: () async {
                          setState(() {
                            spinner = true;
                          });
                          try {
                            final user = await _auth.signInWithEmailAndPassword(
                                email: email, password: password);
                            if (user != null) {
                              SharedPreferences prefs =
                                  await SharedPreferences.getInstance();
                              prefs.setString('email', email);
                              Navigator.push(context,
                                  MaterialPageRoute(builder: (context) {
                                return HomePage();
                              }));
                            }
                            setState(() {
                              spinner = false;
                            });
                          } catch (e) {
                            print(e.message);
                            setState(() {
                              spinner = false;
                              error = e.code;
                            });
                          }
                        },
                        child: Container(
                          height: 50.0,
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(10),
                            gradient: LinearGradient(
                              colors: [
                                Color.fromRGBO(140, 148, 251, 1),
                                Color.fromRGBO(140, 148, 251, 0.6),
                              ],
                            ),
                          ),
                          child: Center(
                            child: Text(
                              'Login',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 17.0,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                      ),
                      SizedBox(height: 40.0),
                      GestureDetector(
                        onTap: () {
                          Navigator.push(context,
                              MaterialPageRoute(builder: (context) {
                            return Signup();
                          }));
                        },
                        child: Text(
                          'New User ? SIGNUP',
                          style: TextStyle(
                            color: Color.fromRGBO(140, 148, 251, 1),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget showAlert() {
    if (error != null) {
      return Container(
        color: Colors.yellow,
        width: double.infinity,
        padding: EdgeInsets.all(8.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Padding(
              padding: const EdgeInsets.all(5.0),
              child: Icon(
                Icons.error,
              ),
            ),
            Expanded(
              child: Text(
                error,
                maxLines: 4,
              ),
            ),
            Padding(
              padding: EdgeInsets.all(2.0),
              child: IconButton(
                  icon: Icon(Icons.close),
                  onPressed: () {
                    setState(() {
                      error = null;
                    });
                  }),
            ),
          ],
        ),
      );
    }
    return SizedBox(
      height: 0.0,
    );
  }
}
