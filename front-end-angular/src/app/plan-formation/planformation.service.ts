import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../login/auth.service';
import { Observable } from 'rxjs';
import { FormationModel } from '../model/formation/formation';
import { PlanformationModel } from '../model/planformation/planformation';

@Injectable({
  providedIn: 'root'
})
export class PlanformationService {

  [x: string]: any;

  private baseUrl = 'http://localhost:8080/angularfront/addNewPlanFormation';

  constructor(private http: HttpClient, private authenticationService:AuthenticationService) { }

 
  createFormation(formation: PlanformationModel): Observable<Object> {
    console.log(formation);
    return this.http.post("http://localhost:8080/angularfront/addNewPlanFormation", formation);
  }

}
