from django.db import models
from django.contrib.auth.models import User
# Create your models here.

class Entry(models.Model):
    entry_title = models.CharField(max_length=50)
    entry_text = models.TextField(max_length=10000)
    entry_email = models.EmailField(max_length = 254, null = True)
    entry_date = models.DateTimeField(auto_now_add= True)
    entry_author = models.ForeignKey(User, on_delete=models.CASCADE)
    
    def __str__(self):
        return f'{self.entry_title}'