import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'


@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router) { }

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
  }

}
