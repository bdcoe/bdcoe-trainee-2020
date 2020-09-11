import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component'
import { loginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AllproblemsComponent } from './allproblems/allproblems.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { ProblemsComponent } from './problems/problems.component';
import { ProfileComponent } from './profile/profile.component';
import { SolutionComponent } from './solution/solution.component';
import { TechsupportComponent } from './techsupport/techsupport.component';
import { WorkComponent } from './work/work.component';
const routes: Routes = [
  { path: '', component: loginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'allproblems', component: AllproblemsComponent },
  { path: 'leaderboard', component: LeaderboardComponent },
  { path: 'problems', component: ProblemsComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'solution', component: SolutionComponent },
  { path: 'techsupport', component: TechsupportComponent },
  { path: 'work', component: WorkComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
