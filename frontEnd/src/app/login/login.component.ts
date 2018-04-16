import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from "@angular/common/http";
import {Location} from "@angular/common";
import {ActivatedRoute, Router} from "@angular/router";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsForm = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

const httpOptionsAuth = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic '+btoa("user1:pass1") })
};

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router,private route: ActivatedRoute,private location: Location) {
  }

  login(param: any) {
    let user: HttpParams = new HttpParams();
    //user = user.append('grant_type', 'password');
    user = user.append('username', param.username);
    user = user.append('password', param.password);

    this.http.post('http://localhost:8080/login',user,httpOptionsForm).subscribe();
  }

  oauth() {
    //this.router.navigateByUrl('/workers');
    //window.location.reload();
    let user: HttpParams = new HttpParams();
    user.append('grant_type', 'password');
    user.append('username', 'ferko');
    user.append('password', 'egy');
    //user.append('client_id','user1');

    this.http.post('http://localhost:8080/oauth/token',user,httpOptionsAuth).subscribe();
  }

  ngOnInit() {
  }

}
