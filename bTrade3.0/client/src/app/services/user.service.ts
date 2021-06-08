import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from '../models/userinfo.model';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = 'http://localhost:8080/api/test/user';
  private pmUrl = 'http://localhost:8080/api/test/pm';
  private adminUrl = 'http://localhost:8080/api/test/admin';

  private API = '//localhost:8080';
  private USER_API = this.API + '/user';

  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  // User APIs
  getUsers(): Observable<any> {
    return this.http.get(this.USER_API + '/users');
  }

  getUserByName(username: string): Observable<any> {
    return this.http.post(this.USER_API + '/search-by-name', username);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(this.USER_API + '/search-by-id/' + id);
  }

  updateUser(user: UserInfo): Observable<any> {
    return this.http.put(this.USER_API + '/update/' + user.id, user);
  }

  addUser(user: UserInfo): Observable<any> {
    return this.http.post(this.USER_API + '/add', user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(this.USER_API + '/delete/' + id);
  }
}
