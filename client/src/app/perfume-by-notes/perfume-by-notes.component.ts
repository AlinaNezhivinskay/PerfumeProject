import { Component,ViewChild } from '@angular/core';
import { NoteService } from '../service/note.service';
import { PerfumeService } from '../service/perfume.service';
import { NoteGroupService } from '../service/note-group.service';

import { Note } from '../entities/note';
import { Perfume } from '../entities/perfume';

@Component({
  selector: 'app-perfumes-by-notes',
  templateUrl: './perfume-by-notes.component.html',
  styleUrls: ['./perfume-by-notes.component.css']
})
export class PerfumesByNotesComponent {
  noteGroups: Object[];
  notes:Note[];

  chosenNotes:Note[]=new Array();

  perfumes:Perfume[];
  
  constructor(
    private noteService: NoteService,
    private noteGroupService: NoteGroupService,
    private perfumeService: PerfumeService,
    ) { }

  ngOnInit() {
    this.getNoteGroups();
    this.getNotes();
  }

  getNoteGroups(): void {
    this.noteGroupService.getNoteGroups()
    .subscribe(noteGroups => this.noteGroups = noteGroups);
  }

  getNotes(): void {
     this.noteService.getNotes()
    .subscribe(notes => this.notes = notes);
  }

  chooseNote(note:Note):void{
    if(this.chosenNotes.length<3){
       this.chosenNotes.push(note);
       let index=this.notes.indexOf(note);
       if (index !== -1) {
        this.notes.splice(index, 1);
    } 
    }
  }
  cancelChosenNote(note:Note):void{
    this.notes.push(note);
    let index=this.chosenNotes.indexOf(note);
    if (index !== -1) {
        this.chosenNotes.splice(index, 1);
    } 
  }
  cancel():void{
    var note:Note;
    while(note=this.chosenNotes.pop()){
       this.notes.push(note);
    }
  }
  findByNotes():void{
    this.perfumeService.getPerfumesByNotes(this.chosenNotes).subscribe(perfumes=>this.perfumes=perfumes);
  }
}