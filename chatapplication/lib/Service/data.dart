import 'package:cloud_firestore/cloud_firestore.dart';

class DatabaseMethods {
  getUserByUserName(String userName) async {
    return await Firestore.instance
        .collection("users")
        .where("name", isEqualTo: userName)
        .getDocuments();
  }
  getUserByUserEmail(String userEmail) async {
    return await Firestore.instance
        .collection("users")
        .where("email", isEqualTo: userEmail)
        .getDocuments();
  }

  uploadUserInfo(userMap) {
    Firestore.instance.collection("users").add(userMap);
  }
  createChatRoom(String chatroomId, chatRoomMap){
    Firestore.instance.collection("ChatRoom").document(chatroomId).setData(chatRoomMap);
  }
  addConversationMessages(String chatroomId,messageMap) {
    Firestore.instance.collection("ChatRoom").document(chatroomId).
    collection("chats").add(messageMap).catchError((e) {
      print(e.toString());
    });
  }
  getConversationMessages(String chatroomId) async{
    return Firestore.instance.collection("ChatRoom").document(chatroomId).
    collection("chats").orderBy("time",descending: false).snapshots();
  }
  getChatRooms(String userName) async{
    return  Firestore.instance.collection("ChatRoom").where("users",arrayContains:userName)
        .snapshots();

  }
}
