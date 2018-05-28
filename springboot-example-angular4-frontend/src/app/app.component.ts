import { User } from './models/user';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  u1: User = new User('Davis', 'Molinari', 'Italy', 34);
  u2: User = new User('Lionel', 'Messi', 'Argentina', 30);
  u3: User = new User('Jason', 'Bourne', 'US', 30);
   users: User[] = [this.u1, this.u2, this.u3];
}
