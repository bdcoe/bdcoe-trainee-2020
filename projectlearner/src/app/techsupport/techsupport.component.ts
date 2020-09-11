import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {ServiceComp} from '../shared/service.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-techsupport',
  templateUrl: './techsupport.component.html',
  styleUrls: ['./techsupport.component.css']
})
export class TechsupportComponent implements OnInit {


  constructor(public Techs:ServiceComp,private router:Router) { }


  techsubmit(data:NgForm){
    this.Techs.onTechPost(data.value)
  }

  ngOnInit(): void {
    if(!this.Techs.isloggedin()){
      this.router.navigate([''])
  }
}

}
