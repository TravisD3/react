import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Homeland } from '../profile-edit/profile-edit.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class NewProfileService {
  public API = '//localhost:8080';
  public PROFILE_API = this.API;
  private countryUrl = this.API;

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/cool-profiles');
  }

  get(id: string) : Observable<any> {
    return this.http.get(this.PROFILE_API + '/' + id);
  }

  
  public getCountrySymbol(country_symbol): Observable<any> {
    return this.http.get(this.countryUrl + "/countrySymbol/"+ country_symbol);
  }

  save(newprofile: any): Observable<any> {
    let result: Observable<Object>;
    if (newprofile['href']) {
      result = this.http.put(newprofile.href, newprofile);
    } else {
      result = this.http.post(this.PROFILE_API, newprofile);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
