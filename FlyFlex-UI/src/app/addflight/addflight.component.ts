import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent implements OnInit {

  constructor(private admin:AdminService,
    private router:Router) { }

  ngOnInit(): void {
    if(this.admin.isAdminLoggedIn()==false){
      this.router.navigate(["/admin"])

    }
  }

  postdetails(value:any){
    Swal.fire({
      title: 'Are you sure?',
      text: "You Want to Add this Flight",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Add Flight!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.admin.addflight(value).subscribe(data=>
          Swal.fire(data))
          this.router.navigate(["/admin"])}
        })
  }


}
