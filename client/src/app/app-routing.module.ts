import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PerfumesComponent }   from './perfumes/perfumes.component';
import { PerfumeDetailComponent }   from './perfume-details/perfume-detail.component';

import { PerfumeAddComponent }   from './perfume-add/perfume-add.component';

import { BrandsComponent }   from './brands/brands.component';
import { BrandDetailComponent }   from './brand-details/brand-detail.component';

import { NotesComponent }   from './notes/notes.component';
import { NoteDetailComponent }   from './note-details/note-detail.component';

import { CountriesComponent }   from './countries/countries.component';
import { CountryDetailComponent }   from './country-details/country-detail.component';

import { PerfumesByNotesComponent }   from './perfume-by-notes/perfume-by-notes.component';

const routes: Routes = [
  { path: '', redirectTo: '/perfumes', pathMatch: 'full' },
  { path: 'perfumes', component: PerfumesComponent },
  { path: 'detail/:id', component: PerfumeDetailComponent },
  { path: 'brands', component: BrandsComponent },
  { path: 'brand_detail/:id', component: BrandDetailComponent },
  { path: 'notes', component: NotesComponent },
  { path: 'perfume/add', component: PerfumeAddComponent },
  { path: 'note_detail/:id', component: NoteDetailComponent },
  { path: 'countries', component: CountriesComponent },
  { path: 'country_detail/:id', component: CountryDetailComponent },

  { path: 'perfumes_by_notes', component: PerfumesByNotesComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}