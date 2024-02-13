import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  constructor(private lusers:FlightsService,
    private router:Router) { } 

  ngOnInit(): void {
  }
  postdetails(value: any){
    let resp = this.lusers.userlogin(value)
    resp.subscribe(udata=>{    
     localStorage.setItem('userToken', JSON.stringify(udata)), 
     Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Login Success',
      showConfirmButton: false,
      timer: 1500}),
    this.router.navigate(["/home"])});    
   }
   gotoadmin(){
     this.router.navigate(["/adminlogin"])
   }
}
