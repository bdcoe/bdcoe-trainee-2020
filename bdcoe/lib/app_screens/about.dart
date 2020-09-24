import 'package:flutter/material.dart';
import './home.dart';
import './team.dart';
import './contact.dart';


class About extends StatelessWidget{
   final titleBar = Color(0xFF0A3D62);
      final homeBg = Color(0xFF0A3D62);
      final containercol = Color(0xFF192A56);
  @override
  Widget build(BuildContext context) {
   
   return Scaffold(
     backgroundColor: homeBg,
       appBar: AppBar(title: Text("About US"),
       backgroundColor: titleBar,
       leading: IconButton(icon: Icon(Icons.menu), 
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
       body: SingleChildScrollView(
         
          child: Column(
                mainAxisAlignment: MainAxisAlignment.start, 
             children: <Widget>[ 
          Container(
            color:homeBg,
            child: Column(children: [
                   Container(
                     child: Card(
                       color: homeBg,
                       shadowColor: Colors.black,
                       elevation: 70.0,
                       child: BigDataLogo1()),
                   ),
                   SizedBox(height: 10.0), 
               Padding(
                 padding: const EdgeInsets.all(12.0),
                 child: Container(
                   color: homeBg,
                   child: Padding(
                     padding: const EdgeInsets.all(12.0),
                     child: Center(
                       child: Card(shadowColor: Colors.black54,
                         color: homeBg,
                         elevation: 60.0,
                                                child: Text('About BDCOE',
                           
                           style: TextStyle(
                              fontSize: 49.0,
                           ),),
                       ),
                     ),
                   ),
                 ),
               ),
              
            Padding(
              padding: const EdgeInsets.all(12.0),
              child: Container(
                child: Center(
                  child: Card(
                    color: homeBg,
                    shadowColor: Colors.black54,
                    elevation: 70.0,
                    child: Text("Big Data Centre of Excellence is the Research and Development centre of AKGEC. It is the first Centre of Excellence in AKTU, working in the field of BigData. It was established in 2013 and since 4 years it has been motivating and guiding the students into the world of Big Data. Big Data is the most trending technology of 21st century. It is the hottest market currently. Companies require Big Data Analysts to analyze the large amount of data being generated and gain insights from the data. Businesses are focusing more on agility and innovation, adopting BigData technologies help the companies achieve that in no time. The team aspires to develope skills in Big Data and gradually move from Machine Learning to Deep Learning and finally Artificial Intelligence."
                    ,style:TextStyle(
                      fontSize: 25.0,
                    ) ,
                    )),
                ),
              ),
            ),
            
                 ], ))])));
  }

}