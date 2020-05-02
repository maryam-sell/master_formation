import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { NgForm}  from '@angular/forms';
import { NewUserService } from './new-user.service';
import { UserModel } from '../model/user/user';


@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  userVar: UserModel = new UserModel();
   submitted = false;

  constructor(private newUserService: NewUserService,
    private route: ActivatedRoute,
    private router: Router) { 
      this.userVar = new UserModel();
    }

  ngOnInit() {
  }

  newUser(): void{
    this.submitted = false;
    this.userVar = new UserModel();
  }

  addNewUser(f: NgForm) {
    console.log(this.userVar);                                             
    this.newUserService.createUser(this.userVar)
      .subscribe(data => console.log(data), error => console.log(error));
      
  }

  onSubmit(f: NgForm){
    this.addNewUser(f);
    this.submitted=true;
    
    
  }

}
