import { Component, OnInit } from '@angular/core';
import { Worker } from './worker.model';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {WorkerService} from "./worker.service";

@Component({
  selector: 'app-worker',
  templateUrl: './worker.component.html',
  styleUrls: ['./worker.component.css']
})

export class WorkerComponent implements OnInit {

  title: string = 'LeaderEvaluation';

  workers: Worker[];

  worker1: Worker = {
    id:100,
    username:'ferko',
    password:'egy',
    section:'section1',
    leaders:["egy","egy"],
    roles:['USER']

  };
  worker2: Worker = {
    id:50,
    username:'marko',
    password:'ketto',
    section:'section2',
    leaders:["ketto","ketto"],
    roles:['ADMIN']
  };

  constructor(private http: HttpClient,private workerService: WorkerService) { }

  addWorker1(){
    this.workerService.addWorker1(this.worker1);
  }

  addWorker2(){
    this.workerService.addWorker2(this.worker2);
  }

  getWorkers() {
    this.workerService.getWorkers().subscribe(data => this.workers = data);
  }

  ngOnInit() {
  }

}
