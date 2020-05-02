import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../login/auth.service';
import { Observable } from 'rxjs';
import { FormationModel } from '../model/formation/formation';

@Injectable({
  providedIn: 'root'
})
export class FormateurService {

  [x: string]: any;

  private baseUrl = 'http://localhost:8080/angularfront/listformateur';

  constructor(private http: HttpClient, private authenticationService:AuthenticationService) { }


  getFormationList(): Observable<any> {
    return this.http.get("http://localhost:8080/angularfront/listformateur");
  }

  
}
