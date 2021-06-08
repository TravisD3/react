import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Homeland } from '../profile-edit/profile-edit.model';

@Injectable({providedIn: 'root'})
export class ProfileService {
  public API = '//localhost:8080';
  public PROFILES_API = this.API + '/profiles';
  // public PROFILE_EDIT_API = this.API + '/profile-edit/';
  
  private countryUrl = this.API + '/countries';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/cool-profiles');
  }

  public getCountrySymbol(country_symbol): Observable<any> {
    return this.http.get(this.countryUrl + "/countrySymbol/"+ country_symbol);
  }

  get(id: string) : Observable<any> {
    return this.http.get(this.PROFILES_API + '/' + id);
  }

  save(newprofile: any): Observable<any> {
    let result: Observable<Object>;
    console.log("profile1:", newprofile);
    console.log("newprofile.href:", newprofile.href);
    result = this.http.put(newprofile.href, newprofile);
    
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
