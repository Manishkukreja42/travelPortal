import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms"
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { TravelPortalService } from '../travel-portal.service';
@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  admin=new Admin();
  msg="";

  constructor(private _service:TravelPortalService,private _router:Router) { }

  ngOnInit(): void {
    this.msg=this._service.msg;
  }
  loginAdmin(){
    this._service.loginAdminFromRemote(this.admin).subscribe(
      data => {
        console.log("response recieved");
        this._router.navigate(['adminLoginsuccess'])
      },
      error => { console.log("exception occured")
      this.msg="Bad credentials,please enter valid emailid and password";
    }
    )
  }
  gotoRegistration(){
    console.log("hi hello");
    this._router.navigate(['adminRegistration'])
  }

}
