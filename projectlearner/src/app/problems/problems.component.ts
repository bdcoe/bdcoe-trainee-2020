import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddproblemComponent } from '../addproblem/addproblem.component';
import { ConfirmationComponent } from '../confirmation/confirmation.component';
import { AddsolutionComponent } from '../addsolution/addsolution.component';


@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {
  problems: { [keys: string]: any }
  constructor(private res: ServiceComp, private router: Router, public dialog: MatDialog) { }
  panelOpenState
  onConfirmation(_id) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = _id;
    dialogConfig.width = '60%';
    dialogConfig.height = 'auto'
    this.dialog.open(ConfirmationComponent, dialogConfig)
  }
  editproblem(_id){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = _id;
    this.dialog.open(AddproblemComponent,dialogConfig)
  }
  Problem() {
    this.dialog.open(AddproblemComponent, { width: '60%', height: 'auto' })
  }
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    
    this.res.fetchmyproblem().subscribe(element => {
      this.problems = element['problems']
      console.log(this.problems)
    },error=>{
      this.router.navigate([''])
    })
  }

}
