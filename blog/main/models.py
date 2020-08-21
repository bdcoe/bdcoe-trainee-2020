from django.db import models

# Create your models here.

class Author(models.Model):
    first_name=models.CharField(max_length=30)
    last_name=models.CharField(max_length=30)
    def __str__(self):
        return self.first_name

class Article(models.Model):
    title=models.CharField(max_length=50)
    Write_article=models.CharField(max_length=10000)
    author=models.ManyToManyField('Author')
    date=models.DateTimeField
    def __str__(self):
        return self.title
