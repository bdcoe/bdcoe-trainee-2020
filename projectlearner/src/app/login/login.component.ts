import {Component, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';
import {ServiceComp} from '../shared/service.service'

@Component({
  selector:'app-login',
  templateUrl:'./login.component.html',
  styleUrls:['./login.component.css']
})
export class loginComponent implements OnInit{

  constructor(public Loginf:ServiceComp){}
  login(data:NgForm){
    this.Loginf.onlogin(data.value)
    data.resetForm();
  }

  ngOnInit(): void{
    if(localStorage.getItem('token')!=null)
    {
      localStorage.removeItem('token')
    }
  }
}
