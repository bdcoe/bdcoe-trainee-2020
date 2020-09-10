import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-techsupport',
  templateUrl: './techsupport.component.html',
  styleUrls: ['./techsupport.component.css']
})
export class TechsupportComponent implements OnInit {

  techsubmit(data:NgForm){
    console.log(data.value)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
