import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  adminurl="http://localhost:9003/admin/";
  constructor(private http:HttpClient) { }

  adminlogin(value){
    let url=this.adminurl+"authenticate";
    return this.http.post(url,value,{responseType:'text' as 'json'});
  }

  getData(){
    let token= JSON.parse(localStorage.getItem('adminToken'));
    let tokenstr="token="+token;
    let url=this.adminurl+"findallflights";
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.get(url,{headers,responseType:'json' as 'json'});
  }
  deleteData(id){
    let token= JSON.parse(localStorage.getItem('adminToken'));
    let tokenstr="token="+token;
    let url=this.adminurl+"deleteFlight/"+id;
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.delete(url,{headers,responseType:'text' as 'json'});
  }

  addflight(flight:any){
    let token= JSON.parse(localStorage.getItem('adminToken'));
    let tokenstr="token="+token;
    let url=this.adminurl+"addFlight/";
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.post(url,flight,{headers,responseType:'text' as 'json'});
  }
  getflightbyid(id){
    let token= JSON.parse(localStorage.getItem('adminToken'));
    let tokenstr="token="+token;
    let url=this.adminurl+"findflightbyid/"+id;
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.get(url,{headers,responseType:'json' as 'json'});
  }

  updateflight(flight:any,id){
    let token= JSON.parse(localStorage.getItem('adminToken'));
    let tokenstr="token="+token;
    let url=this.adminurl+"editFlight/"+id;
    const headers=new HttpHeaders().set("Authorization",tokenstr)
    return this.http.put(url,flight,{headers,responseType:'text' as 'json'});
  }

  isAdminLoggedIn(){
    let token= localStorage.getItem("adminToken");
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else{ return true; }
    }



}


