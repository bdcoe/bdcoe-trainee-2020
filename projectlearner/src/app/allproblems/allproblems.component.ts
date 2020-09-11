import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-allproblems',
  templateUrl: './allproblems.component.html',
  styleUrls: ['./allproblems.component.css']
})
export class AllproblemsComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router) { }

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
  }
}

