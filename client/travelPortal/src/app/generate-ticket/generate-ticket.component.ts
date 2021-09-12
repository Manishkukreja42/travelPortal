import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketRequest } from '../ticket-request';
import { UserService } from '../user.service';

@Component({
  selector: 'app-generate-ticket',
  templateUrl: './generate-ticket.component.html',
  styleUrls: ['./generate-ticket.component.css']
})
export class GenerateTicketComponent implements OnInit {

  ticket=new TicketRequest();
  upperbounds;
  constructor(private _service:UserService,private _router:Router) { }

  cities=[];

  ngOnInit(): void {
    this.ticket=this._service.editTicket;

    this._service.fetchCities().subscribe(
      data =>{
        this.cities=data; 
        console.log(this.cities);
        // this._router.navigate(['userLoginsuccess'])
        
      } ,
      error => console.log("exception occured")
      

    );
  }

  registerTicket(){
    
    this.ticket.emailId=this._service.loginUser.email;
    this.ticket.ticketState="Submitted";
    if(!this.ticket.emailId)
    {
      console.log("Hii");
    }
    else
    {
    console.log(this.ticket.emailId);
    console.log(this.ticket.priority+" "+this.ticket.request+" "+this.ticket.startDate+this.ticket.expenseBorne );
    this._service.generateTicket(this.ticket).subscribe(
      data =>{ console.log(data)
        this._router.navigate(['userLoginsuccess'])
      },
      error =>console.log(error)
    )
  }

  }

}
