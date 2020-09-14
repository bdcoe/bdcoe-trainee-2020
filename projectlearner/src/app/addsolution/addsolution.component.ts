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
  constructor(
    @Inject(MAT_DIALOG_DATA) data,private res:ServiceComp) {
    this.ID = data
  }
  onaddSol(post:NgForm){
    post.value.QId=this.ID
    this.res.onaddsolution(post.value)
  }
  ngOnInit(): void {
  }

}
