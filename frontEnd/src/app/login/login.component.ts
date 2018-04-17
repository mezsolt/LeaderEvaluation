import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Location} from "@angular/common";
import { Router} from "@angular/router";
import {Cookie} from "ng2-cookies";


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

  dataMsg: any;

  constructor(private http:HttpClient,private router:Router,private location: Location) {
  }

  login(param: any) {
    this.http.post('http://localhost:8080/oauth/token?grant_type=password&username='+param.username+'&password='+param.password,null,
      httpOptionsAuth).subscribe(data => this.saveToken(data));
  }

  saveToken(token){
    var expireDate = new Date().getTime() + (1000 * token.expires_in);
    this.dataMsg = token.access_token;
    window.localStorage.setItem("access_token",token.access_token);
    Cookie.set("access_token", token.access_token, expireDate,"/");
  }

  workers() {
    this.router.navigateByUrl('/workers?access_token='+window.localStorage.getItem('access_token'));
  }

  ngOnInit() {
  }

}
