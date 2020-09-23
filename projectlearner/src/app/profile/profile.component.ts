import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef, MatDialogConfig } from '@angular/material/dialog'
import { ProfileEditDialogComponent } from '../profile-edit-dialog/profile-edit-dialog.component';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  fname: string
  lname: string
  phone: number
  email: string
  myquestion: number
  mysolution: number
  language: string
  img: String
  openEditForm() {
    var Config = new MatDialogConfig();
    Config.width = '60%';
    Config.height = 'auto'
    var close =this.dialog.open(ProfileEditDialogComponent, Config)
    close.afterClosed().subscribe(ele=>{
      console.log(ele)
      this.fname = ele['fname'];
      this.lname = ele['lname'];
      this.phone = ele['phone'];
      this.language = ele['language'];
      console.log(ele)
      if(ele['imagePath']!=null)
      this.img = ele['imagePath']
    })
  }
  constructor(private res: ServiceComp, private router: Router, private dialog: MatDialog) {
  }
  spinner: boolean = false

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true
    this.res.profileFetch().subscribe(user => {
      console.log(user)
      this.spinner = false
      this.fname = user['fname'];
      this.lname = user['lname'];
      this.phone = user['phone'];
      this.email = user['email'];
      this.myquestion = user['myquestion'];
      this.mysolution = user['mysolution'];
      this.language = user['language'];
      this.img = user['imagePath']
    }, error => {
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })

  }

}
