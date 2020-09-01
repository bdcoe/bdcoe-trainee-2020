from django.db import models

# Create your models here.

class Author(models.Model):
    first_name=models.CharField(max_length=30)
    email=models.EmailField(max_length = 254, null = True)
    def __str__(self):
        return self.first_name

class Article(models.Model):
    title=models.CharField(max_length=50)
    Write_article=models.CharField(max_length=10000)
    email=models.EmailField(max_length = 254, null = True)
    author=models.ManyToManyField('Author')
    CreatedAt=models.DateTimeField(auto_now_add= True)
    def __str__(self):
        return self.title
