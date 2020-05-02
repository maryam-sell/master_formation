import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldService } from './hello-world/hello-world.service';
import { AuthenticationService } from './login/auth.service';
import { MenuComponent } from './menu/menu.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { LoginComponent } from './login/login.component';
import { FormateurComponent } from './formateur/formateur.component';
import { LoginGuard } from './login/auth.guard';
import { FormationComponent } from './formation/formation.component';
import { FormationService } from './formation/formation.service';
import { NewUserComponent } from './new-user/new-user.component';
import { LogoutComponent } from './logout/logout.component';
import { ListFormationsComponent } from './list-formations/list-formations.component';
import { UpdateFormationComponent } from './update-formation/update-formation.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { BannerComponent } from './home/banner/banner.component';
import { HomeComponent } from './home/home.component';
import { PlanFormationComponent } from './plan-formation/plan-formation.component';
import { AProposComponent } from './a-propos/a-propos.component';







@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HelloWorldComponent,
    LoginComponent,
    FormateurComponent,
    FormationComponent,
    NewUserComponent,
    LogoutComponent,
    ListFormationsComponent,
    UpdateFormationComponent,
    HeaderComponent,
    FooterComponent,
    BannerComponent,
    HomeComponent,
    PlanFormationComponent,
    AProposComponent,
   


    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [
    HelloWorldService,
    AuthenticationService,
    FormationService,
 
    LoginGuard
    
  ], 
  bootstrap: [AppComponent]
})
export class AppModule { }