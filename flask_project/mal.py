from flask import Flask, render_template,url_for
import requests
from bs4 import BeautifulSoup
import smtplib
import os
import time
app = Flask(__name__)

@app.route("/")
def hello():
    return render_template('index.html')

app.run(debug=True)
'''
post = [
    {
        "author":"Arpan Malik",
    }
]

@app.route("/")
def hello():
    char = input("Enter your item :")
    url = "https://finance.yahoo.com/quote/?p=" + char+".NS"
    print(url)
    r = requests.get(url)
    soup = BeautifulSoup(r.content,"html.parser")
    currency = soup.find(class_="C($tertiaryColor) Fz(12px)" ).find("span").get_text()
    stock_price = soup.find(class_="Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").get_text()
    stock_price_c = float(stock_price.replace(',',''))
        #amount = float(input("Enter the limit under which you want notified :"))
    stock_price_change = soup.find("div",class_="D(ib) Mend(20px)").find("span").next_sibling.get_text()
    return render_template('index.html', stock = stock_price_c, item = char)

@app.route("/about")
def malik():
    nam = "Arpan Malik"
    return render_template('about.html', name = nam)

app.run(debug = True)
'''