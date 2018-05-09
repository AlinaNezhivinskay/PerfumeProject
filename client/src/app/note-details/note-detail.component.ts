import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { NoteService }  from '../service/note.service';
import { PerfumeService }  from '../service/perfume.service';


@Component({
  selector: 'app-note-detail',
  templateUrl: './note-detail.component.html',
  styleUrls: [ './note-detail.component.css' ]
})
export class NoteDetailComponent implements OnInit {
  note: Object;
  perfumes:Object[];

  constructor(
    private route: ActivatedRoute,
    private noteService: NoteService,
    private perfumeService: PerfumeService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getNote();
    this.getPerfumesByNote();
  }

  getNote(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.noteService.getNote(id)
      .subscribe(note => this.note = note);
  }

  getPerfumesByNote():void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.perfumeService.getPerfumesByNote(id).
    subscribe(perfumes=>this.perfumes=perfumes);
  }

  goBack(): void {
    this.location.back();
  }
}