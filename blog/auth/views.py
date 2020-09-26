from django.shortcuts import render,reverse,redirect
from django.http import HttpResponseRedirect
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import login as log, authenticate
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


def signup(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            username = form.cleaned_data.get('username')
            raw_password = form.cleaned_data.get('password1')
            user = authenticate(username=username, password=raw_password)
            log(request, user)
            return redirect('login')
    else:
        form = UserCreationForm()
    return render(request, 'auth/signup.html', {'form': form})