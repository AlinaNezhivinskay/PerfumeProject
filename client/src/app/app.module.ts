import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent }         from './app.component';

import { PerfumesAdminComponent }   from './perfumes-admin/perfumes-admin.component';
import { PerfumeAddComponent }   from './perfume-add/perfume-add.component';

import { PerfumesComponent }   from './perfumes/perfumes.component';
import { PerfumeDetailComponent }   from './perfume-details/perfume-detail.component';
import { PerfumeService }          from './service/perfume.service';

import { BrandService }          from './service/brand.service';
import { BrandsComponent }   from './brands/brands.component';
import { BrandDetailComponent }   from './brand-details/brand-detail.component';
import { BrandAddComponent }   from './brand-add/brand-add.component';

import { NoteService }          from './service/note.service';
import { NotesComponent }   from './notes/notes.component';

import { NoteGroupService }          from './service/note-group.service';

import { CountryService }          from './service/country.service';

@NgModule({
  declarations: [
    AppComponent,
    PerfumesComponent,
    PerfumeDetailComponent,
    BrandsComponent,
    BrandDetailComponent,
    NotesComponent,
    PerfumesAdminComponent,
    PerfumeAddComponent,
    BrandAddComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [PerfumeService, BrandService, NoteService, NoteGroupService,CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
