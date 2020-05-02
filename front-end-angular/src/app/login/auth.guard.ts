import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthenticationService } from './auth.service';

@Injectable()
export class LoginGuard implements CanActivate {
    constructor(public auth: AuthenticationService, protected router: Router) { }

    canActivate() {
        if (!this.auth.isUserLoggedIn()) {
            this.router.navigate(['/']);
            return false;
        }
        return true;
    }
}