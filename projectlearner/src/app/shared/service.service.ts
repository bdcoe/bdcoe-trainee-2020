import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User, TechSuppModel } from './Service.model'
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({ providedIn: 'root' })
export class ServiceComp implements OnInit {
  public token;
  public error;
  private URL: String = 'http://localhost:3000/';
  constructor(private http: HttpClient, private router: Router, private _snackbar: MatSnackBar) { }

  openSnackBar(message, action) {
    this._snackbar.open(message, action, {
      duration: 2000,
      verticalPosition: "top",
      horizontalPosition: "center"
    })
  }

  ondeleteProblem(post, profile) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`,
      'body': `${profile} ${post}`
    })
    return this.http.delete(this.URL + 'problem', { headers: headers })
  }

  fetchwork() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })

    return this.http.get(this.URL + 'work', { headers: headers })
  }

  fetchleaderboard() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'leaderboard', { headers: headers })
  }

  profileFetch() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'profile', { headers: headers })
  }

  onaddsolution(post) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    console.log(post)
    return this.http.post(this.URL + 'solution', post, { headers: headers })
  }

  fetchSolution() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'solution', { headers: headers })
  }

  fetchmyproblem() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'problem', { headers: headers })
  }

  fetchallProblem() {

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'allproblem', { headers: headers })
  }

  onaddproblem(post) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    this.http.post(this.URL + 'addproblem/', post, { headers: headers })
      .subscribe(() => {
        console.log('yewadafjokln')
      })
  }
  ongetaddproblem() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'addproblem/', { headers: headers })
  }
  oneditProblem(post) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.put(this.URL + 'problem', post, { headers: headers })
  }

  oneditprofile(post) {
    var p = new FormData();
    p.append('fname', post.fname);
    p.append('lname', post.lname);
    p.append('language', post.language);
    p.append('phone', post.phone);
    p.append('image', post.image)
    const headers = new HttpHeaders({
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.put(this.URL + 'register', p, { headers: headers })
  }
  oneditsolution(post) {
    console.log(post)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.put(this.URL + 'solution', post, { headers: headers })
  }

  onlogin(post) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    return this.http.post('http://localhost:3000/', post, { headers: headers })
  }

  onRegisterPost(post: User) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    return this.http.post(this.URL + 'register/', post, { headers: headers })
  }

  onTechPost(post: TechSuppModel) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    this.http.post(this.URL + 'techsupport/', post, { headers: headers }).subscribe(() => {
      console.log('edited')
    })
  }
  ondashboard() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'authorization': `Bearer ${localStorage.getItem('token')}`
    })
    return this.http.get(this.URL + 'dashboard', { headers: headers })
  }

  isloggedin() {
    return !!localStorage.getItem('token')
  }


  ngOnInit() { }
}
