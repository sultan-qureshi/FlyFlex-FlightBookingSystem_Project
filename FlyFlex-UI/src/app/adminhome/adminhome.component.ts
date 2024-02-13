import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {


  data:any;
  constructor(private admin:AdminService,
    private router:Router) { }

  ngOnInit(): void {
    if(this.admin.isAdminLoggedIn()){
      this.admin.getData().subscribe(data=>{
         this.data=data
       })

    }else{  
      this.router.navigate(["/adminlogin"]);
      Swal.fire("Login First")

    }
  }


  deletef(id){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Delete Flight'
    }).then((result) => {
      if (result.isConfirmed) {
        this.admin.deleteData(id).subscribe(data=>{
          Swal.fire({
            icon: 'info',
            title: data,
            showCancelButton: false,
            timer:2000

          }),
          this.router.navigate(["/admin"])});
        }
      })}

  addflight(){
    this.router.navigate(["addflight"])
  }
  gotoupdate(id){
    this.router.navigate(["updateflight/"+id])
  }

}
