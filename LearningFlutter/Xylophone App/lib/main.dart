import 'package:flutter/material.dart';
import 'package:audioplayers/audio_cache.dart';

void main() => runApp(XylophoneApp());

class XylophoneApp extends StatelessWidget {
  void play(int n) {
    final player = AudioCache();
    player.play('note$n.wav');
  }

  Expanded buildKey(Color color, int note) {
    return Expanded(
      child: FlatButton(
        color: color,
        onPressed: () {
          play(note);
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.black,
        body: SafeArea(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              buildKey(Colors.red, 1),
              buildKey(Colors.orange, 1),
              buildKey(Colors.yellow, 1),
              buildKey(Colors.green, 1),
              buildKey(Colors.blue, 1),
              buildKey(Colors.indigo, 1),
              buildKey(Colors.purple, 1),
            ],
          ),
        ),
      ),
    );
  }
}
