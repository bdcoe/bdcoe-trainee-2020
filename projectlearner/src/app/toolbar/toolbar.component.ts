import { Component, OnInit } from '@angular/core';
import { MatDialogConfig,MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TechsupportComponent } from '../techsupport/techsupport.component'

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private dialog:MatDialog,private router:Router) {
  }
  techSup(){
    var dialogConfig=new MatDialogConfig();
    dialogConfig.width='60%';
    dialogConfig.height='auto';
    this.dialog.open(TechsupportComponent,dialogConfig)
  }
  logout(){
    localStorage.removeItem('token');
    this.router.navigate([''])

  }

  ngOnInit(): void {
  }

}
