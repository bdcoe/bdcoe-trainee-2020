import {Component, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector:'app-login',
  templateUrl:'./login.component.html',
  styleUrls:['./login.component.css']
})
export class loginComoponent implements OnInit{

  login(data:NgForm){
    console.log(data.value)
    data.resetForm();
  }

  ngOnInit(): void{
  }
}
