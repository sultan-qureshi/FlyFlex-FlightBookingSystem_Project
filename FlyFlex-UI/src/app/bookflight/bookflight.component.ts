import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-bookflight',
  templateUrl: './bookflight.component.html',
  styleUrls: ['./bookflight.component.css']
})
export class BookflightComponent implements OnInit {
pid:any
message:any
f1data:any
luser:any
  constructor(private route: ActivatedRoute,
    private book:FlightsService,
    private router:Router) { } 

  ngOnInit(): void {
    if (this.book.isLoggedIn()){
    this.pid=this.route.snapshot.params
    this.flightbyid()
    this.welcome()}
    else{ Swal.fire("Need to Login First!")
  this.router.navigate(["/login"]) }

  }

  postdetails(value: any){
    Swal.fire({
      title: 'Are you sure?',
      text: "You want to Book  the ticket",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Book Now!'
    }).then((result) => {
      if (result.isConfirmed) {
        value.bookedBy=this.luser
        let token= JSON.parse(localStorage.getItem('userToken'))
        let resp=this.book.bookflight(this.pid.fid,token,value)
        resp.subscribe(data=>{
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: data,
            showConfirmButton: false,
            timer: 2500
          }),
          this.router.navigate(["/viewticket"])
        })
      }
    })
 
      
  }
  flightbyid(){
    this.book.getflightbyid(this.pid.fid)
    .subscribe(f1data=>{
    this.f1data=f1data
    })
  }

  
  welcome(){
    let token= JSON.parse(localStorage.getItem('userToken'))
    let resp = this.book.welcomemessage(token);
     resp.subscribe(data=>this.luser=data);
    }

}
