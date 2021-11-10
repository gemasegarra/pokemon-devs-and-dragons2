import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { TrainersComponent } from './components/trainers/trainers.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: "", component: TrainersComponent},
  {path: "pokedex", component: TrainersComponent},
  {path: "teams", component: TrainersComponent},
  {path: "trainers", component: TrainersComponent},
  {path: "**", component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
