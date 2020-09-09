import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({ providedIn: 'root' })
export class LoginComp implements OnInit {

  constructor(private http:HttpClient){}
  login() {

  }

  ngOnInit() {

  }
}
