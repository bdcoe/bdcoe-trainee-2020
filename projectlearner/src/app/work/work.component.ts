import { Component, OnInit } from '@angular/core';
import {ServiceComp} from '../shared/service.service';
import {Router} from '@angular/router'


@Component({
  selector: 'app-work',
  templateUrl: './work.component.html',
  styleUrls: ['./work.component.css']
})
export class WorkComponent implements OnInit {

  constructor(private res:ServiceComp,private router:Router) { }

  ngOnInit(): void {
    if(!this.res.isloggedin()){
      this.router.navigate([''])
  }
}

}
