import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class NoteService {

  private noteUrl = 'http://localhost:8080/perfumesystem-web/note';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getNotes (): Observable<Object[]> {
     const url = this.noteUrl+'/all';
    return this.http.get<Object[]>(url);
  }

  /** GET perfume by id*/
  getNote(id: number): Observable<Object> {
    const url = this.noteUrl+'/find/?id='+id;
    return this.http.get<Object>(url);
  }

   /** GET perfume by id*/
  getNotesByNoteGroup(id: number): Observable<Object> {
    const url = this.noteUrl+'/by_note_group/?id='+id;
    return this.http.get<Object[]>(url);
  }
  
  /** POST: add a new perfume to the server */
  addNote (note: Object): Observable<Object> {
    const url = this.noteUrl+'/new';
    return this.http.post<Object>(url, note, httpOptions);
  }

  /** DELETE: delete the hero from the server */
  deleteNote (id: number): Observable<Object> {
    const url = this.noteUrl+'/remove';

    return this.http.post<Number>(url,id, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateNote (note: Object): Observable<any> {
     const url = this.noteUrl+'/update';
    return this.http.post<Object>(url, note, httpOptions);
  }
}