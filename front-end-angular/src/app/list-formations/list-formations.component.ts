import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationModel } from "../model/formation/formation";
import { Observable } from "rxjs";
import { FormationService } from "../formation/formation.service";

@Component({
  selector: 'app-list-formations',
  templateUrl: './list-formations.component.html',
  styleUrls: ['./list-formations.component.css']
})
export class ListFormationsComponent implements OnInit {

  listFormationVar: Observable<FormationModel[]>;

  constructor(private formationService: FormationService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.listFormationVar = this.formationService.getFormationList();
  }


  deleteFormation(id: number) {
    this.formationService.deleteFormation(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateFormation(id: number){
    this.router.navigate(['updateformation', id]);
  }
  

}


