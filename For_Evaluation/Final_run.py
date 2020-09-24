'''imports for project'''


#import os

#from tkinter import *

import sys

import speech_recognition as sr

#import nltk

#from nltk.corpus import wordnet

#from nltk.corpus import stopwords

from nltk.stem import PorterStemmer

from nltk.tokenize import word_tokenize
#import time

#from . import _distributor_init

import tkinter as tk

global x,ps



root = tk.Tk()
root.title("Jane")
root.resizable(False,False)

MainFrame = tk.Frame(root, width=252, height=252, relief='raised', borderwidth=5)
Frame1 = tk.Frame(MainFrame, width=252, height=40, relief='raised', borderwidth=2, bg = "white")
Frame2 = tk.Frame(MainFrame, width=252, height=82, relief='raised', borderwidth=2, bg = "white")
Frame3 = tk.Frame(MainFrame, width=252, height=82, relief='raised', borderwidth=2, bg = "white")
Frame4 = tk.Frame(MainFrame, width=252, height=82, relief='raised', borderwidth=2, bg = "white")

'''imports ended'''


''' Main Project Code!'''

v = tk.StringVar()


def start():

    Frame3.pack_forget()
    Frame4.pack_forget()

    ps = PorterStemmer()  
 

    #print("welcome to audio smartclass!")


    comp_label = tk.Label(Frame4, text='welcome to audio smartclass!').pack()

    while(1):
        temp = input_voice()
        #v = StringVar()
        v.set(temp)
        tk.Label(Frame3, textvariable=v).pack()

        
        
        temp = word_tokenize(temp)
        for i in temp:

            i = ps.stem(i)
        check(temp)

    



def input_voice():

    Frame3.pack_forget()
    Frame4.pack_forget()

    x = sr.Recognizer()

    with sr.Microphone() as s:
        aud = x.listen(s)
        k = ''
        try:
            k = x.recognize_google(aud)
        except sr.UnknownValueError:
            #print("Couldn't Recognise!")
            comp_label = tk.Label(Frame4, text="Couldn't Recognise!").pack()
        except sr.RequestError:
            #print("System is not connected!")
            comp_label = tk.Label(Frame4, text="System is not connected!").pack()
            
            
        return k

def check(inp): 
    if('jane' in inp and 'class' in inp and 'start' in inp):
        startclass()
    elif('jane' in 'class' in inp and 'end' in inp):
        endclass()


def startclass():
    Frame3.pack_forget()
    Frame4.pack_forget()

    #print("What will be the title of this class?")
    comp_label = tk.Label(Frame4, text="What will be the title of this class?").pack()
    title = input_voice()
    v = StringVar()
    v.set(title)
    tk.Label(Frame3, textvariable=v).pack()
    f = open("{}.txt".format(title),"a+")
    #print("Class of {} has started".format(title))
    x="Class of" + title + "has started.\nListening now onwards!"
    v.set(x)
    tk.Label(Frame4, textvariable=v).pack()
    
    #print("Listening now onwards!")
    while(1):
        print("Listening for definitions")
        comp_label = tk.Label(Frame4, text="Listening for definitions").pack()
        take = input_voice()
        v.set(take)
        tk.Label(Frame3, textvariable=v).pack()
       # print(take)
        if('class' in take and 'end' in take):
            endclass()
        elif('note' in take):
            takenote(f)
        else:
            continue


def takenote(f):
    Frame3.pack_forget()
    Frame4.pack_forget()

    #print("Give title:")
    comp_label = tk.Label(Frame4, text="Give title:").pack()

    def_title = input_voice()
    #print(def_title)

    v.set(def_title)
    tk.Label(Frame3, textvariable=v).pack()


    #print("Speak Now:")

    comp_label = tk.Label(Frame4, text="Speak Now:").pack()


    def_note = input_voice()

    tot_def = def_title+":"+def_note
    #print(def_note)

    v.set(tot_def)
    tk.Label(Frame3, textvariable=v).pack()


    
    
    f.write(tot_def)
        
def endclass(f=False):
    Frame3.pack_forget()
    Frame4.pack_forget()

    #print("Ending the class!")

    comp_label = tk.Label(Frame4, text="Ending the class!").pack()


    if(f):
        f.close(f)
        #print("saved and closed the file!")

        comp_label = tk.Label(Frame4, text="saved and closed the file!").pack()
    sys.exit("see you in next class!")





'''main project code ended'''



''' Graphics for project'''






label = tk.Label(Frame1, text='Welcome to Jane class assistant.\nJust give commands to take notes during \nstudying and classes!')
label.config(font=("Algerian", 8), bg = 'white', fg = '#038376')

strat_button = tk.Button(Frame4, text='Click to get Jane started!', command=start)

canvas = tk.Canvas(Frame2,bg = 'white')
#canvas.pack(fill = BOTH, expand = False)
sound = tk.PhotoImage(file = 'C:\\Users\\user\\Desktop\\Jane\\sound.gif')

canvas.create_image(120,40, image = sound)
x=0
while(x<=252):
    
    if(x>=100 and x<=140):
        pass
    else:
        canvas.create_line(x,0,x,82,dash = (4,2), width = 2)
        
    x = x+10


for frame in [MainFrame, Frame1, Frame2, Frame3, Frame4]:
    frame.pack(expand=True)
    frame.pack_propagate(0)

for widget in [label, canvas, strat_button]:
    widget.pack(expand=True, fill='x', anchor='s')
root.mainloop()




