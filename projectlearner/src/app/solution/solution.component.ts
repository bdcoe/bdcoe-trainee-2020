import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router'


@Component({
  selector: 'app-solution',
  templateUrl: './solution.component.html',
  styleUrls: ['./solution.component.css']
})
export class SolutionComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router) { }

  QA;
  spinner: boolean = false

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true
    this.res.fetchSolution().subscribe(element => {
      this.spinner = false
      this.QA = element['message'];
      console.log(this.QA)
    }, error => {
      this.router.navigate([''])
    })
  }
}
