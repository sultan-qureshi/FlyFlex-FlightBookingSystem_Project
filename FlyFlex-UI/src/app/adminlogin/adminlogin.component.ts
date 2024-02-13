import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router, RouteReuseStrategy } from '@angular/router';
import { timer } from 'rxjs';
import Swal from 'sweetalert2';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  constructor(private admin:AdminService,
    private router:Router) { }

  ngOnInit(): void {
    if(this.admin.isAdminLoggedIn()){
      Swal.fire({
        icon:'success',
        text:'Already Loged in',
        showConfirmButton: false,
        timer: 2000,
      })
      this.router.navigate(["/admin"])
    }
  }

  postdetails(value: any){
    let resp = this.admin.adminlogin(value)
    resp.subscribe(udata=>{    
     localStorage.setItem('adminToken', JSON.stringify(udata)), 
     Swal.fire({
       icon:'success',
       title: 'Login Success',
       showConfirmButton: false,
        timer: 2000,
     })
    this.router.navigate(["/admin"])});
   }
}
