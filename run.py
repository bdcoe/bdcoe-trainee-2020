#   *** DO READ MULTILINE COMMENTS TO KNOW WHAT'S GONNA HAPPEN TILL THE PROJECT WORK IS'NT FINISHED*** 
'''train a neural network to recognise commanding words and Jane's name here and use furthur use it as base for processes'''
'''but since for definiions, we cannot train aour neural network for so many words, use nltk for nlp or custom 
nlp and google_recognizer class from speechrecognition to understand definition words'''
import speech_recognition as sr
x = sr.Recognizer()
i = 1
with sr.Microphone() as s:
    print("Listening Now!")
    aud = x.listen(s)
    k = x.recognize_google(aud)
    print(k)
    

'''start class with jane start class input and class name 
this flag i does this. now we need to check when user calls for start to note or definiion and wgenever does,
 set flag to 1 else after end def check for end class set i to 0 end save txt file and end program'''
'''flow will be as start class with name check for definiotions write definitions on txt file end class'''
'''later on the program may also include various voice commands and chatting features that may create its own custom 
nlp and use it to reply user's questions in audio output (somewhat distant ai dream <'_'!>  ;))
But till then, this project is just based on making notes'''

