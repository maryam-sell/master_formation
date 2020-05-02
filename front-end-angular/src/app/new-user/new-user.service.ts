import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../login/auth.service';
import { UserModel } from '../model/user/user';

@Injectable({
  providedIn: 'root'
})
export class NewUserService {

  private baseUrl = 'http://localhost:8080/angularfront';

  constructor(private http: HttpClient, private authenticationService:AuthenticationService) { }

  createUser(user: UserModel): Observable<Object> {
    console.log(user);
    return this.http.post("http://localhost:8080/angularfront/addNewUser", user);
  }
}
