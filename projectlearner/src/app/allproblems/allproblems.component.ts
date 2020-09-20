import { Component, OnInit, ɵINJECTOR_IMPL__POST_R3__ } from '@angular/core';
import { ServiceComp } from '../shared/service.service'
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsolutionComponent } from '../addsolution/addsolution.component';

@Component({
  selector: 'app-allproblems',
  templateUrl: './allproblems.component.html',
  styleUrls: ['./allproblems.component.css']
})
export class AllproblemsComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router, private dialog: MatDialog) {

  }
  addsolution(post) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { data: post };
    dialogConfig.width = '700px';
    dialogConfig.height = '550px'
    this.dialog.open(AddsolutionComponent, dialogConfig)
  }
  AllProblems: []
  spinner: boolean = false;
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true;
    this.res.fetchallProblem().subscribe(ele => {
      this.spinner = false
      this.AllProblems = ele['message']
    }, error => {
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })
  }
}

