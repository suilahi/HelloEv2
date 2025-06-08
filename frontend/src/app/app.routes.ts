import { Routes } from '@angular/router';
import {RegisterComponent} from './auth/register/register.component';
import {LoginComponent} from './auth/login/login.component';
import {ListEventComponent} from './components/Evenement/list-event/list-event.component';
import {AddEventComponent} from './components/Evenement/add-event/add-event.component';
import {HomeComponent} from './components/home/home.component';

export const routes: Routes = [
  {
    path: 'register',
    component:RegisterComponent  },
  {
    path: 'login',
    component:LoginComponent
      },
  {
      path:'list-event',
    component:ListEventComponent
  },
  {
    path: 'add-event',
    component:AddEventComponent
  },
  {path:'home',
  component:HomeComponent
  }
];
