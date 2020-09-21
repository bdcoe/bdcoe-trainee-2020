from flask import Flask, render_template, url_for, flash, redirect
from flask_sqlalchemy import SQLAlchemy
import sqlite3
from flask_project.form import RegistrationForm, LoginForm, StockItem
import requests
from bs4 import BeautifulSoup
import smtplib
import os
from datetime import datetime




app = Flask(__name__)
app.config['SECRET_KEY'] = "a21c87da853ec22e5230087cda344792f7b897f681d113bedc"
#app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///C:\\absolute\\path\\to\\foo.db'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///site.db'
db = SQLAlchemy(app)
con = sqlite3.connect("db")
'''
engine = create_engine('sqlite:///college.db', echo = True)
meta = MetaData()

students = Table(
   'students', meta,
   Column('id', Integer, primary_key = True),
   Column('name', String),
   Column('lastname', String),
)
meta.create_all(engine)
'''
class User(db.Model):

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(20), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)

    password = db.Column(db.String(60), nullable=False)

    def __repr__(self):
        return f"User('{self.username}','{self.email}')"



@app.route("/")
def hello():
    return render_template('index.html')

@app.route("/about", methods = ['GET', 'POST'])
def registration():
    form = RegistrationForm()
    if form.validate_on_submit():
        flash(f"Account createf for {form.username.data}!", "success")
        return redirect(url_for('hello'))
    return render_template('about.html', form=form)

@app.route("/login",methods = ['GET', 'POST'])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        if form.email.data == 'admin@blog.com' and form.password.data == 'password':
            flash('You have been logged in!', 'success')
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
        stock_item = item.stock.data
        url = "https://finance.yahoo.com/quote/?p=" + stock_item + ".NS"
        print(url)

        r = requests.get(url)
        soup = BeautifulSoup(r.content, "html.parser")
        currency = soup.find(class_="C($tertiaryColor) Fz(12px)").find("span").get_text()
        stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()

        stock_price_c = float(stock_price.replace(',', ''))

        stock_price_change = soup.find("div", class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
        #if stock_price_c > 1000:
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

        return render_template('price.html',char=stock_item,price=stock_price_c,link=url)
        #else:
            #return render_template('price.html',msg="Price of Stock is under 1000/-" )

    return render_template('tracker.html', item=item)
'''
@app.route("/send", methods=["GET","POST"])
def send_mail():
    fm = EmailNotify()
    if fm.validate_on_submit():
        EMAIL_ADDRESS = os.environ.get("email_address")
        EMAIL_PASSWORD = os.environ.get("email_password")
        reciever = "kabirsinghup17@gmail.com"
        #if stock_price_c < 3000.00:
        with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
            smtp.ehlo()
            smtp.starttls()
            smtp.ehlo()

            smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
            subject = "Heyy ! Your stock price is under your limit"
            body = f"stock price of  stock_item is stock_price_c "
            msg = f"Subject : {subject} \n\n {body}"
        #sender = input("Enter email :")
            smtp.sendmail(EMAIL_ADDRESS, reciever, msg)
        return render_template('notify.html', m="Email Sent")
    return render_template('send_mail.html', fm=fm)

#@app.route("/notify", methods=["GET","POST"])
#def notification():

'''




app.run(debug=True)

'''
    if fm.validate_on_submit():
        EMAIL_ADDRESS = os.environ.get("email_address")
        EMAIL_PASSWORD = os.environ.get("email_password")
        reciever = "kabirsinghup17@gmail.com"
        if stock_price_c < 3000.00:
            with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
                smtp.ehlo()
                smtp.starttls()
                smtp.ehlo()

                smtp.login(EMAIL_ADDRESS, EMAIL_PASSWORD)
                subject = "Heyy ! Your stock price is under your limit"
                body = f"stock price of  {item} is {stock_price_c} "
                msg = f"Subject : {subject} \n\n {body}"
        #sender = input("Enter email :")
                smtp.sendmail(EMAIL_ADDRESS, reciever, msg)
            return render_template('notify.html', m="Email Sent")


'''