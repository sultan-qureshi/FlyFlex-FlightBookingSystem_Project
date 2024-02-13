import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import  {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { HomeComponent } from './home/home.component';
import { BookflightComponent } from './bookflight/bookflight.component';
import { ViewflightComponent } from './viewflight/viewflight.component';
import { HeaderComponent } from './header/header.component';
import { ViewticketComponent } from './viewticket/viewticket.component';
import { CheckinComponent } from './checkin/checkin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminheaderComponent } from './adminheader/adminheader.component';
import { AddflightComponent } from './addflight/addflight.component';
import { UpdateflightComponent } from './updateflight/updateflight.component';

@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    UsersignupComponent,
    HomeComponent,
    BookflightComponent,
    ViewflightComponent,
    HeaderComponent,
    ViewticketComponent,
    CheckinComponent,
    AdminhomeComponent,
    AdminloginComponent,
    AdminheaderComponent,
    AddflightComponent,
    UpdateflightComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
