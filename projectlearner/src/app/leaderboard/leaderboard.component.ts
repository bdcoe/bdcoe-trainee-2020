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

  constructor(private res: ServiceComp, private router: Router) { }

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate(['']);
    }
    console.log('ngonitleadercomponent')
    this.res.fetchleaderboard().subscribe(ele => {
      this.leaders = ele['message'];
      console.log(ele['message']);
    })
  }
}
