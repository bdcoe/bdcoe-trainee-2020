from django.urls import path
from main import views
urlpatterns = [
    path('',views.index),
    path('secure/',views.indexes,name='sshh'),
    path('student/',views.create_student,name='create_student')  
]