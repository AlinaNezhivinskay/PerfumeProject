import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent }         from './app.component';

import { PerfumeAddComponent }   from './perfume-add/perfume-add.component';

import { PerfumesComponent }   from './perfumes/perfumes.component';
import { PerfumeDetailComponent }   from './perfume-details/perfume-detail.component';
import { PerfumeService }          from './service/perfume.service';

import { BrandService }          from './service/brand.service';
import { BrandsComponent }   from './brands/brands.component';
import { BrandDetailComponent }   from './brand-details/brand-detail.component';

import { NoteService }          from './service/note.service';
import { NotesComponent }   from './notes/notes.component';
import { NoteDetailComponent }   from './note-details/note-detail.component';

import { NoteGroupService }          from './service/note-group.service';

import { CountryService }          from './service/country.service';
import { CountriesComponent }   from './countries/countries.component';
import { CountryDetailComponent }   from './country-details/country-detail.component';

import { UserService }          from './service/user.service';

import { PerfumesByNotesComponent }   from './perfume-by-notes/perfume-by-notes.component';

@NgModule({
  declarations: [
    AppComponent,
    PerfumesComponent,
    PerfumeDetailComponent,
    BrandsComponent,
    BrandDetailComponent,
    NotesComponent,
    NoteDetailComponent,
    PerfumeAddComponent,
    CountriesComponent,
    CountryDetailComponent,
    PerfumesByNotesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [PerfumeService, BrandService, NoteService, NoteGroupService,CountryService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
 
 }
