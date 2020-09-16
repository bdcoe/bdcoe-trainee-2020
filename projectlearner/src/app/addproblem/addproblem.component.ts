import { Component, Inject, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service'
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-addproblem',
  templateUrl: './addproblem.component.html',
  styleUrls: ['./addproblem.component.css']
})
export class AddproblemComponent implements OnInit {

  tech;
  update;
  addproblem(data: NgForm) {
    if(this.update==null){
    this.res.onaddproblem(data.value)
  }else{
    data.value.update= this.update
    this.res.oneditProblem(data.value).subscribe(()=>{
      console.log('done')
    })
  }
  }
  constructor(private res: ServiceComp,@Inject(MAT_DIALOG_DATA) data) {
    this.update=data;
   }

  ngOnInit(): void {
    this.res.ongetaddproblem().subscribe(ele=>{
      this.tech = ele['message'];
    },error=>{
      console.log(error)
    })
  }

}
