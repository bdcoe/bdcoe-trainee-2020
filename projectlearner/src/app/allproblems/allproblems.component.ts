import { Component, OnInit, ɵINJECTOR_IMPL__POST_R3__ } from '@angular/core';
import { ServiceComp } from '../shared/service.service'
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsolutionComponent } from '../addsolution/addsolution.component';

@Component({
  selector: 'app-allproblems',
  templateUrl: './allproblems.component.html',
  styleUrls: ['./allproblems.component.css']
})
export class AllproblemsComponent implements OnInit {

  constructor(private res: ServiceComp, private router: Router, private dialog: MatDialog) {

  }
  addsolution(post) {
    const dialogConfig = new MatDialogConfig();
    console.log(post)
    dialogConfig.data = { post: post };
    dialogConfig.width = '700px';
    dialogConfig.height = '550px'
    const addsol = this.dialog.open(AddsolutionComponent, dialogConfig)
    addsol.afterClosed().subscribe(elem => {
      this.spinner = true
      this.res.fetchallProblem().subscribe(ele => {
        this.spinner = false
        this.AllProblems = ele['message']
      })
    })
  }
  dislike: boolean = false;
  like: boolean = false;
  toggle(id) {
    console.log(id)
    this.like = !this.like;
    if (this.like && this.dislike) {
      this.dislike = !this.dislike
    }
    this.res.onliketoggle({ like: this.like, dislike: this.dislike, id: id }).subscribe(ele => {
      console.log(ele)
    })
  }
  togglered(id) {
    console.log(id)
    this.dislike = !this.dislike;
    if (this.dislike && this.like) {
      this.like = !this.like
    }
    this.res.onliketoggle({ like: this.like, dislike: this.dislike, id: id }).subscribe(ele => {
      console.log(ele)
    })
  }
  AllProblems: []
  spinner: boolean = false;

  ngOnInit(): void {
    if (!this.res.isloggedin()) {
      this.router.navigate([''])
    }
    this.spinner = true;
    this.res.fetchallProblem().subscribe(ele => {
      this.spinner = false
      console.log(ele)
      this.AllProblems = ele['message']
      for( let user of ele['message']){
          console.log(user['solution'])
      }  
    }, error => {
      this.router.navigate([''])
      this.res.openSnackBar('Error', error['error']['message'])
    })
  }
}

