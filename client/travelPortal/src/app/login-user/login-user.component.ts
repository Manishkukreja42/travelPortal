import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  user=new User();

  constructor(private _service:UserService,private _router:Router) { }

  ngOnInit(): void {
  }
  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe(
      data =>{ console.log(data);
        this._service.loginUser=data;
        this._router.navigate(['userLoginsuccess'])
        
      } ,
      error => console.log("exception occured")
      

    )
  }
  

}
