import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ServiceComp } from '../shared/service.service'

@Component({
  selector: 'app-profile-edit-dialog',
  templateUrl: './profile-edit-dialog.component.html',
  styleUrls: ['./profile-edit-dialog.component.css']
})
export class ProfileEditDialogComponent implements OnInit {
  fname: String
  lname: String
  phone: String
  language: String
  form: FormGroup
  image
  imagePreview

  constructor(private res: ServiceComp,
    public dialogRef: MatDialogRef<ProfileEditDialogComponent>) {

  }
  editForm() {
    if(this.form.invalid){
      return;
    }else{
      console.log(this.form.value)
      return this.res.oneditprofile(this.form.value).subscribe((ele)=>{
        this.fname=ele['fname']
      },error=>{
        console.log(error)
      })
    }
  }
  onimagepick(event:Event){
    const file = (event.target as HTMLInputElement).files[0];
    this.form.patchValue({
      image:file
    });
    this.form.get('image').updateValueAndValidity();
    const reader = new FileReader();
    reader.onload = ()=>{
      this.imagePreview = reader.result
    }
    reader.readAsDataURL(file)
  }
  ngOnInit(): void {
    this.form = new FormGroup({
      'fname': new FormControl(null, { validators: [Validators.required] }),
      'lname': new FormControl(null, { validators: [Validators.required] }),
      'phone': new FormControl(null, { validators: [Validators.required] }),
      'language': new FormControl(null, { validators: [Validators.required] }),
      'image':new FormControl(null)
    })
    this.res.profileFetch().subscribe((data) => {
      this.form.setValue({
        'fname': data['fname'], 'lname': data['lname'], 'phone': data['phone'],
        'language': data['language'],'image':null
      })
    })
  }

}
