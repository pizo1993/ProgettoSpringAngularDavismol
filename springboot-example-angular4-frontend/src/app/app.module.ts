import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserApiService } from './services/user-api.service';

import { HttpModule } from '@angular/http';
import { NavComponent } from './nav/nav.component';
import { UserDetailsComponent } from './user-details/user-details.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailsComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [UserApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
