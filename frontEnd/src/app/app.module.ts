import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';

import {HttpClientModule} from "@angular/common/http";
import { WorkerComponent } from './worker/worker.component';
import {WorkerService} from "./worker/worker.service";
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    WorkerComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
  ],
  providers: [WorkerService],
  bootstrap: [AppComponent]
})
export class AppModule { }

