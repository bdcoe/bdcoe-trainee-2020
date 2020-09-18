import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service'
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { TechsupportComponent } from '../techsupport/techsupport.component';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(public res: ServiceComp, private router: Router, private dialog: MatDialog) {
  }
  ngOnInit() {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }

  }

} 
