from django.urls import path
from auth import views
from django.conf.urls import url
from django.contrib.auth import views as auth_views
#from auth.views import views as auth_views
urlpatterns= [
    path('',views.login.as_view(),name='login'),
    path('logout/',views.logout.as_view(),name='logout'),
    path('signup/', views.register, name="signup"),
    path('password_reset/',auth_views.PasswordResetView.as_view(),name='password_reset'),
    path('password_reset/done/',auth_views.PasswordResetDoneView.as_view(),name='password_reset_done'),
    path('reset/<uidb64>/<token>/',auth_views.PasswordResetConfirmView.as_view(),name='password_reset_confirm'),
    path('reset/done/',auth_views.PasswordResetCompleteView.as_view(),name='password_reset_complete'),
]