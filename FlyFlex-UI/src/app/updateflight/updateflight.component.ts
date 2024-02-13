import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-updateflight',
  templateUrl: './updateflight.component.html',
  styleUrls: ['./updateflight.component.css']
})
export class UpdateflightComponent implements OnInit {
fid:any;
f1data:any;
  constructor(private admin:AdminService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    if(this.admin.isAdminLoggedIn()){
    this.fid=this.route.snapshot.params;
     this.flightbyid()     }
     else{
       this.router.navigate(["/adminlogin"])
     }
  }
  flightbyid(){
    this.admin.getflightbyid(this.fid.id)
    .subscribe(f1data=>{
    this.f1data=f1data
    })
  }
  postdetails(value:any){
    this.admin.updateflight(value,this.fid.id).subscribe(
      data=>{
        Swal.fire({
          icon:'info',
          title:data})
        this.router.navigate(["/admin"])
      }
    );

  }

}
