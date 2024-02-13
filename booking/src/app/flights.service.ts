import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class FlightsService {


  constructor(private http:HttpClient) { }
  getData(){
    let url=this.mainurl+"findallflights";
    return this.http.get(url);
  }
  getflightdetails(origin,destination,departureDate){
    let url=this.mainurl+"find/"
    +origin+"/"+destination+"/"+departureDate;
    return this.http.get(url);
  }
  getflightbyid(id){
    let url=this.mainurl+"findallflightbyid/"+id;
    return this.http.get(url);
  }
  usersignup(username,user){
   
    let url=this.userurl+"signup/"+username;
    return this.http.post(url,user,{responseType:'text' as 'json'});    
  }
  userlogin(luser){
    let url=this.userurl+"authenticate";
    return this.http.post(url,luser,{responseType:'text' as 'json'});
  }
  welcomemessage(token){
   let url="http://localhost:9002/user/"; 
    let tokenstr='token='+token
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.get(url,{headers,responseType:'text' as 'json'});
  }
  bookflight(flightid,token,ticket){
      let url=this.userurl+"bookflight/"+flightid;
      let tokenstr='token='+token
      const headers=new HttpHeaders().set("Authorization",tokenstr)
      return this.http.post(url,ticket,{headers,responseType:'text' as 'json'});
  }
  viewticketbyuser(token,bookedby){
    let url=this.userurl+"allTickets/"+bookedby;
    let tokenstr='token='+token
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.get(url,{headers,responseType:'json' as 'json'});
  }
  isLoggedIn(){
    let token= localStorage.getItem("userToken");
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else{ return true; }
    }

    checkin(token,ticId,seatno){
      let url=this.userurl+"checkin/"+ticId+"/"+seatno;
      let tokenstr='token='+token
      const headers=new HttpHeaders().set("Authorization",tokenstr)
      return this.http.get(url,{headers,responseType:'text' as 'json'});
    }
    mainurl="http://localhost:8081/flights/";
    userurl="http://localhost:9002/user/";

    viewpastticketbyuser(token,bookedby){
      let url=this.userurl+"allPastTickets/"+bookedby;
      let tokenstr='token='+token
      const headers=new HttpHeaders().set("Authorization",tokenstr)
      return this.http.get(url,{headers,responseType:'json' as 'json'});
    }
    cancelticket(token,tid){
      let url=this.userurl+"cancelTicket/"+tid;
      let tokenstr='token='+token
      const headers=new HttpHeaders().set("Authorization",tokenstr)
      return this.http.delete(url,{headers,responseType:'text' as 'json'});
    }
}