import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class NoteGroupService {

  private noteGroupUrl = 'http://localhost:8080/perfumesystem-web/note_group';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getNoteGroups (): Observable<Object[]> {
     const url = this.noteGroupUrl+'/all';
    return this.http.get<Object[]>(url);
  }

  /** GET perfume by id*/
  getNoteGroup(id: number): Observable<Object> {
    const url = this.noteGroupUrl+'/find/?id='+id;
    return this.http.get<Object>(url);
  }
  
  /** POST: add a new perfume to the server */
  addNoteGroup (brand: Object): Observable<Object> {
    const url = this.noteGroupUrl+'/new';
    return this.http.post<Object>(url, brand, httpOptions);
  }

  /** DELETE: delete the hero from the server */
  deleteNoteGroup (id: number): Observable<Object> {
    const url = this.noteGroupUrl+'/remove';

    return this.http.post<Number>(url,id, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateNoteGroup (brand: Object): Observable<any> {
     const url = this.noteGroupUrl+'/update';
    return this.http.post<Object>(url, brand, httpOptions);
  }
}