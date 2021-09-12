import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketRequest } from '../ticket-request';
import { TravelPortalService } from '../travel-portal.service';

@Component({
  selector: 'app-admin-login-success',
  templateUrl: './admin-login-success.component.html',
  styleUrls: ['./admin-login-success.component.css']
})
export class AdminLoginSuccessComponent implements OnInit {

  ticketList;

  constructor(private _service: TravelPortalService,private _router:Router) {  }
  adminPerson;
  ngOnInit(): void {
    this.adminPerson=this._service.adminPerson;
    this.getTickets();
   
}
getTickets(){
if(this.adminPerson!=null)
{
this._service.fetchTickets().subscribe(
  data =>{
    this.ticketList=data;
    console.log(this.ticketList);
  },
  error =>console.log(error)
)
}
}

accept(ticket:TicketRequest){
  this._service.acceptTicket(ticket).subscribe(
    data =>{
      console.log(data);
      this.getTickets();
      this._router.navigate(['adminLoginsuccess']);
    }
  )
}
reject(ticket:TicketRequest){
  this._service.rejectTicket(ticket).subscribe(
    data =>{
      console.log(data);
      this.getTickets();
      this._router.navigate(['adminLoginsuccess']);
    }
  )
}

  
  

}
