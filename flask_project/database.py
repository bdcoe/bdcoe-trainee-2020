from flask_project.tut import db
from flask_project.tut import User



db.create_all()
user_1 = User(username="arp", email="arp@gmail.com", password="flask")
#db.session.add(user_1)
#print(User.query.all())