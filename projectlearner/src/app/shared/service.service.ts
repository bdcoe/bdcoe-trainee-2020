import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User, TechSuppModel } from './Service.model'

@Injectable({ providedIn: 'root' })
export class ServiceComp implements OnInit {

  constructor(private http: HttpClient) { }
  onlogin(post) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' })
    this.http.post('http://localhost:3000/', post)
      .subscribe((response) => {
        console.log(response)
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
    this.http.post('http://localhost:3000/techsupport/', post).subscribe(() => {
      console.log('edited')
    })
  }


  ngOnInit() { }
}
