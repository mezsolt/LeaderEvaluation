import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsForm = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router,private route: ActivatedRoute) {
  }

  login(param: any) {
    let user: HttpParams = new HttpParams();
    user = user.append('username', param.username);
    user = user.append('password', param.password);
    this.http.post('http://localhost:8080/login',user,httpOptionsForm).subscribe();
    this.router.navigateByUrl('/login');
  }

  logOut() {
    this.http.get('http://localhost:8080/logout',httpOptions).subscribe();
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
  }

}
