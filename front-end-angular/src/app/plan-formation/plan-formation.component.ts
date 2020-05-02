import { Component, OnInit } from '@angular/core';
import { PlanformationModel } from '../model/planformation/planformation';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanformationService } from './planformation.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-plan-formation',
  templateUrl: './plan-formation.component.html',
  styleUrls: ['./plan-formation.component.css']
})
export class PlanFormationComponent implements OnInit {

  formationVar: PlanformationModel = new PlanformationModel();
  submitted = false;
  

  constructor(
    private planformationService: PlanformationService,
    private route: ActivatedRoute,
    private router: Router) 
    { 
      this.formationVar = new PlanformationModel();
    }

  ngOnInit() {
  }

  newFormation(): void{
    this.submitted = false;
    this.formationVar = new PlanformationModel();
  }

  addFormation(f: NgForm) {
    console.log("Angular addFormation btn was clicked");                                             
    this.planformationService.createFormation(this.formationVar)
      .subscribe(data => console.log(data), error => console.log(error));
  }

  onSubmit(f: NgForm){
    this.addFormation(f);
    this.submitted=true;
  }

}
