from django.urls import path
from main import views

urlpatterns= [
    path('',views.index,name='index'),
    path('article/<int:pk>',views.article, name='get_article'),
    path('author/<int:pk>',views.author,name='get_author'),
    path('article', views.create_article, name='create_article'),
    path('author',views.create_author,name='create_author'),
    path('mail1',views.mail1,name='mail_1'),
    path('mail2',views.mail2,name='mail_2')
]