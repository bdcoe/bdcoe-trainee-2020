import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { HttpClientModule } from '@angular/common/http';
import { loginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { SolutionComponent } from './solution/solution.component';
import { WorkComponent } from './work/work.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { ProblemsComponent } from './problems/problems.component';
import { TechsupportComponent } from './techsupport/techsupport.component';
import { AllproblemsComponent } from './allproblems/allproblems.component';
import { MatDialogModule } from '@angular/material/dialog';
import { ProfileEditDialogComponent } from './profile-edit-dialog/profile-edit-dialog.component';
import { AddproblemComponent } from './addproblem/addproblem.component';
import { AddsolutionComponent } from './addsolution/addsolution.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatToolbarModule } from '@angular/material/toolbar'
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    loginComponent,
    DashboardComponent,
    ProfileComponent,
    SolutionComponent,
    WorkComponent,
    LeaderboardComponent,
    ProblemsComponent,
    TechsupportComponent,
    AllproblemsComponent,
    ProfileEditDialogComponent,
    AddproblemComponent,
    AddsolutionComponent,
    ConfirmationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCheckboxModule,
    HttpClientModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatProgressSpinnerModule,
    MatToolbarModule
  ], entryComponents: [ProfileEditDialogComponent, AddproblemComponent, AddsolutionComponent, ConfirmationComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
