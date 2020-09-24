import 'package:bdcoe/events_page.dart';
import 'dart:io';
import 'package:url_launcher/url_launcher.dart';
import 'package:bdcoe/login_page.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';

import 'package:shared_preferences/shared_preferences.dart';

class MainDrawer extends StatefulWidget {
  @override
  _MainDrawerState createState() => _MainDrawerState();
}

class _MainDrawerState extends State<MainDrawer> {
  final _auth = FirebaseAuth.instance;
  User loggedInUser;
  String contactmessage;
  File _image;
  String userid;
  String username;
  String _imagepath;

  @override
  void initState() {
    super.initState();
    getCurrentUser();
    LoadImage();
  }

  void getCurrentUser() async {
    try {
      final user = _auth.currentUser;
      if (user != null) {
        loggedInUser = user;
        userid = _auth.currentUser.uid;
        username = _auth.currentUser.email;
      }
    } catch (e) {
      print(e);
    }
  }

  void saveImage(path) async {
    SharedPreferences saveimage = await SharedPreferences.getInstance();
    saveimage.setString('imagepath', path);
    LoadImage();
  }

  Future getImage() async {
    File image = await ImagePicker.pickImage(source: ImageSource.gallery);
    if (image != null) {
      setState(() {
        _image = image;
        saveImage(_image.path);
      });
    }
  }

  void LoadImage() async {
    SharedPreferences saveimage = await SharedPreferences.getInstance();
    setState(() {
      _imagepath = saveimage.getString('imagepath');
    });
  }
// Future uploadPic() async {
  //   StorageReference ref = await FirebaseStorage.instance
  //       .ref()
  //       .child('user_pics')
  //       .child(_auth.currentUser.uid + '.jpg');
  //   StorageUploadTask uploadTask = ref.putFile(_image);
  //   StorageTaskSnapshot taskSnapshot = await uploadTask.onComplete;
  //   taskSnapshot.ref.getDownloadURL().then((imgurl) {
  //     print('File available at, $imgurl');
  //     _firestore
  //         .collection('profilepics')
  //         .doc(userid)
  //         .set({'picurl': imgurl});
  //   });
  //   var userdata = FirebaseFirestore.instance
  //       .collection('profilepics')
  //       .doc(userid)
  //       .get();
  // }

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: <Widget>[
          Container(
            width: double.infinity,
            padding: EdgeInsets.all(20.0),
            color: Theme.of(context).primaryColor,
            child: Center(
              child: Column(
                children: <Widget>[
                  Stack(
                    children: [
                      Container(
                        margin: EdgeInsets.only(top: 23.0),
                        child: CircleAvatar(
                          radius: 80.0,
                          backgroundImage: _imagepath == null
                              ? AssetImage('images/dummy_profile.jpg')
                              : FileImage(File(_imagepath)),
                        ),
                      ),
                      Positioned(
                        bottom: 0,
                        right: 0,
                        child: Container(
                          height: 40.0,
                          width: 40.0,
                          decoration: BoxDecoration(
                            shape: BoxShape.circle,
                            color: Colors.green,
                            border: Border.all(
                              width: 2,
                              color: Colors.white70,
                            ),
                          ),
                          child: Center(
                            child: IconButton(
                              icon: Icon(
                                Icons.edit,
                                color: Colors.white,
                              ),
                              onPressed: () {
                                setState(() {
                                  getImage();
                                });
                              },
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 14.0,
                  ),
                  Text(
                    username == null ? '' : username,
                    style: TextStyle(
                      fontSize: 17.0,
                      color: Colors.white,
                    ),
                  ),
                ],
              ),
            ),
          ),
          ListTile(
            leading: Icon(Icons.event),
            title: Text(
              'Events',
              style: TextStyle(
                fontSize: 20.0,
              ),
            ),
            tileColor: Colors.grey[100],
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return Events();
              }));
            },
          ),
          ListTile(
            leading: Icon(Icons.perm_contact_cal),
            title: Text(
              'Contact Us',
              style: TextStyle(
                fontSize: 20.0,
              ),
            ),
            tileColor: Colors.grey[100],
            onTap: () {
              showDialog(
                  context: context,
                  builder: (context) {
                    return Dialog(
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(40.0),
                      ),
                      child: Container(
                        height: 260.0,
                        child: Padding(
                          padding: EdgeInsets.all(8.0),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            mainAxisAlignment: MainAxisAlignment.start,
                            children: [
                              Container(
                                padding: EdgeInsets.all(5.0),
                                decoration: BoxDecoration(
                                  boxShadow: [
                                    BoxShadow(
                                      color: Color.fromRGBO(140, 148, 251, 0.2),
                                      blurRadius: 20.0,
                                    ),
                                  ],
                                  border: Border(
                                    bottom: BorderSide(
                                      color: Colors.grey[100],
                                    ),
                                  ),
                                ),
                                child: TextField(
                                  decoration: InputDecoration(
                                    border: InputBorder.none,
                                    hintText: 'Message :-',
                                  ),
                                  textAlignVertical: TextAlignVertical.top,
                                  style: TextStyle(
                                    backgroundColor: Colors.grey[200],
                                    fontSize: 19.0,
                                    fontWeight: FontWeight.bold,
                                  ),
                                  maxLength: 150,
                                  maxLines: 6,
                                  maxLengthEnforced: true,
                                  onChanged: (value) {
                                    contactmessage = value;
                                  },
                                ),
                              ),
                              IconButton(
                                iconSize: 30.0,
                                padding: EdgeInsets.only(left: 250.0),
                                icon: Icon(
                                  Icons.send,
                                  color: Colors.blue,
                                ),
                                onPressed: () async {
                                  var url =
                                      'mailto:bdcoe@gmail.com?subject=Contact&body=$contactmessage';
                                  if (await canLaunch(url)) {
                                    await launch(url);
                                  }
                                },
                              ),
                            ],
                          ),
                        ),
                      ),
                    );
                  });
            },
          ),
          ListTile(
            leading: Icon(Icons.logout),
            title: Text(
              'Logout',
              style: TextStyle(
                fontSize: 20.0,
              ),
            ),
            tileColor: Colors.grey[100],
            onTap: () async {
              SharedPreferences prefs = await SharedPreferences.getInstance();
              prefs.remove('email');
              prefs.remove('imagepath');
              _auth.signOut();
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return LoginPage();
              }));
            },
          ),
        ],
      ),
    );
  }
}
