from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup

my_url = "https://www.newegg.com/Video-Cards-Video-Devices/Category/ID-38?Tpk=graphics+card"
#opening up connection, grabbing the page
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()
#html parser
page_soup = soup(page_html,"html.parser")
page_soup.h1()
#grab each product
containers = page_soup.findAll("div",{"class":"item-container"})
#print(containers)
print(len(containers))
print(containers[0])