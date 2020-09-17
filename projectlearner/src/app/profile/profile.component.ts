import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router';
import { MatDialog,MatDialogRef } from '@angular/material/dialog'
import { ProfileEditDialogComponent } from '../profile-edit-dialog/profile-edit-dialog.component';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  fname:string
  lname:string
  phone:number
  email:string
  myquestion:number
  mysolution:number
  openEditForm(){
  this.dialog.open(ProfileEditDialogComponent)
  }
  constructor(private res: ServiceComp, private router: Router,private dialog:MatDialog) {
  }
  spinner:boolean=false

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner=true
    this.res.profileFetch().subscribe(user=>{
      this.spinner=false
    this.fname=user['fname'];
    this.lname=user['lname'];
    this.phone=user['phone'];
    this.email=user['email'];
    this.myquestion=user['myquestion'];
    this.mysolution=user['mysolution']
    },error=>{
      this.router.navigate([''])
    })

  }

}
