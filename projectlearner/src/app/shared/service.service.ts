import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User, TechSuppModel } from './Service.model'
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class ServiceComp implements OnInit {
  public token;
  public error;
  constructor(private http: HttpClient, private router: Router) { }

  profileFetch() {
    const headers = new HttpHeaders({ 'authorization': `Bearer ${localStorage.getItem('token')}` })
    // const headers = ({'authorization':`Bearer ${localStorage.getItem('token')}`})
    this.http.get('http://localhost:3000/profile', { headers: headers }).subscribe(value => {
      console.log(value)
    })
  }

  onlogin(post) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    console.log(post)
    this.http.post('http://localhost:3000/', post)
      .subscribe(
        (response: any) => {
          localStorage.setItem('token', response['token'])
          this.router.navigate(['/dashboard'])
          // console.log(localStorage.getItem('token'))
        }
        , (error) => {
          console.log(error.error.message)
        })
  }
  onRegisterPost(post: User) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    this.http.post('http://localhost:3000/register/', post, { headers: headers }).subscribe(() => {
      console.log('success')
    })
  }
  onTechPost(post: TechSuppModel) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    this.http.post('http://localhost:3000/techsupport/', post, { headers: headers }).subscribe(() => {
      console.log('edited')
    })
  }

  isloggedin() {
    return !!localStorage.getItem('token')
  }


  ngOnInit() { }
}
