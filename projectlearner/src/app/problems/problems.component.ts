import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddproblemComponent } from '../addproblem/addproblem.component';
import { ConfirmationComponent } from '../confirmation/confirmation.component';
// import { AddsolutionComponent } from '../addsolution/addsolution.component';


@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {
  problems: { [keys: string]: any }
  constructor(private res: ServiceComp, private router: Router, public dialog: MatDialog) { }
  panelOpenState
  spinner: boolean = false
  onConfirmation(_id) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { id: _id, Profile: 'Problem' };
    dialogConfig.width = '60%';
    dialogConfig.height = 'auto'
    const deletdialog = this.dialog.open(ConfirmationComponent, dialogConfig)
    deletdialog.afterClosed().subscribe(ele => {
      this.res.fetchmyproblem().subscribe(element => {
        this.problems = element['problems']
      })
    })
  }
  editproblem(_id) {
    const dialogConfig = new MatDialogConfig();
    var t = this.problems.filter(ele => {
      return ele['_id'] == _id
    })
    dialogConfig.data = { _id: _id, array: t };
    const editDialog = this.dialog.open(AddproblemComponent, dialogConfig)
    editDialog.afterClosed().subscribe(ele => {
      this.spinner=true
      this.res.fetchmyproblem().subscribe(element => {
        this.spinner=false
        this.problems = element['problems']
      })
    })
  }
  Problem() {
    const adddialog = this.dialog.open(AddproblemComponent, { width: '60%', height: 'auto' })
    adddialog.afterClosed().subscribe(ele => {
      this.res.fetchmyproblem().subscribe(element => {
        this.problems = element['problems']
        if (this.problems.length == 0) {
          this.error = 'No problems Posted Yet'
        }else{
          this.error='';
        }
      }, error => {
        this.res.openSnackBar('Error', error)
      })
    }, error => {
      this.res.openSnackBar('Error', error)
    })
  }
  error: string = ''
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true
    this.res.fetchmyproblem().subscribe(element => {
      this.spinner = false
      this.problems = element['problems']
      if (this.problems.length == 0) {
        this.error = 'No problems Posted Yet'
      }
    }, error => {
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })
  }

}
