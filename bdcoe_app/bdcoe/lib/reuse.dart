import 'package:flutter/material.dart';

class Reusable extends StatelessWidget {
  Reusable(this.colour1, this.colour2, this.icon, this.text1, this.text2,
      this.iconcolour, this.ontap);
  final Color colour1;
  final Function ontap;
  final Color colour2;
  final Color iconcolour;
  final String text1;
  final String text2;
  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.fromLTRB(24.0, 12.0, 24.0, 0.0),
      height: 200.0,
      width: 400.0,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(20),
        gradient: LinearGradient(
          colors: [
            colour1,
            colour2,
          ],
        ),
      ),
      child: FlatButton(
        onPressed: ontap,
        child: Column(
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(top: 5.0),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Icon(
                    icon,
                    color: iconcolour,
                    size: 50.0,
                  ),
                  SizedBox(
                    width: 10.0,
                  ),
                  Text(
                    text1,
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 23.0,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Column(
              children: <Widget>[
                Text(
                  text2,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 18.0,
                    fontFamily: 'SourceCodePro',
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
