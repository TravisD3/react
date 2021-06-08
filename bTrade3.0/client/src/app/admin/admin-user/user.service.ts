import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user.model';

@Injectable({providedIn: 'root'})
export class UserService {
  private API = '//localhost:8080';
  private USER_API = this.API + '/user';

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<any> {
    return this.http.get(this.USER_API + '/users');
  }

  getUserByName(user_name: string): Observable<any> {
    return this.http.post(this.USER_API + '/search-by-name', user_name);
  }

  getUserById(user_id: number): Observable<any> {
    return this.http.get(this.USER_API + '/search-by-id/' + user_id);
  }

  updateUser(user: User): Observable<any> {
    return this.http.put(this.USER_API + '/update/' + user.userId, user);
  }

  addUser(user: User): Observable<any> {
    return this.http.post(this.USER_API + '/add', user);
  }

  deleteUser(user_id: number): Observable<any> {
    return this.http.delete(this.USER_API + '/delete/' + user_id);
  }
}

