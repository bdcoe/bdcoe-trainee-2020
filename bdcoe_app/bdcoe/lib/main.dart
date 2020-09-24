import 'package:bdcoe/login_page.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:bdcoe/homepage.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:shared_preferences/shared_preferences.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(
    MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Bdcoe(), //email == null ? LoginPage() : HomePage(),
    ),
  );
}

class Bdcoe extends StatefulWidget {
  @override
  _BdcoeState createState() => _BdcoeState();
}

class _BdcoeState extends State<Bdcoe> {
  @override
  void initState() {
    super.initState();

    Future.delayed(
      Duration(
        seconds: 3,
      ),
      () async {
        SharedPreferences prefs = await SharedPreferences.getInstance();
        var email = prefs.getString('email');
        print(email);
        if (email == null) {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return LoginPage();
          }));
        } else {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return HomePage();
          }));
        }
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image(
                image: AssetImage('images/bdcoe.png'),
              ),
              Text(
                'BDCOE',
                style: TextStyle(
                  fontWeight: FontWeight.w900,
                  fontSize: 35.0,
                  color: Colors.blue,
                ),
              ),
              SizedBox(
                height: 7.0,
              ),
              Text(
                'Big Data Center Of Excellence',
                textAlign: TextAlign.justify,
                style: TextStyle(
                  color: Colors.black54,
                  fontSize: 20.0,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
