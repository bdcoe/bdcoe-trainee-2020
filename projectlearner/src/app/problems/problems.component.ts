import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'
import { MatDialog } from '@angular/material/dialog';
import { AddproblemComponent } from '../addproblem/addproblem.component';


@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {
  problems:{[keys:string]:any}
  constructor(private res: ServiceComp, private router: Router,private dialog:MatDialog) { }

  AddProblem(){
   this.dialog.open(AddproblemComponent,{width:'60%',height:'auto'})
  }
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
  }

}
