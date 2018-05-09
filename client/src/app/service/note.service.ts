import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Note } from '../entities/note';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class NoteService {

  private noteUrl = 'http://localhost:8080/perfumesystem-web/note';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getNotes (): Observable<Note[]> {
     const url = this.noteUrl+'/all';
    return this.http.get<Note[]>(url);
  }

  /** GET perfume by id*/
  getNote(id: number): Observable<Note> {
    const url = this.noteUrl+'/find/?id='+id;
    return this.http.get<Note>(url);
  }

   /** GET perfume by id*/
  getNotesByNoteGroup(id: number): Observable<Note[]> {
    const url = this.noteUrl+'/by_note_group/?id='+id;
    return this.http.get<Note[]>(url);
  }
  
  /** POST: add a new perfume to the server */
  addNote (note: Note): Observable<Note> {
    const url = this.noteUrl+'/new';
    return this.http.post<Note>(url, note, httpOptions);
  }

  /** DELETE: delete the hero from the server */
  deleteNote (note: Note): Observable<Note> {
    const url = this.noteUrl+'/remove';
    return this.http.post<Note>(url,note, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateNote (note: Note): Observable<Note> {
     const url = this.noteUrl+'/update';
    return this.http.post<Note>(url, note, httpOptions);
  }
}