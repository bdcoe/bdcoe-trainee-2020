import { Component, OnInit } from '@angular/core';
import { User } from '../shared/User';
import { NgForm } from '@angular/forms';
import { RegisterComp } from '../shared/regiser.service'
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private RegisterSubs:Subscription;
  constructor(public Registerf:RegisterComp) { }

  register(form:NgForm){
    this.Registerf.onRegisterPost(form)
  }
  ngOnInit(): void{
  }

}
