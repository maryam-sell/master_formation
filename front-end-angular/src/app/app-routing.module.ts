import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { LoginComponent } from './login/login.component';
import { FormateurComponent } from './formateur/formateur.component';
import { LoginGuard } from './login/auth.guard';
import { FormationComponent } from './formation/formation.component';
import { NewUserComponent } from './new-user/new-user.component';
import { ListFormationsComponent } from './list-formations/list-formations.component';
import { UpdateFormationComponent } from './update-formation/update-formation.component';
import { HomeComponent} from './home/home.component';
import {LogoutComponent} from'./logout/logout.component';
import { PlanFormationComponent } from './plan-formation/plan-formation.component';
import { AProposComponent } from './a-propos/a-propos.component';




const routes: Routes = [
  {path: '' , component:HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'hello-world', component: HelloWorldComponent, canActivate: [LoginGuard] },
  {path: 'formateur', component: FormateurComponent, canActivate: [LoginGuard] },
  {path: 'formation', component: FormationComponent, canActivate: [LoginGuard] },
  {path: 'new-user', component: NewUserComponent },
  {path: 'listformations' , component: ListFormationsComponent, canActivate: [LoginGuard] },
  {path: 'updateformation/:id' , component: UpdateFormationComponent, canActivate: [LoginGuard] },
  {path: 'logout',component:LogoutComponent},
  {path: 'planformation',component:PlanFormationComponent},
  {path: 'apropos',component:AProposComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
}) 
export class AppRoutingModule { }

