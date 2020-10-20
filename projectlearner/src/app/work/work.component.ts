import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsolutionComponent } from '../addsolution/addsolution.component';



@Component({
  selector: 'app-work',
  templateUrl: './work.component.html',
  styleUrls: ['./work.component.css']
})
export class WorkComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router, private dialog: MatDialog) { }
  work; spinner = false;
  addsolution(post) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { post: post };
    dialogConfig.width = '700px';
    dialogConfig.height = '550px'
    this.dialog.open(AddsolutionComponent, dialogConfig)
  }
  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true;
    this.res.fetchwork().subscribe(ele => {
      this.spinner = false
      if(ele['bool']==true){
        return this.res.openSnackBar('Warning',ele['message'])
      }
      this.work = ele['message']
    }, error => {
      console.log(error)
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })
  }

}