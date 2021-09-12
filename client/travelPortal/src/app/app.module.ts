import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegistrationAdminComponent } from './registration-admin/registration-admin.component';
import { AdminLoginSuccessComponent } from './admin-login-success/admin-login-success.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserForgetPasswordComponent } from './user-forget-password/user-forget-password.component';
import { UserLoginSuccessComponent } from './user-login-success/user-login-success.component';
import { RegistrationUserComponent } from './registration-user/registration-user.component';
import { UserRegistrationSuccesfullComponent } from './user-registration-succesfull/user-registration-succesfull.component';
import { GenerateTicketComponent } from './generate-ticket/generate-ticket.component';
import {NgxPaginationModule} from 'ngx-pagination'
@NgModule({
  declarations: [
    AppComponent,
    LoginAdminComponent,
    RegistrationAdminComponent,
    AdminLoginSuccessComponent,
    LoginUserComponent,
    UserForgetPasswordComponent,
    UserLoginSuccessComponent,
    RegistrationUserComponent,
    UserRegistrationSuccesfullComponent,
    GenerateTicketComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
