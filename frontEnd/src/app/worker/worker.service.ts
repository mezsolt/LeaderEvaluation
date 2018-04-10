import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Worker } from './worker.model';
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class WorkerService {

  constructor(private http: HttpClient) {}

  addWorker1(worker: Worker){
    this.http.post<Worker>('http://localhost:8080/worker/add',worker,httpOptions).subscribe();
  }

  addWorker2(worker: Worker){
    this.http.post<Worker>('http://localhost:8080/worker/add',worker,httpOptions).subscribe();
  }

  getWorkers(): Observable<Worker[]> {
    return this.http.get<Worker[]>("http://localhost:8080/worker/list");
  }

}
