import { Component, OnInit } from '@angular/core';
import { FlightsService } from '../flights.service';
import{Router} from '@angular/router'
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data:any
  fid:any
  response:any ="Login "

  constructor(private flight:FlightsService,
    private router:Router) { }

  ngOnInit(): void {
    this.welcome()
       this.flight.getData().subscribe(data=>{
     // console.log(data)
      this.data=data
    })
  }
  getdetails(value: any)
  {
    Swal.fire({
      title: 'Loading!',
      timer: 1000,
      didOpen: () => {
        Swal.showLoading()}
        });

    this.flight.getflightdetails(value.origin,value.destination,value.departureDate)
    .subscribe(data=>{
      this.data=data
    })
  }
  getdetailsbyid(id)
  {
      this.fid=id
      this.router.navigate(["/viewflight/" +this.fid])

  }
  welcome(){
    let token= JSON.parse(localStorage.getItem('userToken'))
    let resp = this.flight.welcomemessage(token);
     resp.subscribe(data=>this.response=data);
    }

}
