import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceComp } from '../shared/service.service';
import { MatSnackBar } from '@angular/material/snack-bar'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(public Registerf:ServiceComp,private router:Router) { }

  error:string='';
  hide:boolean = true;
  register(form:NgForm){
    console.log(form.value)
    if(form.value['password']==form.value['cpassword'])
    this.Registerf.onRegisterPost(form.value).subscribe((success)=>{
      this.router.navigate([''])
    },error=>{
      this.Registerf.openSnackBar('Error',error['error']['message'])
    });
    else{
      this.Registerf.openSnackBar('Error','Password did\'t match')
    }
    form.resetForm();
  
  }
  ngOnInit(): void{
  }

}
