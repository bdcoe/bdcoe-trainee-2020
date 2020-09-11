import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service';

@Component({
  selector: 'app-techsupport',
  templateUrl: './techsupport.component.html',
  styleUrls: ['./techsupport.component.css']
})
export class TechsupportComponent implements OnInit {


  constructor(public Techs:ServiceComp) { }


  techsubmit(data:NgForm){
    this.Techs.onTechPost(data.value)
  }

  ngOnInit(): void {
  }

}
