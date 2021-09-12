import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-forget-password',
  templateUrl: './user-forget-password.component.html',
  styleUrls: ['./user-forget-password.component.css']
})
export class UserForgetPasswordComponent implements OnInit {

  user=new User();
  msg;
  constructor(private _service:UserService,private _router:Router) { }

  ngOnInit(): void {
  }
  forgetPassword(){
    this._service.forgetUserFromRemote(this.user).subscribe(
      data => {
        console.log(data);
        this._router.navigate(['']);
      },
      error => {
        this.msg="E-mail id doesnt exist";
        console.log("exception occured")
    }
      

    )
  }

}
