import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable()
export class RegisterComp implements OnInit {

  constructor(private http: HttpClient) {}

  onRegisterPost(post){
    this.http.post('http://localhost:3000/',post).subscribe(()=>{
      console.log('success')
    })
  }
  ngOnInit() { }
}
