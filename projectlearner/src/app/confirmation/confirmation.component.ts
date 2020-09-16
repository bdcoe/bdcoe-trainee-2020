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
  delete(){
    this.res.ondeleteProblem(this.ID).subscribe(()=>{
      console.log('deleted')
    })
  }
  constructor(
    @Inject(MAT_DIALOG_DATA) data,private res:ServiceComp) {  
    this.ID = data
  }

  ngOnInit(): void {
  }

}
