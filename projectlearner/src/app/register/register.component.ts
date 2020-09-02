import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
 
  newmodel="";
  newm=""

  onSave(){
    this.newm=this.newmodel
  }
  constructor() { }

  ngOnInit(): void {
  }

}
