import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirePointsComponent } from './fire-points/fire-points.component';

const routes: Routes = [

  { path: '', redirectTo: 'fire-points', pathMatch: 'full' },
  { path: 'fire-points', component: FirePointsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  




 }
