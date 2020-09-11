import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(public Registerf:ServiceComp) { }

  register(form:NgForm){
    this.Registerf.onRegisterPost(form.value);
    form.resetForm();
  }
  ngOnInit(): void{
  }

}
