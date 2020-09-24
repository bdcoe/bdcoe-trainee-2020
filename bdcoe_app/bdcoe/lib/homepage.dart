import 'package:bdcoe/app_dev.dart';
import 'package:bdcoe/bigdata_page.dart';
import 'package:carousel_pro/carousel_pro.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:bdcoe/cp_page.dart';
import 'package:bdcoe/ml_page.dart';
import 'reuse.dart';
import 'package:bdcoe/web_dev.dart';
import 'main_drawer.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    Widget imageCarousel = Container(
      margin: EdgeInsets.all(4.0),
      height: 210.0,
      child: Carousel(
        images: [
          AssetImage('images/inst1.jpg'),
          AssetImage('images/inst2.jpg'),
          AssetImage('images/inst3.jpg'),
          AssetImage('images/inst4.jpg'),
          AssetImage('images/inst5.jpg'),
          AssetImage('images/inst6.jpg'),
          AssetImage('images/inst7.jpg'),
          AssetImage('images/inst8.jpg'),
          AssetImage('images/inst9.jpg'),
          AssetImage('images/inst10.jpg'),
          AssetImage('images/inst11.jpg'),
          AssetImage('images/inst12.jpg'),
        ],
        autoplay: true,
        animationCurve: Curves.fastOutSlowIn,
        indicatorBgPadding: 0.1,
        dotIncreaseSize: 2.0,
        dotSize: 6.0,
        dotColor: Colors.blue[300],
      ),
    );

    return Scaffold(
      backgroundColor: Colors.grey[200],
      appBar: AppBar(
        title: Text('BDCOE'),
        backgroundColor: Colors.blue[700],
        elevation: 5.0,
        centerTitle: true,
      ),
      drawer: MainDrawer(),
      body: ListView(
        children: <Widget>[
          imageCarousel,
          Container(
            margin: EdgeInsets.all(13.0),
            decoration: BoxDecoration(
                color: Colors.white70,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(
                    color: Color.fromRGBO(140, 148, 251, 1),
                    blurRadius: 10.0,
                  )
                ]),
            child: Center(
              child: Text(
                'What we do ?',
                style: TextStyle(
                  fontSize: 20.0,
                  letterSpacing: 2.5,
                  fontFamily: 'Comfortaa',
                  fontWeight: FontWeight.bold,
                  color: Colors.blue[300],
                ),
              ),
            ),
          ),
          Reusable(
            Color.fromRGBO(0, 0, 255, 1),
            Color.fromRGBO(50, 50, 255, 0.7),
            Icons.developer_mode,
            'APP DEVELOPMENT',
            'A phone without good apps is like a bird without wing. Mobile apps reduce our work and help us in many different....Read more',
            Colors.greenAccent,
            () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) {
                  return App_Dev();
                }),
              );
            },
          ),
          Reusable(
            Color.fromRGBO(255, 0, 0, 1),
            Color.fromRGBO(255, 50, 50, 0.7),
            Icons.desktop_windows,
            'WEB DEVELOPMENT',
            'Despite being a centre for data analytics we dont just restrict our domain to big data analytics...  Read more',
            Colors.blueAccent,
            () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) {
                  return Web_Dev();
                }),
              );
            },
          ),
          Reusable(
            Color.fromRGBO(200, 25, 240, 1),
            Color.fromRGBO(50, 25, 50, 0.7),
            Icons.assessment,
            'COMPETETIVE\nPROGRAMMING',
            'Competitive programming is a mind sport usually held over the Internet or a local network,It is a  ...Read more',
            Colors.white,
            () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) {
                  return CP();
                }),
              );
            },
          ),
          Reusable(
            Color.fromRGBO(150, 255, 0, 0.5),
            Color.fromRGBO(100, 200, 100, 0.9),
            Icons.account_balance,
            '         BIG DATA',
            'Big Data analysis means fetching data from a particular source, storing it in cluster and processing ....Read more',
            Colors.red,
            () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) {
                  return Big_Data();
                }),
              );
            },
          ),
          Reusable(
            Color.fromRGBO(100, 200, 255, 1),
            Color.fromRGBO(155, 100, 200, 0.7),
            Icons.wb_incandescent,
            'MACHINE LEARNING',
            'Machine learning is an application of Artificial Intelligence (AI) that provides systems the ability to  ... Read more',
            Colors.yellow,
            () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) {
                  return ML();
                }),
              );
            },
          ),
        ],
      ),
    );
  }
}
