import { Component } from '@angular/core';
import {ListEventComponent} from '../Evenement/list-event/list-event.component';

@Component({
  selector: 'app-home',
  imports: [
    ListEventComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
