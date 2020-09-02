import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  return runApp(
    MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.red[400],
        appBar: AppBar(
          centerTitle: true,
          title: Text(
            'Dicee',
            style: TextStyle(
              fontWeight: FontWeight.bold,
              fontSize: 25.0,
              letterSpacing: 2.5,
            ),
          ),
          backgroundColor: Colors.red,
        ),
        body: DicePage(),
      ),
    ),
  );
}

class DicePage extends StatefulWidget {
  @override
  _DicePageState createState() => _DicePageState();
}

class _DicePageState extends State<DicePage> {
  int leftdice = 1, rightdice = 1;

  void changedice() {
    setState(() {
      leftdice = Random().nextInt(6) + 1;
      rightdice = Random().nextInt(6) + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        children: <Widget>[
          Expanded(
            child: FlatButton(
              onPressed: () {
                changedice();
              },
              child: Image.asset('images/dice$leftdice.png'),
            ),
          ),
          Expanded(
            child: FlatButton(
              onPressed: () {
                changedice();
              },
              child: Image.asset('images/dice$rightdice.png'),
            ),
          ),
        ],
      ),
    );
  }
}
