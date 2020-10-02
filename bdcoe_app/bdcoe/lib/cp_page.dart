import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:url_launcher/url_launcher.dart';

class CP extends StatefulWidget {
  @override
  _CPState createState() => _CPState();
}

class _CPState extends State<CP> {
  codeProf(String url) async {
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
                  height: 410.0,
                  decoration: BoxDecoration(
                    image: DecorationImage(
                      image: AssetImage('images/cp.png'),
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
                        left: 80.0,
                        child: Container(
                          margin: EdgeInsets.only(top: 30),
                          child: Center(
                            child: Text(
                              'Competetive\nProgramming',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 38,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                      ),
                      Positioned(
                        top: 125.0,
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
                              'Competitive programming is a mind sport usually held over the Internet or a local network, involving participants trying to program according to provided specifications. Competitive programming is recognized and supported by several multinational companies such as Google and Facebook.'
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
                  'Codeforces Profile\'s',
                  style: TextStyle(
                    color: Colors.black,
                    letterSpacing: 1.5,
                  ),
                ),
                SizedBox(
                  height: 15.0,
                  width: 160.0,
                  child: Divider(
                    color: Colors.black,
                  ),
                ),
                SizedBox(
                  height: 25.0,
                ),
                Row(
                  children: <Widget>[
                    Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        GestureDetector(
                          onTap: () {
                            codeProf(
                                'https://codeforces.com/profile/LazyC0d3r');
                          },
                          child: Container(
                            margin: EdgeInsets.only(left: 20.0),
                            height: 80.0,
                            width: 80.0,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(10),
                              boxShadow: [
                                BoxShadow(
                                  color: Color.fromRGBO(140, 148, 251, 0.9),
                                  blurRadius: 20.0,
                                )
                              ],
                              image: DecorationImage(
                                image: AssetImage('images/karanyadav_cf.jpg'),
                                fit: BoxFit.fill,
                              ),
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 5.0,
                        ),
                        Padding(
                          padding: const EdgeInsets.only(left: 20.0),
                          child: Text(
                            'KARAN YADAV\n',
                            style: TextStyle(
                              fontSize: 13.0,
                              color: Colors.black,
                            ),
                            textAlign: TextAlign.justify,
                          ),
                        ),
                      ],
                    ),
                    SizedBox(
                      width: 20.0,
                    ),
                    Column(
                      children: <Widget>[
                        GestureDetector(
                          onTap: () {
                            codeProf(
                                'https://codeforces.com/profile/lucifer1010');
                          },
                          child: Container(
                            height: 80.0,
                            width: 80.0,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(10),
                              boxShadow: [
                                BoxShadow(
                                  color: Color.fromRGBO(255, 100, 100, 0.9),
                                  blurRadius: 20.0,
                                )
                              ],
                              image: DecorationImage(
                                image: AssetImage('images/devanshsriv_cf.jpg'),
                                fit: BoxFit.fill,
                              ),
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 5.0,
                        ),
                        Padding(
                          padding: EdgeInsets.all(0.0),
                          child: Text(
                            'DEVANSH\nSRIVASTAVA',
                            style: TextStyle(
                              fontSize: 13.0,
                              color: Colors.black,
                            ),
                            textAlign: TextAlign.justify,
                          ),
                        ),
                      ],
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
                MemberList("KARAN YADAV"),
                SizedBox(height: 10.0),
                MemberList("DEVANSH SRIVASTAVA"),
                SizedBox(height: 10.0),
                MemberList("TANYA AGARWAL"),
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
