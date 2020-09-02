from django.urls import path
from auth import views

urlpatterns= [
    path('',views.login.as_view(),name='login'),
    path('logout/',views.logout.as_view(),name='logout')
]