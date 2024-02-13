import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-adminheader',
  templateUrl: './adminheader.component.html',
  styleUrls: ['./adminheader.component.css']
})
export class AdminheaderComponent implements OnInit {

  constructor(private admin:AdminService,
    private router:Router) { }
message:any
  ngOnInit(): void {
    if(this.admin.isAdminLoggedIn()){
      this.message="Admin Mode"
    }else{
      this.message="Login"
    }
  }


  logout(){
    if(this.admin.isAdminLoggedIn()){Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to do Admin Commands",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Logout!'
    }).then((result) => {
      if (result.isConfirmed) {
        localStorage.removeItem('adminToken')
      this.router.navigate(["/adminlogin"])
        Swal.fire(
          'Logged Out!'
        )
      }
    })
    }else Swal.fire("Not Loged in yet!"); 
  }

}
