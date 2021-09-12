import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-user',
  templateUrl: './registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {

  countries=[];

  states=[];
  user=new User();
  constructor(private _service:UserService,private _router:Router) { }

  ngOnInit(): void {
   this.getCountries(); 
   this.user=this._service.user;
  }

  getCountries(){
    this._service.getCountries().subscribe(
      data =>{
        this.countries=data; 
        console.log(this.countries);
        // this._router.navigate(['userLoginsuccess'])
        
      } ,
      error => console.log("exception occured")
      

    );
  }
  msg="";
  // getPdf(){
  //   this._service.getPdf(this.user).subscribe(data => console.log("data recieved"),
  //   error => console.log("execption occured"));
  // }
  // getPdf(){
  //   this._service.getPdf(this.user).subscribe(x => {
  //     const blob=new Blob([x],{type:'application/pdf'})
  //     if(window.navigator && window.navigator.msSaveOrOpenBlob){
  //       window.navigator.msSaveOrOpenBlob(blob);
  //       return;
  //     }
  //     const data=window.URL.createObjectURL(blob);
  //     const link=document.createElement('a');
  //     link.href=data;
  //     link.download='user.pdf';
  //     link.dispatchEvent(new MouseEvent('click',{bubbles:true,cancelable:true,view:window}));

  //     setTimeout(function() {
  //       window.URL.revokeObjectURL(data);
  //       link.remove();
  //     },100);
  //   }

  //   )
  // }
  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data =>{
        console.log("data recieved");
        this._service.user=this.user;
        // this.countries=data; 
        // console.log(dat);
        // this.states=data;
        // console.log(this.states);
        // this.
        this._router.navigate(['userRegistrationSuccess']);
        
      } ,
      error => {console.log("exception occured")
      this.msg="User with email id already exists";
    }
    );    
    
  }

  onChangeCountry(country:string){
    this._service.fetchStates(this.user.country).subscribe(
      data =>{
        // this.countries=data; 
        // console.log(dat);
        this.states=data;
        console.log(this.states);
        // this._router.navigate(['userLoginsuccess'])
        
      } ,
      error => console.log("exception occured")
      

    );    
  }




}
