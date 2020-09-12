import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceComp } from '../shared/service.service'

@Component({
  selector: 'app-addproblem',
  templateUrl: './addproblem.component.html',
  styleUrls: ['./addproblem.component.css']
})
export class AddproblemComponent implements OnInit {

  addproblem(data: NgForm) {
    this.res.onaddproblem(data.value)
  }
  constructor(private res: ServiceComp) { }

  ngOnInit(): void {
  }

}
