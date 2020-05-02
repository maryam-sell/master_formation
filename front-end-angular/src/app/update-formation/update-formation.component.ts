import { Component, OnInit } from '@angular/core';
import { FormationModel } from "../model/formation/formation";
import { FormationService } from "../formation/formation.service";
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm}  from '@angular/forms';

@Component({
  selector: 'app-update-formation',
  templateUrl: './update-formation.component.html',
  styleUrls: ['./update-formation.component.css']
})
export class UpdateFormationComponent implements OnInit {

id: number;
formationVar: FormationModel ;

constructor(private route: ActivatedRoute,private router: Router,
  private formationService: FormationService) { }

ngOnInit() {
  this.formationVar = new FormationModel();

  this.id = this.route.snapshot.params['id'];
  
  this.formationService.getFormation(this.id)
    .subscribe(data => {
      console.log(data)
      this.formationVar = data;
    }, error => console.log(error));
}

updateFormation() {
  this.formationService.updateFormation(this.id, this.formationVar)
    .subscribe(data => console.log(data), error => console.log(error));
  this.formationVar = new FormationModel();
  this.gotoList();
}

onSubmit() {
  this.updateFormation();    
}

gotoList() {
  this.router.navigate(['/listformations']);
}
}
