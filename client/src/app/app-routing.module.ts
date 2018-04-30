import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PerfumesComponent }   from './perfumes/perfumes.component';
import { PerfumeDetailComponent }   from './perfume-details/perfume-detail.component';

import { BrandsComponent }   from './brands/brands.component';
import { BrandDetailComponent }   from './brand-details/brand-detail.component';

import { NotesComponent }   from './notes/notes.component';

const routes: Routes = [
  { path: '', redirectTo: '/perfumes', pathMatch: 'full' },
  { path: 'perfumes', component: PerfumesComponent },
  { path: 'detail/:id', component: PerfumeDetailComponent },
  { path: 'brands', component: BrandsComponent },
  { path: 'brand_detail/:id', component: BrandDetailComponent },
  { path: 'notes', component: NotesComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}