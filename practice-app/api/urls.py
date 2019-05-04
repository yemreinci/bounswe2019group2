from django.urls import path
from . import views

urlpatterns = [
    path('helloworld/', views.HelloWorldView.as_view(), name='helloworld'),
    path('register/', views.RegisterView.as_view(), name='register'),
    path('login/', views.LoginAPIView.as_view(), name='login'),
    path('investments/total_profit', views.TotalProfitAPIView.as_view(), name='total profit'),
    path('investments/profit', views.InvestmentProfitAPIView.as_view(), name='profit'),
    path('investments/create', views.CreateInvestmentAPIView.as_view(), name='create investment'),
    path('investments/delete', views.DeleteInvestmentAPIView.as_view(), name='delete investment')
]