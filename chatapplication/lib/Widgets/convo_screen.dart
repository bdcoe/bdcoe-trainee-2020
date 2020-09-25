import 'package:chatapplication/Service/data.dart';
import 'package:chatapplication/helper/constant.dart';
import 'package:chatapplication/screen/widget.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ConvoScreen extends StatefulWidget {

  final String chatroomId;
  ConvoScreen(this.chatroomId);
  @override
  _ConvoScreenState createState() => _ConvoScreenState();
}

class _ConvoScreenState extends State<ConvoScreen> {
  Stream chatMessageStream;
  DatabaseMethods databaseMethods = new DatabaseMethods();
  TextEditingController messageController = new TextEditingController();



  Widget chatMessageList(){
    return StreamBuilder(
      stream: chatMessageStream,
      builder: (context, snapshot){
        return snapshot.hasData ? ListView.builder(
            itemCount:snapshot.data.documents.length,
            itemBuilder: (context, index){
              return MessageTile(snapshot.data.documents[index].data["message"],
                  snapshot.data.documents[index].data["sendBy"] == Constants.myName);
            }) : Container();
      },
    );
  }
  sendMessage(){
    if(messageController.text.isNotEmpty){
      Map<String,dynamic> messageMap = {
        "message" :messageController.text,
        "sendBy" : Constants.myName,
        "time" : DateTime.now().millisecondsSinceEpoch,
      };
      databaseMethods.addConversationMessages(widget.chatroomId,messageMap);
      setState(() {
        messageController.text = "";
      });
    }
  }
  @override
  void initState() {
    databaseMethods.getConversationMessages(widget.chatroomId).then((value){
      setState(() {
        chatMessageStream = value;
      });
    });
    super.initState();
  }
  @override

  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBarMain(context),
      body: Stack(
        children: [
          chatMessageList(),
          Container(
            alignment: Alignment.bottomCenter,
            child: Container(
              padding: EdgeInsets.symmetric(vertical: 15, horizontal: 25),
              child: Row(
                children: [
                  Expanded(
                      child: TextField(
                        controller:  messageController,
                        style: TextStyle(color: Colors.white, fontFamily: "Bhaloo"),
                        decoration: InputDecoration(
                            hintText: "Gossips ? ...",
                            hintStyle: TextStyle(
                              color: Colors.white54,
                            )),
                      )),
                  GestureDetector(
                    onTap: () {
                      sendMessage();
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
                        child: Image.asset("images/send.png")),
                  )
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class MessageTile extends StatelessWidget {
  final String message;
  final bool isSendByMe;
  MessageTile(this.message, this.isSendByMe);
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(left: isSendByMe? 0:24, right: isSendByMe ?24:0),
      margin: EdgeInsets.symmetric(vertical: 7),
      width: MediaQuery.of(context).size.width,
      alignment: isSendByMe ? Alignment.centerRight:Alignment.centerLeft,
      child: Container(
        padding: EdgeInsets.symmetric(horizontal:20, vertical: 10),
        decoration: BoxDecoration(
          gradient: LinearGradient(
          colors: isSendByMe ? [
            const Color(0xff007EF4),
            const Color(0xff2A75BC)
          ]
          : [
          const Color(0x1AFFFFFF),
          const Color(0x1AFFFFFF)
      ],

          ),
    borderRadius: isSendByMe?
            BorderRadius.only(
                topLeft: Radius.circular(23),
                topRight: Radius.circular(23),
                bottomLeft: Radius.circular(23)
      ):BorderRadius.only(
    topLeft: Radius.circular(23),
    topRight: Radius.circular(23),
    bottomRight: Radius.circular(23)
    )
    ),
      child: Text(message, style: TextStyle(
          color: Colors.white,
          fontSize: 17,
        ),),
      ),
    );
  }
}
