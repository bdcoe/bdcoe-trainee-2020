import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:store_redirect/store_redirect.dart';
import 'package:animated_text_kit/animated_text_kit.dart';

class App_Dev extends StatefulWidget {
  @override
  _App_DevState createState() => _App_DevState();
}

class _App_DevState extends State<App_Dev> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: ListView(
          children: <Widget>[
            Column(
              children: <Widget>[
                Container(
                  height: 410.0,
                  decoration: BoxDecoration(
                    image: DecorationImage(
                      image: AssetImage('images/app_devbg.png'),
                      fit: BoxFit.fill,
                    ),
                  ),
                  child: Stack(
                    children: <Widget>[
                      Positioned(
                        top: 10.0,
                        left: 10.0,
                        child: GestureDetector(
                          onTap: () {
                            Navigator.pop(context);
                          },
                          child: Icon(
                            Icons.arrow_back_rounded,
                            color: Colors.white,
                            size: 30.0,
                          ),
                        ),
                      ),
                      Positioned(
                        top: 10.0,
                        left: 30.0,
                        child: Container(
                          margin: EdgeInsets.only(top: 30),
                          child: Center(
                            child: Text(
                              'App Development',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 40,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                      ),
                      Positioned(
                        top: 100.0,
                        child: Container(
                          height: 200.0,
                          width: 350.0,
                          margin: EdgeInsets.all(14.0),
                          child: TypewriterAnimatedTextKit(
                            repeatForever: false,
                            totalRepeatCount: 1,
                            displayFullTextOnTap: true,
                            speed: Duration(microseconds: 10000),
                            text: [
                              'A phone without good apps is like a bird without wing. Mobile apps reduce our work and help us in many different ways whether it is education, entertainment or paying grocery bills and in many more things. We at Big Data Centre of Excellence have experts who can develop apps for both android and Ios devices.'
                            ],
                            textStyle: TextStyle(
                              fontSize: 17.0,
                              color: Colors.white,
                            ),
                            textAlign: TextAlign.justify,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                Text(
                  'Apps by BDCOE',
                  style: TextStyle(
                    color: Colors.black,
                    letterSpacing: 1.5,
                  ),
                ),
                SizedBox(
                  height: 15.0,
                  width: 150.0,
                  child: Divider(
                    color: Colors.black,
                  ),
                ),
                SizedBox(
                  height: 25.0,
                ),
                Row(
                  children: <Widget>[
                    GestureDetector(
                      onTap: () {
                        StoreRedirect.redirect(
                            androidAppId: "com.bdcoe.abhiyantriki");
                      },
                      child: Container(
                        margin: EdgeInsets.only(left: 20.0),
                        height: 100.0,
                        width: 100.0,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          boxShadow: [
                            BoxShadow(
                              color: Color.fromRGBO(140, 148, 251, 0.9),
                              blurRadius: 20.0,
                            )
                          ],
                          image: DecorationImage(
                            image: AssetImage('images/abhi_icon.png'),
                            fit: BoxFit.fill,
                          ),
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 25.0,
                    ),
                    GestureDetector(
                      onTap: () {
                        StoreRedirect.redirect(
                            androidAppId: "com.bdcoe.saksham");
                      },
                      child: Container(
                        height: 100.0,
                        width: 100.0,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          boxShadow: [
                            BoxShadow(
                              color: Color.fromRGBO(255, 100, 100, 0.9),
                              blurRadius: 20.0,
                            )
                          ],
                          image: DecorationImage(
                            image: AssetImage('images/shaksham_appicon.png'),
                            fit: BoxFit.fill,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  height: 60.0,
                  width: 200.0,
                  child: Divider(
                    color: Colors.grey[600],
                  ),
                ),
                Text(
                  'Members',
                  style: TextStyle(
                    color: Colors.black,
                    letterSpacing: 1.5,
                  ),
                ),
                SizedBox(
                  height: 20.0,
                ),
                MemberList("TANYA AGARWAL"),
                SizedBox(height: 10.0),
                MemberList("RIYA GARG"),
                SizedBox(height: 10.0),
                MemberList("SHASHANK SAHAI"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

class MemberList extends StatelessWidget {
  MemberList(this.name);
  String name;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 10.0),
      child: ListTile(
        tileColor: Colors.grey[100],
        contentPadding: EdgeInsets.fromLTRB(25.0, 0.0, 0.0, 0.0),
        leading: Padding(
          padding: const EdgeInsets.only(right: 22.0),
          child: CircleAvatar(
            radius: 30.0,
            backgroundImage: AssetImage('images/dummy_profile.jpg'),
          ),
        ),
        title: Text(
          name,
          style: TextStyle(
            fontWeight: FontWeight.bold,
            fontFamily: 'SourceCodePro',
            letterSpacing: 1.2,
            fontSize: 18.0,
          ),
        ),
      ),
    );
  }
}
