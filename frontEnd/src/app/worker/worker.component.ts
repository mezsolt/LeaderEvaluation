import { Component, OnInit } from '@angular/core';
import { Worker } from './worker.model';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {catchError} from "rxjs/operators";
import {pipe} from "rxjs/Rx";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Component({
  selector: 'app-worker',
  templateUrl: './worker.component.html',
  styleUrls: ['./worker.component.css']
})

export class WorkerComponent implements OnInit {

  workers: Worker[];

  worker1: Worker = {
    id:100,
    name:'ferko',
    section:'section1'
  };
  worker2: Worker = {
    id:50,
    name:'marko',
    section:'section2'
  };

  constructor(private http: HttpClient) { }

  addWorker1(){
    this.http.post<Worker>('http://localhost:8080/worker/add',this.worker1,httpOptions).subscribe();
  }

  addWorker2(){
    this.http.post<Worker>('http://localhost:8080/worker/add',this.worker2,httpOptions).subscribe();
  }

  getWorkers() {
    this.http.get<Worker[]>("http://localhost:8080/worker/list").subscribe(data => this.workers = data);
  }

  ngOnInit() {
  }

}
