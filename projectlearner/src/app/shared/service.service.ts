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
    return this.http.get('http://localhost:3000/profile', { headers: headers })
  }

  onaddproblem(post) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    this.http.post('http://localhost:3000/addproblem', post, { headers: headers })
  }

  oneditprofile(post) {
    console.log(post)
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'authorization': `Bearer ${localStorage.getItem('token')}` })
    this.http.put('http://localhost:3000/register', post, { headers: headers }).subscribe(() => {
      console.log('yup')
    })
  }

  onlogin(post) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    console.log(post)
    this.http.post('http://localhost:3000/', post, { headers: headers })
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
