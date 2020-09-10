import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({ providedIn: 'root' })
export class LoginComp implements OnInit {

  constructor(private http:HttpClient){}
  onlogin(post) {
    const headers = new HttpHeaders({'Content-Type':'application/json'})
    this.http.post('http://localhost:3000/',post)
    .subscribe((response)=>{
      console.log(response)
    })
  }

  ngOnInit() {  }
}
