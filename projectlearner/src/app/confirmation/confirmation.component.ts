import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ServiceComp } from '../shared/service.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {
  ID;
  req;
  delete(){
    this.res.ondeleteProblem(this.ID,this.req).subscribe(()=>{
      console.log('deleted')
    })
  }
  constructor(
    @Inject(MAT_DIALOG_DATA) data,private res:ServiceComp) {  
    this.ID = data['id'];
    this.req= data['Profile']
  }

  ngOnInit(): void {
  }

}
