import 'package:flutter/material.dart';
import './about.dart';
import './home.dart';
import './contact.dart';



class Team extends StatelessWidget {
 final titleBar = Color(0xFF0A3D62);
      final homeBg = Color(0xFF0A3D62);
      final memberCard = Color(0xFFDAE0E2);
      final heading = Color(0xFF2C3335);
      final cardmajority = Color(0xFF586776);

 @override
  Widget build(BuildContext context) {
   return  Scaffold(
        backgroundColor: homeBg,
       appBar: AppBar(title: Text("Our Team"),
       backgroundColor: titleBar,
       leading: IconButton(icon: Icon(Icons.table_chart), 
         onPressed: (){
           
         }) ),
      drawer: Drawer(
        child: Column(
          children:<Widget>[
                UserAccountsDrawerHeader(
                accountName: Text(
                  "BIG Data"
                ),
                accountEmail: Text(
                  "bdcoe.akgec@gmail.com"
                ),
                currentAccountPicture: CircleAvatar(
                  child: Text(
                    "BD"
                  ),
                  backgroundColor: Colors.blueGrey
                ),
                otherAccountsPictures: <Widget>[
                  CircleAvatar(
                  child: Text(
                    "A"
                  ),
                  ),
                ],
                onDetailsPressed: (){

                  
                },
                ),
                ListTile(
                leading: Icon(Icons.home),
                title: Text("Home"),
                onTap: (){
                   Navigator.push(context, MaterialPageRoute(builder: (context){
       return Home();
     }));
                },selected: true,
                ),
                ListTile(
                  leading: Icon(Icons.group_work),
                title: Text("About US"),
                onTap: (){
                  Navigator.push(context, MaterialPageRoute(builder: (context){
       return About();
     }));
                },selected: true,
                
                ),
                ListTile(
                  leading: Icon(Icons.people),
                title: Text("Our Team"),
                onTap: (){
                  Navigator.push(context, MaterialPageRoute(builder: (context){
       return Team();
     }));
                },selected: true,
                ),
                ListTile(
                  leading: Icon(Icons.phone),
                title: Text("Contact"),
                onTap: ( ){
                  Navigator.push(context, MaterialPageRoute(builder: (context){
       return Contact();
     }));
                  
                },selected: true,
                ),


          ]
        ),
      ),
      body: 
      SingleChildScrollView(
        child: 
      Container(

       color: homeBg,
       width: double.infinity,
       padding: const EdgeInsets.all(8.0),
      child: Column(children: <Widget>[
        
                Card(
                  color: memberCard,
                  shadowColor: Colors.white70,
                  elevation: 50.0,
                  shape: RoundedRectangleBorder(
                             borderRadius: BorderRadius.circular(10.0),
                  ),
                      child: Row(
                   children: [
                     BigDataLogo1(),
                   Expanded(flex: 1,
                   child: Text(
                       "Fourth Year Members",
                       style: TextStyle(
                         fontSize: 35.0,
                         fontFamily: 'Raleway-LightItalic.ttf',
                         color: Colors.grey[800],
                         
                       ),
                     ),
                   ),
          ],),
                ),
             
           
          
          SizedBox(height:30.0),
           Center(
             child: Card(
                
               color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                          child: Row(
                children:( <Widget>[
                 
                  Expanded(
                                  child: Center(
                                    child: Text(
                                    "Shashank Sahai",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                     color: Colors.black87,

                                     
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
             ),
           ),
          
            SizedBox(height:20.0),
            Center(
              child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                            child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Ripudaman Singh",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
              ),
            ),
            
          SizedBox(height:20.0),
         
         Center(
           child: Card( color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                      child: Row(
                children:( <Widget>[
                
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Anand",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
           ),
         ),
          
          SizedBox(height:20.0),
            Center(
              child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                            child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Shivam Saxena",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                     color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
              ),
            ),
          
          SizedBox(height: 20.0),
             Center(
               child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                              child: Row(
            children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Disha Rastogi",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
            ]),
            ),
               ),
             ),
          SizedBox(height:20.0),
          Center(
            child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                        child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Ambika Agarwal",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
            ),
          ),
        
          SizedBox(height: 20.0),
         Center(
           child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                      child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Vidhi Dixit",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                     color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
           ),
         ),
          
          SizedBox(height: 20.0),
           Center(
             child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                          child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Shivam Tiwari",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                     color: Colors.black87,
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
             ),
           ),
          
          SizedBox(height:20.0),
         Center(
           child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                      child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Gaurang Agarwal",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
           ),
         ),
          
          
          SizedBox(height:20.0),
          Center(
            child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                        child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Vibhas Singh",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
            ),
          ),
          SizedBox(height:30.0),
           Card(
                  color: memberCard,
                  shadowColor: Colors.white70,
                  elevation: 50.0,
                   child: Row(children: [
              BigDataLogo1(),

             Expanded(flex: 1,
                          child: Center(
                            child: Text(
                 "Third Year Members",
                 style: TextStyle(
                   fontSize: 35.0,
                   fontFamily: 'Raleway-LightItalic.ttf',
                   color: heading,
                   
                 ),
               ),
                          ),
             ),
          ],),
           ),
            SizedBox(height:30.0),
       Center(
         child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                  child: Row(
                children:( <Widget>[
                
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Prakankshu Sahu",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
         ),
       ),
          SizedBox(height:20.0),
          Center(
            child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                        child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Riya Garg",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
            ),
          ),
          SizedBox(height:20.0),
          Center(
            child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                        child: Row(
                children:( <Widget>[
                  
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Devansh Srivastava",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                     color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
            ),
          ),
          SizedBox(height:20.0),
           Center(
             child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                          child: Row(
                children:( <Widget>[
                  
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Karan Yadav",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
             ),
           ),
          SizedBox(height:20.0),
          Center(
            child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                        child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                 "Tanya Agarwal",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
            ),
          ),
          SizedBox(height:20.0),
           Center(
             child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                          child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Taru Agarwal",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
             ),
           ),
          SizedBox(height:20.0),
       Center(
         child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                  child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Kishan Baranwal",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily:'Raleway-LightItalic.ttf',
                                     color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                ),
         ),
       ),
          SizedBox(height:20.0),
         Center(
           child: Card(color: homeBg,
               elevation: 60.0,
               shadowColor: Colors.black,
                      child: Row(
                children:( <Widget>[
                 
                  Expanded(flex: 1,
                                  child: Center(
                                    child: Text(
                                    "Deepak Chaurasia",
                                    style: TextStyle(
                                      fontSize: 25.0,
                                      fontFamily: 'Raleway-LightItalic.ttf',
                                      color: Colors.black87,
                                      
                                    ),
                                 ),
                                  ),
                  ),
                ]),
                
             ),
           ),
         ),
          
      ],),) 
        
       

      ),
         
      
   );
       
         
         
   

}
}
class BigDataLogo1 extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
     AssetImage bigDataLogoC = new AssetImage('lib/images/logo.png');
     Image image= Image(image: bigDataLogoC,width: 100.0 ,height: 100.0,);
     return Container(
       child: Column(
         children: [
           image ,
         ],
      ),
      );
  }
}