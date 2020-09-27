from django.urls import path
from main import views
from .views import HomeView,EntryView,CreateEntryView
urlpatterns= [
    path('index',HomeView.as_view(),name='blog-home'),
    path('main/<int:pk>/',EntryView.as_view(),name='entry-detail'),
    path('create_entry/',CreateEntryView.as_view(success_url = '/'), name = 'create_entry')
]