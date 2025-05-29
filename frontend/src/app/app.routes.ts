import { Routes } from '@angular/router';
import {RegisterComponent} from './auth/register/register.component';
import {LoginComponent} from './auth/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {EvenementComponent} from './components/evenement/evenement.component';

export const routes: Routes = [

  { path: 'register',
    component :RegisterComponent },
  {path : 'login',
  component : LoginComponent},
  {path:'home',
  component:HomeComponent},

]
