import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketRequest } from '../ticket-request';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login-success',
  templateUrl: './user-login-success.component.html',
  styleUrls: ['./user-login-success.component.css']
})
export class UserLoginSuccessComponent implements OnInit {

  constructor(private _service:UserService,private _router:Router) { }
  user=this._service.loginUser;
  ticket=new TicketRequest();
  page:Number=1;
  totalRec=15;
  ticketList;
  msg;
  
  data:Array<any>

  ngOnInit(): void {
    this.ticket.emailId=this.user.email;
    console.log(this.ticket.emailId)
    this.msg=this._service.ticketSuccessful;
    // this.ticket.priority="Normal";
    this._service.fetchTickets(this.ticket).subscribe(
      (data) =>{
        // this.countries=data; 
        this.ticketList=data;
        this.data=data;
        this.totalRec=this.data.length;
        console.log(this.totalRec);
        console.log(this.ticketList);
        // this._router.navigate(['userLoginsuccess'])
        
      } ,
      error => console.log("exception occured")
      

    );
  }
  edit(ticket:TicketRequest)
  {
    console.log(ticket);
    this._service.editTicket=ticket;
    console.log(this._service.editTicket);
    this._router.navigate(['generateTicket'])

  }
  registerTicket(){
    this._router.navigate(['generateTicket'])
  }

}
