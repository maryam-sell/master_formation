import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../login/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  isLoggedIn = false;
  http: any;

  constructor(private router: Router,
    private authenticationService: AuthenticationService) { }

    ngOnInit() {
      this.isLoggedIn = this.authenticationService.isUserLoggedIn();
      console.log('menu ->' + this.isLoggedIn);
    }

    handleLogout() {
      this.authenticationService.logout();
      return this.http.get('http://localhost:8080/angularfront');
    }

}
