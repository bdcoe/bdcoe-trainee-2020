from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, BooleanField, FloatField
from wtforms.validators import DataRequired, Length, Email, EqualTo

class RegistrationForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=12)])
    email = StringField('Email', validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    confirm_password = PasswordField('Confirm Password', validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField('Sign Up')


class LoginForm(FlaskForm):
    email = StringField('Email', validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    remember = BooleanField('Remember Me')
    submit = SubmitField('Login')


class StockItem(FlaskForm):
    stock = StringField('Enter the Organisation of which you want to track stock', validators=[DataRequired()])
    submit = SubmitField('Track')
    mail = StringField('Enter the email on which you want notification :', validators=[DataRequired()])
    bar = FloatField('Enter the price under which you want notification :', validators=[DataRequired()])
class EmailNotify(FlaskForm):
    mail = StringField('Enter the email on which you want notification :', validators=[DataRequired()])
    bar = FloatField('Enter the price under which you want notification :', validators=[DataRequired()])
    submit = SubmitField('Notify me')
