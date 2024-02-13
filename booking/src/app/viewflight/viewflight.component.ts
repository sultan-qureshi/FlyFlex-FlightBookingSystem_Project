import { Component, OnInit ,Input} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightsService } from '../flights.service';

@Component({
  selector: 'app-viewflight',
  templateUrl: './viewflight.component.html',
  styleUrls: ['./viewflight.component.css']
})
export class ViewflightComponent implements OnInit {
  f1data:any
  pid:any
  fdata:any
  constructor(private flight:FlightsService,
    private route: ActivatedRoute,
    private router:Router) { }


  ngOnInit(): void {
    this.pid=this.route.snapshot.params
    this.flight.getflightbyid(this.pid.fid)
    .subscribe(f1data=>{
    this.f1data=f1data
    }) 
  }
  gotobooking(){
    this.router.navigate(["/bookflight/"+ this.pid.fid])

  }
}
