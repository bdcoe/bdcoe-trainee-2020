import { Component, OnInit } from '@angular/core';
import { User } from '../shared/User';
import { NgForm } from '@angular/forms';
import { RegisterComp } from '../shared/regiser.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  regiser(form: NgForm) {
    this.regiser(form)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
