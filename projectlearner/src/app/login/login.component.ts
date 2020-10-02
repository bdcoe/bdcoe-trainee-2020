import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceComp } from '../shared/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class loginComponent implements OnInit {
  constructor(public Loginf: ServiceComp, private router: Router) { }

  login(data: NgForm) {
    this.Loginf.onlogin(data.value).subscribe(
      (response: any) => {
        localStorage.setItem('token', response['token'])
        this.router.navigate(['/dashboard'])
      }
      , (error) => {
        this.Loginf.openSnackBar('Error', error.error.message)
        data.resetForm();
      })
  }
  hide: boolean = true;
  siteKey = '6Lc7ydIZAAAAAHX57_w0kSqqkeZK8bA7WeHBEQ64'

  ngOnInit(): void {
    if (localStorage.getItem('token') != null) {
      localStorage.removeItem('token')
    }
  }
}
