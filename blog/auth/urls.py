from django.urls import path
from auth import views
from django.conf.urls import url
#from auth.views import views as auth_views
urlpatterns= [
    path('',views.login.as_view(),name='login'),
    path('logout/',views.logout.as_view(),name='logout'),
    path('signup/', views.register, name="signup")
]