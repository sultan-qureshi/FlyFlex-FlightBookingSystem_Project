import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  response:any ="Login"
  constructor(private lusers:FlightsService,
    private router:Router) { }

  ngOnInit(): void {
    this.welcome()
  }
  welcome(){
    let token= JSON.parse(localStorage.getItem('userToken'))
    let resp = this.lusers.welcomemessage(token);
     resp.subscribe(data=>this.response=data);
    }
    logout(){
      if(this.lusers.isLoggedIn()){
        Swal.fire({
          title: 'Are you sure?',
          text: "You won't be able Access All Features",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, Logout!'
        }).then((result) => {
          if (result.isConfirmed) {
            localStorage.removeItem('userToken')
          this.router.navigate(["/home"])
            Swal.fire(
              'Logged Out!',
              'success'
            )
          }
        })

      }else Swal.fire("Not Loged in yet!"); 
    }

}
