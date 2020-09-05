from django.db import models

# Create your models here.

class Student(models.Model):
    name=models.CharField(max_length=30)
    roll_number=models.IntegerField()
    number_of_days_present=models.IntegerField(default=0)
    total_number_of_days=models.IntegerField(default=0)
    COMPUTER = 'CSE'
    ELECTRONIC = 'ECE'
    MECHANICAL = 'ME'
    CIVIL = 'CE'
    IT = 'IT'
    BRANCH_CHOICES = [
        (COMPUTER, 'COMPUTER'),
        (ELECTRONIC, 'ELECTRONIC'),
        (MECHANICAL, 'MECHANICAL'),
        (CIVIL, 'CIVIL'),
        (IT, 'IT'),
    ]
    branch = models.CharField(
        max_length=3,
        choices=BRANCH_CHOICES,
        default=COMPUTER,
    )
    CreatedAt=models.DateTimeField(auto_now_add= True)
    def __str__(self):
        return self.name