from flask import Flask, render_template, url_for, flash, redirect
from flask_sqlalchemy import SQLAlchemy
import sqlite3
from flaskweb.form import RegistrationForm, LoginForm, StockItem, Scrap
import requests
from bs4 import BeautifulSoup
import smtplib
import os
from datetime import datetime
from flaskweb import app, db, bcrypt
from flaskweb.database import User, Item
from flask_login import login_user, current_user, logout_user
import time
from sqlalchemy import column
from sqlalchemy.dialects.postgresql import insert


@app.route("/")
def hello():
    item = "MRF"
    url = "https://finance.yahoo.com/quote/?p=" + item + ".NS"
    r = requests.get(url)
    soup = BeautifulSoup(r.content, "html.parser")
    currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_c = float(stock_price.replace(',', ''))
    stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    urle = "https://finance.yahoo.com/quote/TCS.NS?p=TCS.NS&.tsrc=fin-srch"
    iteme = "TCS"
    re = requests.get(urle)
    soupe = BeautifulSoup(re.content, "html.parser")
    currencye= soupe.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_price_e = soupe.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

    stock_price_ce = float(stock_price_e.replace(',', ''))
    stock_price_change_e = soupe.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    it = "ASIANPAINT"
    urla = "https://finance.yahoo.com/quote/?p=" + it + ".NS"
    ra = requests.get(urla)
    soupa = BeautifulSoup(ra.content, "html.parser")
    currencya = soupa.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_pricea = soupa.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_ca = float(stock_pricea.replace(',', ''))
    stock_price_changea = soupa.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    urlh = "https://finance.yahoo.com/quote/HDFCBANK.NS?p=HDFCBANK.NS&.tsrc=fin-srch"
    itemh = "HDFC Bank"
    rh = requests.get(urlh)
    souph = BeautifulSoup(rh.content, "html.parser")
    currency = souph.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_priceh = souph.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_ch = float(stock_priceh.replace(',', ''))
    stock_price_changeh = souph.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    itemi = "INFOSYS"
    urli = "https://finance.yahoo.com/quote/?p=" + "INFY" + ".NS"
    ri = requests.get(urli)
    soupi = BeautifulSoup(rh.content, "html.parser")
    currency = soupi.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_pricei = soupi.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_ci = float(stock_pricei.replace(',', ''))
    stock_price_changei = soupi.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    itemr = "RELIANCE"
    urlr = "https://finance.yahoo.com/quote/?p=" + itemr + ".NS"
    rr = requests.get(urlr)
    soupr = BeautifulSoup(rr.content, "html.parser")
    currency = soupr.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_pricer = soupr.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_cr = float(stock_pricer.replace(',', ''))
    stock_price_changer = soupr.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()

    return render_template('home.html',char=item,price = stock_price_c,diff=stock_price_change,pr=stock_price_ce,ch=stock_price_change_e,chare=iteme,itema=it,pra=stock_price_ca,diffa=stock_price_changea,
                           chh=itemh,prh=stock_price_ch,diffh=stock_price_changeh,chi=itemi,pri=stock_pricei,diffi=stock_price_changei,
                           chr=itemr,prr=stock_price_cr,diffr=stock_price_changer)

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
        return redirect(url_for('option'))
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(email=form.email.data).first()
        if user and bcrypt.check_password_hash(user.password, form.password.data):
            login_user(user, remember=form.remember.data)
            #return render_template('choice.html')
            return redirect(url_for('option'))
        else:
            flash('Login Unsuccessful. Please check username and password', 'danger')
            #return redirect(url_for('hello'))
    return render_template('login.html', log=form)

@app.route("/option",methods=['GET','POST'])
def option():
    url = "https://finance.yahoo.com/quote/MRF.NS?p=MRF.NS"
    item = "MRF"
    r = requests.get(url)
    soup = BeautifulSoup(r.content, "html.parser")
    currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
    stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

    stock_price_c = float(stock_price.replace(',', ''))
    stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
    return render_template('choice.html',char=item,price = stock_price_c,diff=stock_price_change)

@app.route("/choice",methods=['GET','POST'])
def choice():
    item = Scrap()
    if item.validate_on_submit():
        stock_value = item.stock.data

        urlf = "https://finance.yahoo.com/quote/?p=" + stock_value + ".NS"
        re = requests.get(urlf)
        soup = BeautifulSoup(re.content, "html.parser")
        currencye = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
        stock_price_e = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

        stock_price_f = float(stock_price_e.replace(',', ''))
        stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
        return render_template('price2.html', char=stock_value, price=stock_price_f, link=urlf, cur=currencye,
                               diff=stock_price_change)
    return render_template('index.html',item=item)

@app.route("/usdata",methods=['GET','POST'])
def userdata():
    form = StockItem()
    if form.validate_on_submit():
        post = Item(stock = form.stock.data,mail=form.mail.data,bar=form.bar.data,lim=form.lim.data,tim=form.tim.data)
        db.session.add(post)
        db.session.commit()
        return redirect(url_for('hello'))
    return render_template('index.html',form=form)


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
        global tim

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
        tim = item.tim.data
        tim = int(tim)
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
                body = f"stock price of  {stock_item} is {stock_price_c} \n \n {stock_price_change} \n\ncheck here {url} "
                msg = f"Subject : {subject} \n\n {body}"
            # sender = input("Enter email :")
                smtp.sendmail(EMAIL_ADDRESS, reciever, msg)

            return render_template('price.html',char=stock_item,price=stock_price_c,link=url,cur=currency,diff=stock_price_change)


        return render_template('price.html', char=stock_item, price=stock_price_c, link=url,cur=currency,diff=stock_price_change)

        #else:
            #return render_template('price.html',msg="Price of Stock is under 1000/-" )

    return render_template('tracker.html', item=item)

@app.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('hello'))

@app.route('/home')
def home():
    form = Scrap()
    return render_template('index.html',item=form)

@app.route('/price',methods=['GET','POST'])
def price():
    while True:
        r = requests.get(url)
        soup = BeautifulSoup(r.content, "html.parser")
        currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
        stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
        stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
        stock_price_p = float(stock_price.replace(',', ''))
        if stock_price_p > over and stock_price_p < comp:
            with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
                smtp.ehlo()
                smtp.starttls()
                smtp.ehlo()

                smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
                subject = "Heyy ! Your stock price is under your limit"
                body = f"stock price of  {stock_item} is {stock_price_p} \n\n {stock_price_change} \n check here: {url} "
                msg = f"Subject : {subject} \n\n {body}"
        # sender = input("Enter email :")
                smtp.sendmail(EMAIL_ADDRESS, reciever, msg)
            time.sleep(tim)