import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegisterComp } from '../shared/regiser.service'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(public Registerf:RegisterComp) { }

  register(form:NgForm){
    this.Registerf.onRegisterPost(form.value);
    form.resetForm();
  }
  ngOnInit(): void{
  }

}
