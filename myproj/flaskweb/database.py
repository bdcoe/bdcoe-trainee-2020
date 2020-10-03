
from datetime import datetime
from flaskweb import db, login_manager
from flask_login import UserMixin
from sqlalchemy import column
from sqlalchemy.dialects.postgresql import insert
@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))



class User(db.Model,UserMixin):

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(20), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)

    password = db.Column(db.String(60), nullable=False)

    def __repr__(self):
        return f"User('{self.username}','{self.email}')"

class Item(db.Model,UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    stock = db.Column(db.String(50),nullable=False)
    mail = db.Column(db.String(50),nullable=False)
    bar = db.Column(db.Float,nullable=False)
    lim = db.Column(db.Float,nullable=False)
    tim = db.Column(db.Float,nullable=False)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    def __repr__(self):
        return f"Item('{self.stock}','{self.mail}','{self.tim}')"