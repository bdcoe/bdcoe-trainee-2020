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

  onaddsolution(post) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    this.http.put('http://localhost:3000/solution', post, { headers: headers }).subscribe(()=>{
      console.log('solution added')
    })
  }

  fetchmyproblem() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get('http://localhost:3000/problem', { headers: headers })
  }
  fetchallProblem() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get('http://localhost:3000/allproblem', { headers: headers })
  }
  onaddproblem(post) {
    console.log(post, 'yes')
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    this.http.post('http://localhost:3000/addproblem/', post, { headers: headers })
      .subscribe(() => {
        console.log('yewadafjokln')
      })
  }
  ongetaddproblem() {
    const headers = new HttpHeaders({ 'authorization': `Beared ${localStorage.getItem('token')}` })
    return this.http.get('http://localhost:3000/addproblem/', { headers: headers })
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
