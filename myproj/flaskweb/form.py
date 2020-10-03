from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, BooleanField, FloatField, IntegerField
from wtforms.validators import DataRequired, Length, Email, EqualTo, ValidationError
from flaskweb.database import User

class RegistrationForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=12)])
    email = StringField('Email', validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired(), Length(min=6)])
    confirm_password = PasswordField('Confirm Password', validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField('Sign Up')

    def validate_username(self, username):
        user = User.query.filter_by(username=username.data).first()
        if user:
            raise ValidationError(' username is already exist, please choose a different one.')

    def validate_email(self,email):
        user = User.query.filter_by(email=email.data).first()
        if user:
            raise ValidationError(" this email is already exist, please enter yours !")

class LoginForm(FlaskForm):
    email = StringField('Email', validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    remember = BooleanField('Remember Me')
    submit = SubmitField('Login')

class Scrap(FlaskForm):
    stock = StringField('Enter the Organisation of which you want to track stock :', validators=[DataRequired()])
    submit = SubmitField('Track')


class StockItem(FlaskForm):
    stock = StringField('Enter the Organisation of which you want to track stock', validators=[DataRequired()])
    submit = SubmitField('Track')
    mail = StringField('Enter the email on which you want notification :', validators=[DataRequired()])
    lim = FloatField('Enter the price over which you want notification :',  validators=[DataRequired()])
    bar = FloatField('Enter the price under which you want notification :', validators=[DataRequired()])
    tim = IntegerField('Enter the time period(in seconds) after which you want notification :', validators=[DataRequired()])
'''
class EmailNotify(FlaskForm):
   # mail = StringField('Enter the email on which you want notification :', validators=[DataRequired()])
    time = FloatField('Enter the time period after which you want notification :', validators=[DataRequired()])
    submit = SubmitField('Notify me')
'''