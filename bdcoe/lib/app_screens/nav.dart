import 'package:flutter/material.dart';
import './home.dart';
import './team.dart';
import './about.dart';
import './contact.dart';

class Nav extends StatefulWidget{
  @override
  _NavState createState() =>_NavState();
  }

class _NavState extends State<Nav>{
   int _selectedIndex=0;
   List<Widget> _widgetOptions= <Widget>[
    Home(),
      
   Team(),
 
   About(),
  
   Contact(),
   
   ];


    void _onItemTap(int index){
      setState(() {
        _selectedIndex= index;
      });
 }
  final titleBar = Color(0xFF25CCF7);
      final homeBg = Color(0xFF0A3D62);
      final homeNav = Color(0xFF0A3D62);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor:homeBg,
      body:
     
      Center(
       child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        
        items:  <BottomNavigationBarItem>[
         BottomNavigationBarItem(
           icon: Icon( Icons.home),
           title: Text('Home'),
           backgroundColor: homeNav,
         ),
           BottomNavigationBarItem(
           icon: Icon( Icons.group_work),
           title: Text('Our Team'),
           backgroundColor: homeNav),
           BottomNavigationBarItem(
           icon: Icon( Icons.info),
           title: Text('About us'),
           backgroundColor: homeNav),
           BottomNavigationBarItem(
           icon: Icon( Icons.phone),
           title: Text('contact'),
           backgroundColor: homeNav),
],
   currentIndex: _selectedIndex,
   onTap: _onItemTap,
),
    );
  }

}