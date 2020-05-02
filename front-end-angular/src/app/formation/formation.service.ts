import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../login/auth.service';
import { FormationModel } from '../model/formation/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  [x: string]: any;

  private baseUrl = 'http://localhost:8080/angularfront/formation';

  constructor(private http: HttpClient, private authenticationService:AuthenticationService) { }

  getFormation(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createFormation(formation: FormationModel): Observable<Object> {
    console.log(formation);
    return this.http.post("http://localhost:8080/angularfront/addNewFormation", formation);
  }

  updateFormation(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteFormation(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getFormationList(): Observable<any> {
    return this.http.get("http://localhost:8080/angularfront/listformations");
  }

  getBenFormationList(): Observable<any> {
    return this.http.get("http://localhost:8080/angularfront/listbenfor");
  }
}
