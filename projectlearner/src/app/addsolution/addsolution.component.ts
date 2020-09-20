import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service';

@Component({
  selector: 'app-addsolution',
  templateUrl: './addsolution.component.html',
  styleUrls: ['./addsolution.component.css']
})
export class AddsolutionComponent implements OnInit {
  ID;
  update;

  constructor(
    @Inject(MAT_DIALOG_DATA) data,private res:ServiceComp) {
      console.log(data)
    this.update = data['update']
    this.ID = data['post']
  }
  onaddSol(post:NgForm){
    console.log(this.ID)
    if(this.ID!=undefined&&this.ID!=null&&this.ID!=''){
    post.value.QId=this.ID
    console.log(post.value)
    this.res.onaddsolution(post.value).subscribe(ele=>{
      console.log(ele)
    },error=>{
      console.log(error)
      this.res.openSnackBar("Error",error['error']['message'])
    })
  }else{
    console.log('edit')
    post.value.update=this.update;
    console.log(post.value)
    this.res.oneditsolution(post.value).subscribe(ele=>{
      console.log(ele,'yes')
    },error=>{
      console.log(error)
    })
  }
  }
  ngOnInit(): void {
  }

}
