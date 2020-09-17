import {Component, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {ServiceComp} from '../shared/service.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector:'app-login',
  templateUrl:'./login.component.html',
  styleUrls:['./login.component.css']
})
export class loginComponent implements OnInit{

  constructor(public Loginf:ServiceComp,private router:Router,private _snackBar: MatSnackBar){}
  openSnackBar(message,action) {
    this._snackBar.open(message, action, {
      duration: 2000,
      verticalPosition: 'top'
    });
  }
  login(data:NgForm){
    this.Loginf.onlogin(data.value).subscribe(
      (response: any) => {
        localStorage.setItem('token', response['token'])
        this.router.navigate(['/dashboard'])
      }
      , (error) => {
        this.openSnackBar('Error',error.error.message)
        data.resetForm();
      })
  }
  hide:boolean = true;

  ngOnInit(): void{
    if(localStorage.getItem('token')!=null)
    {
      localStorage.removeItem('token')
    }
  }
}
