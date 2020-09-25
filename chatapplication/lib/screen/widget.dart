import 'package:flutter/material.dart';

Widget appBarMain(BuildContext context) {
  return AppBar(
    title: Text(
      'GapShap App',
    ),
    centerTitle: true,
  );
}

InputDecoration textFieldDeco(String hintText) {
  return InputDecoration(
      hintText: hintText,
      hintStyle: TextStyle(
        color: Colors.white60,
      ),
      focusedBorder:
          UnderlineInputBorder(borderSide: BorderSide(color: Colors.white)),
      enabledBorder:
          UnderlineInputBorder(borderSide: BorderSide(color: Colors.white)));
}

TextStyle simpleTextDeco() {
  return TextStyle(
    color: Colors.white,
  );
}
TextStyle bigTextDeco() {
    return TextStyle(
      color: Colors.white,
      fontSize: 15,
    );
}
