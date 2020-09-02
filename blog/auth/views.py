from django.shortcuts import render,reverse,redirect
from django.http import HttpResponseRedirect
from django.contrib.auth.views import (
    LoginView,
    LogoutView as Logout
)
# Create your views here.

class login(LoginView):
    template_name='auth/login.html'
    redirect_authenticated_user=True

class logout(Logout):
    template_name='auth/logout.html'
    pass