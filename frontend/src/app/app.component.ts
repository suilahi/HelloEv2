import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import {LoginComponent} from './auth/login/login.component';
import {HomeComponent} from './components/home/home.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, HomeComponent],
  templateUrl:'./app.component.html',
  styleUrls :['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
}
