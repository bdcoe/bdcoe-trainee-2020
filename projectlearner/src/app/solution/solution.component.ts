import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ConfirmationComponent } from '../confirmation/confirmation.component'
import { AddsolutionComponent } from '../addsolution/addsolution.component';


@Component({
  selector: 'app-solution',
  templateUrl: './solution.component.html',
  styleUrls: ['./solution.component.css']
})
export class SolutionComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router, private dialog: MatDialog) { }

  QA;
  spinner: boolean = false
  error: String = '';
  onConfirmation(_id) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { id: _id, Profile: 'Solution' };
    dialogConfig.width = '60%';
    dialogConfig.height = 'auto'
     const deletedialog=this.dialog.open(ConfirmationComponent, dialogConfig)
     deletedialog.afterClosed().subscribe(ele=>{
       this.res.fetchSolution().subscribe(element=>{
         this.QA= element['message']
       })
     })
  }

  editsolution(data) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { update: data };
    dialogConfig.width = '70%';
    dialogConfig.height = 'auto'
     const editsol=this.dialog.open(AddsolutionComponent, dialogConfig)
     editsol.afterClosed().subscribe(ele=>{ 
       this.res.fetchSolution().subscribe(element=>{
         this.QA = element['message']
       })
     })
  }
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true
    this.res.fetchSolution().subscribe(element => {
      this.spinner = false
      this.QA = element['message'];
      if (this.QA.length == 0) {
        this.error = 'No Problem solved by Your Side'
      }
    }, error => {
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })
  }
}
