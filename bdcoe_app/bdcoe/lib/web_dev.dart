import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:url_launcher/url_launcher.dart';

class Web_Dev extends StatefulWidget {
  @override
  _Web_DevState createState() => _Web_DevState();
}

class _Web_DevState extends State<Web_Dev> {
  website(String url) async {
    if (await canLaunch(url)) {
      await launch(url);
    } else {
      throw 'Could not launch';
    }
  }

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
                  height: 380.0,
                  decoration: BoxDecoration(
                    image: DecorationImage(
                      image: AssetImage('images/web_devbg.png'),
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
                              'Web Development',
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
                              'Despite being a centre for data analytics we don\'t just restrict our domain to big data analytics. We try to excel in every domain and thus we have members who are excellent web developers. We build websites and web applications based on the latest technologies in the market and using minimum resources.'
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
                  'Websites',
                  style: TextStyle(
                    color: Colors.black,
                    letterSpacing: 1.5,
                  ),
                ),
                SizedBox(
                  height: 20.0,
                  width: 150.0,
                  child: Divider(
                    color: Colors.black,
                  ),
                ),
                Row(
                  children: <Widget>[
                    GestureDetector(
                      onTap: () {
                        website('http://www.bdcoe.co.in/');
                      },
                      child: Container(
                        margin: EdgeInsets.only(left: 20.0),
                        height: 100.0,
                        width: 100.0,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          boxShadow: [
                            BoxShadow(
                              color: Color.fromRGBO(40, 245, 40, 0.9),
                              blurRadius: 15.0,
                            )
                          ],
                          image: DecorationImage(
                            image: AssetImage('images/bdcoe_logo.jpg'),
                            fit: BoxFit.fill,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  height: 25.0,
                ),
                Text(
                  'Members',
                  style: TextStyle(
                    color: Colors.black,
                    letterSpacing: 1.5,
                  ),
                ),
                SizedBox(
                  height: 25.0,
                  width: 150.0,
                  child: Divider(
                    color: Colors.black,
                  ),
                ),
                MemberList("PRAKANSHU SAHU"),
                SizedBox(height: 10.0),
                MemberList("KISHAN BARANWAL"),
                SizedBox(height: 10.0),
                MemberList("ANAND KUMAR"),
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
