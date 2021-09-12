import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';
import {HttpClient} from '@angular/common/http'
import { TicketRequest } from './ticket-request';

@Injectable({
  providedIn: 'root'
})
export class TravelPortalService {

  constructor(private http:HttpClient) { }

  adminPerson;
  msg;


  public loginAdminFromRemote(admin: Admin):Observable<any>{
    this.adminPerson=admin.email;
    return this.http.post<any>("http://localhost:8080/admin/login",admin)

  }

  public registerAdmin(admin:Admin):Observable<any>{
    return this.http.post<any>("http://localhost:8080/admin/register",admin)
  }

  public fetchStates(country:string):Observable<any>{
    return this.http.get<any>("http://localhost:8080/states/get/"+country);
  }

  public fetchTickets():Observable<any[]>{
    return this.http.get<any>("http://localhost:8080/user/FindTicketByPriority");
  }

  public acceptTicket(ticket:TicketRequest):Observable<any>{
    return  this.http.post<any>("http://localhost:8080/user/ticketAccepted",ticket);
  }
  public rejectTicket(ticket:TicketRequest):Observable<any>{
    return  this.http.post<any>("http://localhost:8080/user/ticketRejected",ticket);
  }
}
