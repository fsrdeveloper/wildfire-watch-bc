import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Import FormsModule for ngModel binding
import { MatToolbarModule } from '@angular/material/toolbar'; // Import MatToolbarModule
import { MatCardModule } from '@angular/material/card'; // Import MatCardModule
import { MatFormFieldModule } from '@angular/material/form-field'; // Import MatFormFieldModule
import { MatInputModule } from '@angular/material/input'; // Import MatInputModule
import { MatButtonModule } from '@angular/material/button'; // Import MatButtonModule

import { AppComponent } from './app.component';
import { FirePointsComponent } from './fire-points/fire-points.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Import BrowserAnimationsModule
import { GoogleMapsModule } from '@angular/google-maps';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@NgModule({
  declarations: [
    AppComponent,
    FirePointsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    GoogleMapsModule,
    MatProgressSpinnerModule,
    RouterModule, // Include RouterModule in the imports array
    FormsModule, // Import FormsModule for ngModel binding
    MatToolbarModule, // Import MatToolbarModule
    MatCardModule, // Import MatCardModule
    MatFormFieldModule, // Import MatFormFieldModule
    MatInputModule, // Import MatInputModule
    MatButtonModule // Import MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }