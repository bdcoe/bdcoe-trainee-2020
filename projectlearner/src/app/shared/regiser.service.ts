import { Injectable, OnInit } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http'

@Injectable({providedIn:'root'})
export class RegisterComp implements OnInit {

  constructor(private http: HttpClient) {}

  onRegisterPost(post){
    const headers=new HttpHeaders({'Content-Type':'application/json'})
    this.http.post('http://localhost:3000/register',post,{headers:headers}).subscribe(()=>{
      console.log('success')
    })
  }
  ngOnInit() { }
}
