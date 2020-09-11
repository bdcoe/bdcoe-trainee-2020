import { Component, OnInit } from '@angular/core';
import {ServiceComp} from '../shared/service.service';
import {Router} from '@angular/router'


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private res:ServiceComp,private router:Router) { 
    console.log(res.profileFetch())
  }

  ngOnInit(): void {
    if(!this.res.isloggedin()){
      this.router.navigate([''])
  }
}

}
