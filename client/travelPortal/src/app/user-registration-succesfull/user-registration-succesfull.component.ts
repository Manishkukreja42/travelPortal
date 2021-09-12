import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-registration-succesfull',
  templateUrl: './user-registration-succesfull.component.html',
  styleUrls: ['./user-registration-succesfull.component.css']
})
export class UserRegistrationSuccesfullComponent implements OnInit {

  user;
  constructor(private _service:UserService,private _router:Router) { }

  ngOnInit(): void {
    this.user=this._service.user;
  }
  edit(){
    this._router.navigate(['userRegistration']);
  }

  homepage(){
    this._router.navigate(['']);
  }

}
