from django.shortcuts import render,get_object_or_404
from main import models
# Create your views here.
def index(request):
    #queries are executed lazily
    latest_articles=models.Article.objects.all().order_by('-CreatedAt')[:10]
    context={
        "latest_articles": latest_articles
    }
    return render(request, 'main/index.html', context)

def article(request,pk):
    article=get_object_or_404(models.Article,pk=pk)

    context={
        "article":article
    }
    return render(request,'main/article.html',context)

def author(request, pk):
    author=get_object_or_404(models.Author,pk=pk)

    context={
        "author": author
    }
    return render(request, 'main/author.html', context)

def create_article(request):

    authors =models.Author.objects.all()
    context={
        "authors":authors
    }
    if request.method=="POST":
        article_data= {
            "title":request.POST['title'],
            "Write_article":request.POST['content']
        }

        article = models.Article.objects.create(**article_data)
        author = models.Author.objects.filter(pk= request.POST['author'])
        article.author.set(author)
        context["success"]= True
        
    return render(request,'main/create_article.html',context)

def create_author(request):
    authors =models.Author.objects.all()
    context={
        "authors":authors
    }
    if request.method=="POST":
        author_data= {
            "first_name":request.POST['title']
        }

        author = models.Author.objects.create(**author_data)
        context["success"]= True
        
    return render(request,'main/create_author.html',context)