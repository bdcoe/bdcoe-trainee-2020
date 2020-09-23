import { Component, OnInit } from '@angular/core';
import { MatDialogConfig,MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ServiceComp } from '../shared/service.service';
import { TechsupportComponent } from '../techsupport/techsupport.component'

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  
  constructor(private dialog:MatDialog,private router:Router,private res:ServiceComp) {
    if(localStorage.getItem('token')==null){
      this.error='Invalid'
    }
  }
  error:String='';
  work;
  techSup(){
    var dialogConfig=new MatDialogConfig();
    dialogConfig.width='60%';
    dialogConfig.height='auto';
    if(localStorage.getItem('token')){
    this.dialog.open(TechsupportComponent,dialogConfig)
  }else{
    this.res.openSnackBar('Error',"Auth Failed")
  }
  }
  logout(){
    localStorage.removeItem('token');
    this.router.navigate([''])
  }
  ngOnInit(): void {
    this.res.ondashboard().subscribe(ele=>{
      console.log(ele['message'][0]['mywork']);
      this.work = ele['message'][0]['mywork']
      
    },error=>{
      this.router.navigate([''])
      console.log(error['error']['message'])
      this.res.openSnackBar('Error',error)
    })
  }

}
