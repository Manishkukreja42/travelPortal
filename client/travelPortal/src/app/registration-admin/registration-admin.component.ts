import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { TravelPortalService } from '../travel-portal.service';

@Component({
  selector: 'app-registration-admin',
  templateUrl: './registration-admin.component.html',
  styleUrls: ['./registration-admin.component.css']
})
export class RegistrationAdminComponent implements OnInit {

  admin=new Admin();
  msg=""
  // newPassword="";
  constructor(private _service:TravelPortalService,private _router:Router) { }

  ngOnInit(): void {
  }
  registerUser(){
    this._service.registerAdmin(this.admin).subscribe(
      data => {
        
        console.log("response recieved");
        this._service.msg="admin registered successfully"
        this._router.navigate([''])
      },
      error => { console.log("exception occured")
        this.msg="email id already exists"
      
    }
    )
  }

}
