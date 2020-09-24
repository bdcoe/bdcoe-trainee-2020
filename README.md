# bdcoe-trainee-2020
This repository is for you guys to push your daily work
# Attendence system using face recognition
(attendence.py)
This repo contains code for attendence system.
just run attendence.py
Here I am working on Face recognition based Attendance Management System by using OpenCV(Python). One can mark thier attendance by simply facing the camera.
# Pre requisites
You have to open Xampp and start mysql and Apache

# Modules required
  Opencv(pip install opencv)
  numpy(pip istall numpy)
  mysql(pip install mysql.connector)
  os(pip install os)
  tkinter(pip install tkinter)
 # Create a Folder name data which will store Dataset also change the path of folder in the source code with that of you folder path.

# How it works :

When we run attendence.py a window is opened and ask for Enter  Name, roll no,year. After entering  Name, roll no,year then we  click on generate dataset button.
By clicking generate dataset camera of running computer will be opened and it will start taking image samples of a person.These photos will be stored in data folder
. It takes 200 images as sample and you can also stop the window before 200 samples by hitting Enter Key
and store them in folder Data.After completion it will notify
that "Generating Dataset Completed". After taking image sample we have to click Train Image button.Now it take few seconds to train machine for the images that are taken.Now we will
click on detect face and it will detect the face.
. If face is recognised by system then Id, Name,Year and roll no of student will be stored in tables.

# Thank You
