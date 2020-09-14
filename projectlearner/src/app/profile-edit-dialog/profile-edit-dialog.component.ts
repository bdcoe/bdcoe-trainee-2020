import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service'

@Component({
  selector: 'app-profile-edit-dialog',
  templateUrl: './profile-edit-dialog.component.html',
  styleUrls: ['./profile-edit-dialog.component.css']
})
export class ProfileEditDialogComponent implements OnInit {
  fname:String
  lname:String
  phone:String
  language

  constructor(private res:ServiceComp) { }

  editForm(data: NgForm) {
   this.res.oneditprofile(data.value)
  }

  ngOnInit(): void {
    this.res.profileFetch().subscribe((data)=>{
      this.fname=data['fname'];
      this.lname=data['lname'];
      this.phone=data['phone'];
      this.language=data['language'];
      console.log(this.fname)
    })
  }

}
