import { Component,ViewChild } from '@angular/core';
import { NoteService } from '../service/note.service';
import { NoteGroupService } from '../service/note-group.service';

import { UserService } from '../service/user.service';

import { Note } from '../entities/note';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent {
  role:String;
  noteGroups: Object[];
  notes:Note[];
  
  perfumeNote:Note=new Note();;

  @ViewChild("image")
  image: any;


  constructor(
    private noteService: NoteService,
    private noteGroupService: NoteGroupService,
    private userService: UserService,
    ) { }

  ngOnInit() {
    this.getNoteGroups();
    this.getNotes();
    this.role=this.userService.getUser();
  }

  getNoteGroups(): void {
    this.noteGroupService.getNoteGroups()
    .subscribe(noteGroups => this.noteGroups = noteGroups);
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
  handleFileSelect(file){
    var reader = new FileReader();
    reader.onload =this._handleReaderLoaded.bind(this);
    reader.readAsBinaryString(file);
       
  }
  _handleReaderLoaded(readerEvt) {
     var binaryString = readerEvt.target.result;
     this.perfumeNote.image= btoa(binaryString);
   }
   addNote(){
     this.noteService.addNote(this.perfumeNote).subscribe(note=>this.notes.push(note));
   }

   delete(note:Note): void {
    this.noteService.deleteNote(note).subscribe();
  }
}