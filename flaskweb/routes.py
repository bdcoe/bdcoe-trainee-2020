from flask import Flask, render_template, url_for, flash, redirect
from flask_sqlalchemy import SQLAlchemy
import sqlite3
from flaskweb.form import RegistrationForm, LoginForm, StockItem, EmailNotify
import requests
from bs4 import BeautifulSoup
import smtplib
import os
from datetime import datetime
from flaskweb import app, db, bcrypt
from flaskweb.database import User
from flask_login import login_user, current_user, logout_user
import time

@app.route("/")
def hello():
    return render_template('home.html')

@app.route("/about", methods=['GET','POST'])
def about():
    return render_template('about.html')

@app.route("/register", methods = ['GET', 'POST'])
def registration():
    if current_user.is_authenticated:
        return redirect(url_for('hello'))
    form = RegistrationForm()
    if form.validate_on_submit():
        hashed_pwd = bcrypt.generate_password_hash(form.password.data).decode('utf-8')
        user = User(username=form.username.data,email=form.email.data,password=hashed_pwd)
        db.session.add(user)
        db.session.commit()
        flash("Account createf has been created !", "success")
        return redirect(url_for('hello'))
    return render_template('register.html', form=form)

@app.route("/login",methods = ['GET', 'POST'])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('hello'))
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(email=form.email.data).first()
        if user and bcrypt.check_password_hash(user.password, form.password.data):
            login_user(user, remember=form.remember.data)
            return redirect(url_for('stock_price_tracker'))
        else:
            flash('Login Unsuccessful. Please check username and password', 'danger')
            #return redirect(url_for('hello'))
    return render_template('login.html', log=form)

@app.route("/tracker",methods = ['GET', 'POST'])
def stock_price_tracker():
    #global stock_item
    #global stock_price_c
    #global fm
    #fm = EmailNotify()
    item = StockItem()
    if item.validate_on_submit():
        global stock_item
        global stock_price_c
        global url
        global reciever
        global EMAIL_ADDRESS
        global EMAIL_PASSWORD
        global comp
        global over
        global r
        global soup
        global url
        global time


        stock_item = item.stock.data
        url = "https://finance.yahoo.com/quote/?p=" + stock_item + ".NS"
        print(url)

        r = requests.get(url)
        soup = BeautifulSoup(r.content, "html.parser")
        currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
        stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

        stock_price_c = float(stock_price.replace(',', ''))

        stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
        comp = item.bar.data
        comp = float(comp)
        over = item.lim.data
        over = float(over)
        #time = item.time.data
        #time = int(time)
        if stock_price_c > over and stock_price_c < comp:
            EMAIL_ADDRESS = os.environ.get("email_address")
            EMAIL_PASSWORD = os.environ.get("email_password")
            reciever = item.mail.data
        # if stock_price_c < 3000.00:

            with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
                smtp.ehlo()
                smtp.starttls()
                smtp.ehlo()

                smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
                subject = "Heyy ! Your stock price is under your limit"
                body = f"stock price of  {stock_item} is {stock_price_c} \n check here {url} "
                msg = f"Subject : {subject} \n\n {body}"
            # sender = input("Enter email :")
                smtp.sendmail(EMAIL_ADDRESS, reciever, msg)

            return render_template('price.html',char=stock_item,price=stock_price_c,link=url,cur=currency,diff=stock_price_change)


        return render_template('price.html', char=stock_item, price=stock_price_c, link=url)

        #else:
            #return render_template('price.html',msg="Price of Stock is under 1000/-" )

    return render_template('tracker.html', item=item)

@app.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('hello'))

@app.route('/home')
def home():
    return render_template('index.html')

@app.route('/price',methods=['GET','POST'])
def price():
    while True:
        r = requests.get(url)
        soup = BeautifulSoup(r.content, "html.parser")
        currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
        stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

        stock_price_p = float(stock_price.replace(',', ''))
        if stock_price_p > over and stock_price_p < comp:
            with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
                smtp.ehlo()
                smtp.starttls()
                smtp.ehlo()

                smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
                subject = "Heyy ! Your stock price is under your limit"
                body = f"stock price of  {stock_item} is {stock_price_p} \n check here {url} "
                msg = f"Subject : {subject} \n\n {body}"
        # sender = input("Enter email :")
                smtp.sendmail(EMAIL_ADDRESS, reciever, msg)
            time.sleep(60)

