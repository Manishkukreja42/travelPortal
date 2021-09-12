import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginSuccessComponent } from './admin-login-success/admin-login-success.component';
import { GenerateTicketComponent } from './generate-ticket/generate-ticket.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { RegistrationAdminComponent } from './registration-admin/registration-admin.component';
import { RegistrationUserComponent } from './registration-user/registration-user.component';
import { TicketRequest } from './ticket-request';
import { UserForgetPasswordComponent } from './user-forget-password/user-forget-password.component';
import { UserLoginSuccessComponent } from './user-login-success/user-login-success.component';
import { UserRegistrationSuccesfullComponent } from './user-registration-succesfull/user-registration-succesfull.component';

const routes: Routes = [
  {path:'generateTicket',component:GenerateTicketComponent},
  {path:'',component:LoginUserComponent},
  {path:'forgetPassword',component:UserForgetPasswordComponent},
  {path:'adminLoginsuccess',component:AdminLoginSuccessComponent},
  {path:"userLoginsuccess",component:UserLoginSuccessComponent},
  {path:'adminRegistration',component:RegistrationAdminComponent},
  {path:'userRegistrationSuccess',component:UserRegistrationSuccesfullComponent},
  {path:'adminLogin',component:LoginAdminComponent},
  {path:'userRegistration',component:RegistrationUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
