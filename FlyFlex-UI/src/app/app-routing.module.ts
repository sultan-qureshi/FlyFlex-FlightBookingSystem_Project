import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddflightComponent } from './addflight/addflight.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { BookflightComponent } from './bookflight/bookflight.component';
import { CheckinComponent } from './checkin/checkin.component';
import { HomeComponent } from './home/home.component';
import { UpdateflightComponent } from './updateflight/updateflight.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { ViewflightComponent } from './viewflight/viewflight.component';
import { ViewticketComponent } from './viewticket/viewticket.component';

const routes: Routes = [
  {path:"",redirectTo:"home",pathMatch:"full"},
  {path:"home",component:HomeComponent},
  {path:"login",component:UserloginComponent},
  {path:"signup",component:UsersignupComponent},
  {path:"bookflight/:fid",component:BookflightComponent},
  {path:"viewflight/:fid",component:ViewflightComponent},
  {path:"viewticket",component:ViewticketComponent},
  {path:"checkin/:id",component:CheckinComponent},
  {path:"admin",component:AdminhomeComponent},
  {path:"adminlogin",component:AdminloginComponent},
  {path:"addflight",component:AddflightComponent},
  {path:"updateflight/:id",component:UpdateflightComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

