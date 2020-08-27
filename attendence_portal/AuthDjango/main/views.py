from django.http import HttpResponse
from django.shortcuts import render,get_object_or_404
from django.contrib.auth.decorators import login_required
# Create your views here.
@login_required(login_url='auth/login')
def index(request):
    return render(request,'main/index.html')



from main import models
# Create your views here.
def indexes(request):
    #queries are executed lazily
    latest_students=models.Student.objects.all().order_by('-CreatedAt')[:10]
    context={
        "latest_students": latest_students
    }
    return render(request, 'main/portal.html', context)


def create_student(request):
    students =models.Student.objects.all()
    context={
        "students":students
    }
    if request.method=="POST":
        student_data= {
            "name":request.POST['title'],
            "roll_number":request.POST['roll']
        }

        student = models.Student.objects.create(**student_data)
        context["success"]= True
        
    return render(request,'main/create_student.html',context)



def mark_attendence(request):
    students =models.Student.objects.all()
    context={
        "students":students
    }
    Student.attendence += 1  
    Student.save()
    return  render(request,'main/mark_attendence.html',context)