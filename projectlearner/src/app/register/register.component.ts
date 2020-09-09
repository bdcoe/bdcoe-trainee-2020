import { Component, OnInit } from '@angular/core';
import { User } from '../shared/User';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  regiser(form: NgForm) {
    console.log(form.value)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
