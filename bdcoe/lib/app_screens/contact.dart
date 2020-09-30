import 'package:flutter/material.dart';
import './about.dart';
import './team.dart';
import './home.dart';
import 'package:url_launcher/url_launcher.dart';
const URL= "http://www.bdcoe.co.in/";

class Contact extends StatelessWidget{


   Future launchURL(String url) async {
     if (await canLaunch(url)){
       await launch(url, forceSafariVC: true,forceWebView: true);
     }

   }
  final titleBar = Color(0xFF0A3D62);
      final homeBg = Color(0xFF0A3D62);
      

  @override
  Widget build(BuildContext context) {
   
   return Scaffold(
     backgroundColor: homeBg,
      appBar: AppBar(title: Text("Contact"),
      backgroundColor: titleBar,
      leading: IconButton(icon: Icon(Icons.phone), 
         onPressed: (){
          
          
         })),
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
      body: SingleChildScrollView(
        child:
        Padding(
          padding: const EdgeInsets.all(12.0),
          child: Container(
            color: homeBg,
            child: Column(
              children: [
                   Padding(
                     padding: const EdgeInsets.all(12.0),
                     child: Container(
                       color: homeBg,
                       child:
                      Card(
                        elevation: 50.0,
                        child: Bigdatateam())),
                   ),
                 SizedBox(height: 10.0),

                Card( color: homeBg,
                              child: Row(children: [
                   Icon(
                     Icons.contact_mail),
                   SizedBox(width: 10.0),
                   
                   Container(
                     color:homeBg,
                     child: Expanded(
                       child: Center(
                         child: Card(color: homeBg,
                            shadowColor: Colors.black54,
                            elevation: 50.0,
                                                               child: Center(
                                                                 child: Text("contact@bdcoe.co.in",
                         style: TextStyle(
                          
                           fontSize: 20.0, 
                         ),
                         ),
                                                               ),
                         ),
                       ),
                       ),
                   ),



                  ],),
                ) , 
                 SizedBox(height: 10.0),
                Card(
                   color: homeBg,
                                child: Row(
                     mainAxisAlignment: MainAxisAlignment.start,
                    children: [
                   Icon(Icons.contact_phone),
                   SizedBox(width: 5.0),
              
                   Center(
                     child: Card(color: homeBg,
                           shadowColor: Colors.black54,
                           elevation: 50.0,
                                          child: Center(
                                            child: Text("bdcoe.co.in",
                       style: TextStyle(
                         fontSize: 20.0,
                       ),),
                                          ),
                     ),
                   )
                  ]),
                ),
                  
                  Center(
                    child: Card(
                      color: homeBg,
                      elevation: 50.0,
                      shadowColor: Colors.black54,
                      child:
                      Center(
                        child: Text(
                          "Have a nice day!!"
                          ,style: TextStyle(
                            fontSize: 20.0,
                            
                          ),
                        ),
                      ),
                    ),
                  ),


            ],),
          ),
        )
      )
      
   );
  }
 
}

class Bigdatateam extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
     AssetImage bigDatateam = new AssetImage('lib/images/big-data.jpg');
     Image image= Image(image: bigDatateam,width: 500.0 ,height: 500.0,);
     return Padding(
       padding: const EdgeInsets.all(12.0),
       child: Container(

         child: image ,),
     );
  }
  }