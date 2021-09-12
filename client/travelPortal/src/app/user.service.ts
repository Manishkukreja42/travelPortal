import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TicketRequest } from './ticket-request';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user=new User();

  loginUser=new User();

  ticketSuccessful;

  editTicket=new TicketRequest();

  constructor(private http:HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>("http://localhost:8080/user/login",user);
  }
  public registerUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>("http://localhost:8080/user/register",user);
  }
  public forgetUserFromRemote(user:User):Observable<any>{
    return this.http.post<any>("http://localhost:8080/user/forgetPassword",user)
  }
  public getCountries():Observable<any[]>{
    return this.http.get<any>("http://localhost:8080/country/get");
   
  }
  public fetchStates(country:string):Observable<any>{
    return this.http.get<any>("http://localhost:8080/states/get/"+country);
  }

  public fetchTickets(ticket:TicketRequest):Observable<any[]>{
    return this.http.post<any>("http://localhost:8080/user/FindTicket",ticket);
  }

  public fetchCities():Observable<any[]>{
    return this.http.get<any>("http://localhost:8080/user/cities");
   
  }
  public generateTicket(ticket:TicketRequest):Observable<any>{
    return this.http.post<any>("http://localhost:8080/user/generateTicket",ticket);
  }




  // public getPdf(user:User):Observable<Blob> {
  //   return this.http.post<any>("http://localhost:8080/user/pdf",{ responseType:'blob',user})
  // }
  public getPdf(user:User):Observable<any> {
    return this.http.post<any>("http://localhost:8080/user/pdf",user);
  }
}
