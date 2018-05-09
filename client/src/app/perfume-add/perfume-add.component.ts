import { Component, OnInit,ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { PerfumeService }  from '../service/perfume.service';
import { BrandService } from '../service/brand.service';
import { NoteService } from '../service/note.service';

import { Perfume } from '../entities/perfume';
import { Brand } from '../entities/brand';
import { Note } from '../entities/note';
import { NotePyramide } from '../entities/notePyramide';

@Component({
  selector: 'app-perfume-detail',
  templateUrl: './perfume-add.component.html',
  styleUrls: [ './perfume-add.component.css' ]
})
export class PerfumeAddComponent implements OnInit {
  brands: Brand[];
  notes:Note[];

   @ViewChild("image")
  image: any;

  perfume:Perfume=new Perfume();
  pyramide : NotePyramide = new NotePyramide();

  constructor(
    private route: ActivatedRoute,
    private perfumeService: PerfumeService,
    private brandService: BrandService,
    private noteService: NoteService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getBrands();
    this.getNotes();
  }

   getBrands(): void {
    this.brandService.getBrands()
    .subscribe(brands => this.brands = brands);
  }

   getNotes(): void {
    this.noteService.getNotes()
    .subscribe(notes => this.notes = notes);
  }

  public imageChoosed(event:any){
    let file=event.target.files[0];
    let reader  = new FileReader();
    reader.readAsDataURL(file);
    reader.onloadend = (e) => {
    this.image.nativeElement.src=reader.result;
    this.handleFileSelect(file);
  }
  }
  addPerfume(){
    this.perfumeService.addPerfume(this.perfume);
  }

  handleFileSelect(file){
    var reader = new FileReader();
    reader.onload =this._handleReaderLoaded.bind(this);
    reader.readAsBinaryString(file);
       
  }
  _handleReaderLoaded(readerEvt) {
     var binaryString = readerEvt.target.result;
     this.perfume.image= btoa(binaryString);
    }

  goBack(): void {
    this.location.back();
  }

  addNote():void{
    //this.perfumeNotes.push(this.pyramide);
    this.perfume.notePyramide.push(this.pyramide);
    this.pyramide=new NotePyramide();
  }

  removeNote(id:number):void{
    let index=this.perfume.notePyramide.indexOf(this.perfume.notePyramide.find(p=>p.note.id==id));
    if (index !== -1) {
        this.perfume.notePyramide.splice(index, 1);
    } 
  }

}

