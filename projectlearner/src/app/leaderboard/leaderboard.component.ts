import { Component, OnInit } from '@angular/core';
import { ServiceComp } from '../shared/service.service';
import { Router } from '@angular/router';
import { MatExpansionModule } from '@angular/material/expansion'



@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  leaders;
  panelOpenState:boolean;
  spinner:boolean=false

  constructor(private res: ServiceComp, private router: Router) { }

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate(['']);
    }
    this.spinner=true
    this.res.fetchleaderboard().subscribe(ele => {
      this.spinner=false
      this.leaders = ele['message'];
    },error=>{
      this.router.navigate([''])
    })
  }
}
