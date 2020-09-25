import 'package:chatapplication/Service/data.dart';
import 'package:chatapplication/Widgets/convo_screen.dart';
import 'package:chatapplication/helper/constant.dart';
import 'package:chatapplication/helper/helper.dart';
import 'package:chatapplication/screen/widget.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class SearchScreen extends StatefulWidget {
  @override
  _SearchScreenState createState() => _SearchScreenState();
}
String _myName;
class _SearchScreenState extends State<SearchScreen> {
  DatabaseMethods databaseMethods = new DatabaseMethods();
  TextEditingController searchTextEditingController =
      new TextEditingController();
  QuerySnapshot searchSnapshot;


  Widget searchList() {
    return searchSnapshot!= null? ListView.builder(
        itemCount: searchSnapshot.documents.length,
        shrinkWrap: true,
        itemBuilder: (context, index) {
          return searchTile(
            userName:searchSnapshot.documents[index].data["name"],
            userEmail:searchSnapshot.documents[index].data["email"],
          );
        }):Container() ;
  }
  startSearch() {
    databaseMethods
        .getUserByUserName(searchTextEditingController.text)
        .then((val) {
          setState(() {
            searchSnapshot = val;
          });

    });
  }
  //creating chatRoom to send user,pushReplace
  createChatRoom({String userName}){
    print("${Constants.myName}");
    if(userName != Constants.myName){
      String chatRoomId = getChatRoomId(userName,Constants.myName,);
      List<String> users =[userName,Constants.myName,];
      Map <String,dynamic> chatRoomMap ={
        "users":users,
        "chatroomId":chatRoomId
      };
      DatabaseMethods().createChatRoom(chatRoomId,chatRoomMap);
      Navigator.push(context, MaterialPageRoute(
          builder: (context) => ConvoScreen(chatRoomId)
      ));
    }
  }

  Widget searchTile( {String userName,String userEmail}){
    return Container(
      padding: EdgeInsets.symmetric(vertical: 15,horizontal: 25),
      child: Row(
        children: [
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                userName,
                style: bigTextDeco(),
              ),
              Text(
                userEmail,
                style: bigTextDeco(),
              )
            ],
          ),
          Spacer(),
          GestureDetector(
            onTap: (){
              createChatRoom(userName:userName);
            },
            child: Container(
              decoration: BoxDecoration(
                  color: Colors.blue, borderRadius: BorderRadius.circular(30)),
              padding: EdgeInsets.symmetric(horizontal: 15, vertical: 10),
              child: Text("Message", style: TextStyle(fontFamily: "Bhaloo",color: Colors.white,)),
            ),
          )
        ],
      ),
    );
  }
  getChatRoomId(String a,String b) {
    if(a.substring(0,1).codeUnitAt(0)>b.substring(0,1).codeUnitAt(0)){
      return "$b\_$a";
    }else{
      return "$a\_$b";
    }
  }
  @override
  void initState(){
    super.initState();
  }


  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBarMain(context),
      body: Container(
        child: Column(
          children: [
            Container(
              padding: EdgeInsets.symmetric(vertical: 15, horizontal: 25),
              child: Row(
                children: [
                  Expanded(
                      child: TextField(
                        controller: searchTextEditingController,
                    style: TextStyle(color: Colors.white, fontFamily: "Bhaloo"),
                    decoration: InputDecoration(
                        hintText: "search username...",
                        hintStyle: TextStyle(
                          color: Colors.white54,
                        )),
                  )),
                  GestureDetector(
                    onTap: () {
                      startSearch();
                    },
                    child: Container(
                        height: 50,
                        width: 50,
                        decoration: BoxDecoration(
                            gradient: LinearGradient(colors: [
                              const Color(0x36FFFFFF),
                              const Color(0x0FFFFFFF)
                            ]),
                            borderRadius: BorderRadius.circular(40)),
                        padding: EdgeInsets.all(10),
                        child: Image.asset("images/search.png")),
                  )
                ],
              ),
            ),
            searchList()
          ],
        ),
      ),
    );
  }
}

