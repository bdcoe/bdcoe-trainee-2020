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
  dash;
  skills:String;
  image:String;
  rating:Number;
  ngOnInit() {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.res.ondashboard().subscribe(ele=>{
      console.log(ele['message'][0])
      this.skills = ele['message'][0]['skills'];
      this.image = ele['message'][0]['imagePath'];
      this.rating = ele['message'][0]['rating']
      this.dash=ele['message']
    },error=>{
      this.router.navigate([''])
      console.log(error['error']['message'])
      this.res.openSnackBar('Error',error)
    })

  }

} 
