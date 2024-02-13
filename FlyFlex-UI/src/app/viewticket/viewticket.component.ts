import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-viewticket',
  templateUrl: './viewticket.component.html',
  styleUrls: ['./viewticket.component.css']
})
export class ViewticketComponent implements OnInit {
  t1data:any
  pt1data:any
  constructor(private ticket:FlightsService,
    private router:Router) { }

  ngOnInit(): void {
    if(this.ticket.isLoggedIn())
   { this.welcome();}
   else{ this.router.navigate(["/login"])}
  
  }
  viewticket(usert){
    let token= JSON.parse(localStorage.getItem('userToken'))
    this.ticket.viewticketbyuser(token,usert).subscribe(tdata=>{
      this.t1data=tdata;
  })
  }
  viewpastticket(usert){
    let token= JSON.parse(localStorage.getItem('userToken'))
    this.ticket.viewpastticketbyuser(token,usert).subscribe(ptdata=>{
      this.pt1data=ptdata;
  })
  }


  welcome(){
    let token= JSON.parse(localStorage.getItem('userToken'))
    let resp = this.ticket.welcomemessage(token);
     resp.subscribe(data=>{
       
     this.viewticket(data),
     this.viewpastticket(data)
    })
  }

  gotocheckin(id,status){
    if(JSON.parse(status)==true){
      Swal.fire({
        icon: 'error',
         title: 'Already Checked In!'
      });
      this.router.navigate(["/viewticket"])
    }else
    this.router.navigate(["/checkin/"+id])
  }

  cancelTicket(tid){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Cancel Ticket'
    }).then((result) => {
      if (result.isConfirmed) {
        let token= JSON.parse(localStorage.getItem('userToken'))
        this.ticket.cancelticket(token,tid).subscribe(data=>{
          Swal.fire(data),
          this.router.navigate(["/viewticket"]);
        });
      }
    })

  }

}
