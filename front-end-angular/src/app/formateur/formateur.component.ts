import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { FormateurService } from './formateur.service';
import { Formateur } from './formateur';


@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {
 
  formateur: Observable<Formateur[]>;

  constructor( private formateurService: FormateurService, private router: Router) {}

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.formateur = this.formateurService.getFormationList();
  }
  
}