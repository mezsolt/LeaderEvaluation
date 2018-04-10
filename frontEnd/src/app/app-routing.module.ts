import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {WorkerComponent} from "./worker/worker.component";

const routes: Routes = [
  { path: 'login', redirectTo: '/login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent },
  { path: 'workers', redirectTo: '/workers', pathMatch: 'full' },
  {path:'workers',component: WorkerComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
