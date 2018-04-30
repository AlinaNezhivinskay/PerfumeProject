import { Component } from '@angular/core';
import { NoteService } from '../service/note.service';
import { NoteGroupService } from '../service/note-group.service';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent {
  noteGroups: Object[];
  notes:Object[];

  constructor(
    private noteService: NoteService,
    private noteGroupService: NoteGroupService
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
}