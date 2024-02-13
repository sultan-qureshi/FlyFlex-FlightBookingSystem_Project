import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-usersignup',
  templateUrl: './usersignup.component.html',
  styleUrls: ['./usersignup.component.css']
})
export class UsersignupComponent implements OnInit {
 

  constructor(private users:FlightsService,
    private router:Router) { }

  ngOnInit(): void {
  }
  postdetails(value: any){

   this.users.usersignup(value.username,value).subscribe(udata=>{
    Swal.fire({
      icon:'info',
      title:udata
    })
   })
  }

}
