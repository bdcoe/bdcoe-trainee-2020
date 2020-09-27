from django.shortcuts import render
from django.views.generic import ListView,DetailView,CreateView
from .models import Entry
from django.contrib.auth.mixins import LoginRequiredMixin




class HomeView(LoginRequiredMixin,ListView):
    model = Entry
    template_name = 'main/index.html'
    context_object_name = "blog_entries"
    ordering = ['-entry_date']
    paginate_by = 3

class EntryView(LoginRequiredMixin,DetailView):
    model = Entry
    template_name = 'main/article.html'

class CreateEntryView(LoginRequiredMixin,CreateView):
    model = Entry
    template_name = 'main/create_article.html'
    fields = ['entry_title','entry_text']

    def form_valid(self,form):
        form.instance.entry_author = self.request.user
        return super().form_valid(form)
