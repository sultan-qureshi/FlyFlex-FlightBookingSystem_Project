import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {
tid:any
seatno:any
  constructor(private ticket:FlightsService,
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    if (this.ticket.isLoggedIn()){
      this.tid=this.route.snapshot.params;
    }
      else{ Swal.fire("Need to Login First!")
    this.router.navigate(["/login"]) }
  }

  checkin(value: any){
    this.seatno=value.seatNo
    let token= JSON.parse(localStorage.getItem('userToken'))
    let resp=this.ticket.checkin(token,this.tid.id,this.seatno)
    resp.subscribe(data=>{
      Swal.fire(data),
      this.router.navigate(["/viewticket"])
    })

  }

}
