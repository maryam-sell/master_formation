import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { NgForm}  from '@angular/forms';
import { FormationService } from './formation.service';
import { FormationModel} from '../model/formation/formation';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {

  formationVar: FormationModel = new FormationModel();
  submitted = false;
  

  constructor(
    private formationService: FormationService,
    private route: ActivatedRoute,
    private router: Router) 
    { 
      this.formationVar = new FormationModel();
    }

  ngOnInit() {
  }

  newFormation(): void{
    this.submitted = false;
    this.formationVar = new FormationModel();
  }

  addFormation(f: NgForm) {
    console.log("Angular addFormation btn was clicked");                                             
    this.formationService.createFormation(this.formationVar)
      .subscribe(data => console.log(data), error => console.log(error));
  }

  onSubmit(f: NgForm){
    this.addFormation(f);
    this.submitted=true;
  }

}
