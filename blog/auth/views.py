from django.shortcuts import render,reverse,redirect
from django.http import HttpResponseRedirect
from django.contrib.auth import login as log, authenticate
from django.contrib.auth.views import (
    LoginView,
    LogoutView as Logout
)
from .forms import UserRegisterForm

from django.conf import settings 
from django.core.mail import send_mail



from django.shortcuts import render, redirect 
from django.contrib import messages 
from django.contrib.auth import authenticate, login 
from django.contrib.auth.decorators import login_required 
from django.contrib.auth.forms import AuthenticationForm 
from .forms import UserRegisterForm 
from django.core.mail import send_mail 
from django.core.mail import EmailMultiAlternatives 
from django.template.loader import get_template 
from django.template import Context 

# Create your views here.

class login(LoginView):
    template_name='auth/login.html'
    redirect_authenticated_user=True

class logout(Logout):
    template_name='auth/logout.html'
    pass




def register(request): 
    if request.method == 'POST': 
        form = UserRegisterForm(request.POST) 
        if form.is_valid(): 
            form.save() 
            username = form.cleaned_data.get('username') 
            email = form.cleaned_data.get('email') 
            ######################### mail system ####################################  
            htmly = get_template('auth/Email.html') 
            d = { 'username': username } 
            subject, from_email, to = 'welcome', 'rabhi1611@gmail.com', email 
            html_content = htmly.render(d) 
            msg = EmailMultiAlternatives(subject, html_content, from_email, [to]) 
            msg.attach_alternative(html_content, "text/html") 
            msg.send() 
            ##################################################################  
            messages.success(request, f'Your account has been created ! You are now able to log in') 
            return redirect('login') 
    else: 
        form = UserRegisterForm() 
    return render(request, 'auth/signup.html', {'form': form, 'title':'reqister here'}) 
   