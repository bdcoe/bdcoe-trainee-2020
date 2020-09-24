import tkinter as tk
from tkinter import messagebox
import os
import cv2
import PIL.Image
import numpy as np
from tkinter import *
from tkinter import font
from tkinter.font import Font
import mysql.connector

window = tk.Tk()
window.title("BDCOE Attendence")

my_font=Font(family="Open Symbol",size=16,weight="bold",slant="roman",underline=1)
label=Label(window, text="Attendence Portal",font=my_font).grid(row=0, column=2)
label=Label(window, text="",font=my_font).grid(row=1, column=2)
label=Label(window, text="",font=my_font).grid(row=5, column=2)
label=Label(window, text="Thank You",font=my_font).grid(row=6, column=2)
l1=tk.Label(window,text="Name", font=("Open Symbol", 15))
l1.grid(column=1, row=2)
t1=tk.Entry(window, width=30, bd=5)
t1.grid(column=2, row=2)

l2=tk.Label(window,text="Year", font=("Open Symbol", 15))
l2.grid(column=1,row=3)
t2=tk.Entry(window, width=30, bd=5)
t2.grid(column=2, row=3)

l3=tk.Label(window,text="RollNo", font=("Open Symbol", 15))
l3.grid(column=1,row=4)
t3=tk.Entry(window, width=30, bd=5)
t3.grid(column=2, row=4)
def train_classifier():
    data_dir="C:/Users/HP/PycharmProjects/bd/data"
    path=[os.path.join(data_dir,f) for f in os.listdir(data_dir)]
    faces=[]
    ids=[]
    for image in path:
        img=PIL.Image.open(image).convert('L');
        imageNp=np.array(img, 'uint8')
        id=int(os.path.split(image)[1].split(".")[1])

        faces.append(imageNp)
        ids.append(id)
    ids=np.array(ids)
    clf=cv2.face.LBPHFaceRecognizer_create()
    clf.train(faces,ids)
    clf.write('classifier.xml')
    messagebox.showinfo('Result','Training dataset completed!')
b1=tk.Button(window,text="     Train Image    ", font=("Monotype corsiva",15), bg='black',fg='white', command=train_classifier)
b1.grid(column=4, row=4)
def detect_face():
    def draw_boundary(img, classifier, scaleFactor, minNeighbors, color, text, clf):
        gray_image = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        features = classifier.detectMultiScale(gray_image, scaleFactor, minNeighbors)

        coords = []
        for (x, y, w, h) in features:
            cv2.rectangle(img, (x, y), (x + w, y + h), (0, 0, 225), 2)
            id, pred = clf.predict(gray_image[y:y + h, x:x + w])
            confidence = int(100 * (1 - pred / 300))

            mydb = mysql.connector.connect(host="localhost", user="root", password="", database="authorized_user")
            mycursor = mydb.cursor()
            mycursor.execute("select name from mytable where id="+str(id))
            s = mycursor.fetchone()
            s = ''+''.join(s)

            if confidence > 80:
                    cv2.putText(img, s , (x, y - 5), cv2.FONT_HERSHEY_COMPLEX, 0.8, color, 1, cv2.LINE_AA)




            else:
                    cv2.putText(img, "unknown", (x, y - 5), cv2.FONT_HERSHEY_COMPLEX, 0.8, (0, 0, 255), 1, cv2.LINE_AA)

            coords = [x, y, w, h]
        return coords

    def recognize(img, clf, faceCascade):
        coords = draw_boundary(img, faceCascade, 1.1, 10, (255, 255, 255), "Face", clf)
        return img
    faceCascade = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")
    clf = cv2.face.LBPHFaceRecognizer_create()
    clf.read("classifier.xml")


    video_capture = cv2.VideoCapture(0)

    while True:
        ret, img = video_capture.read()
        img = recognize(img, clf, faceCascade)
        cv2.imshow("face detection", img)

        if cv2.waitKey(1) == 13:
            break
    video_capture.release()
    cv2.destroyAllWindows()

b1=tk.Button(window,text="     Detect face     ", font=("Monotype corsiva",15), bg='black',fg='white', command=detect_face)
b1.grid(column=4, row=3, padx=10)
def generate_dataset():
    if(t1.get()=="" or t2.get()=="" or t3.get==""):
        messagebox.showinfo('Result','Please provide all the fields!')
    else:
        mydb = mysql.connector.connect(host="localhost", user="root", password="", database="authorized_user")
        mycursor = mydb.cursor()
        mycursor.execute("SELECT * from mytable")
        myresult=mycursor.fetchall()
        id=1
        for x in myresult:
            id+=1
        sql="insert into mytable(id, Name, Year , RollNo) values (%s, %s, %s, %s)"
        val=(id, t1.get(), t2.get(), t3.get())
        mycursor.execute(sql,val)
        mydb.commit()

        face_classifier = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")

        def face_cropped(img):
            gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
            face = face_classifier.detectMultiScale(gray, 1.3, 5)

            if face is ():
                return None
            for (x, y, w, h) in face:
                cropped_face = img[y:y + h, x:x + w]
            return cropped_face

        cap = cv2.VideoCapture(0)
        id = 1
        imd_id = 0

        while True:
            ret, frame = cap.read()
            if face_cropped(frame) is not None:
                imd_id += 1
                face = cv2.resize(face_cropped(frame), (200, 200))
                face = cv2.cvtColor(face, cv2.COLOR_BGR2GRAY)
                file_name_path = "data/bdcoe." + str(id) + "." + str(imd_id) + ".jpg"
                cv2.imwrite(file_name_path, face)
                cv2.putText(face, str(imd_id), (50, 50), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255, 0), 2)

                cv2.imshow("cropped face", face)
                if cv2.waitKey(1) == 13 or int(imd_id) == 200:
                    break

        cap.release()
        cv2.destroyAllWindows()
        messagebox.showinfo('Result','Generating Dataset Completed..!')

b1=tk.Button(window,text=" Generate dataset", font=("Monotype corsiva",15), bg='black',fg='white', command=generate_dataset)
b1.grid(column=4, row=2,padx=30)

window.geometry("500x300+120+120")
window.mainloop()
