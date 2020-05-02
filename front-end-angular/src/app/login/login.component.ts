import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../login/auth.service';
import { NgForm}  from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password : string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;
  //private regForm:FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { 
    }

  ngOnInit() {
  }
  
  handleLogin(f: NgForm) {
    //console.log('scope is ' + this.route.snapshot.params.username ); //+ this.regForm.get('username').value + this.password);
    this.username = f.value.username;
    this.password = f.value.password;
    this.authenticationService
        .authenticationService(this.username, this.password)
        .subscribe((result)=> {
                    console.log(result); 
                    this.invalidLogin = false;
                    this.loginSuccess = true;
                    this.successMessage = 'Login Successful.';
                    this.authenticationService.registerSuccessfulLogin(result.firstName, "");
                    if (result.isFormateur) {
                      this.router.navigate(['/benificiare']);
                    } else {
                      this.router.navigate(['/formateur']);
                    }

                  }, () => {
                    this.invalidLogin = true;
                    this.loginSuccess = false;
                  });      
  }
}