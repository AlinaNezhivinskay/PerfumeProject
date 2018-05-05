import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Perfume } from '../entities/perfume';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PerfumeService {

  private perfumeUrl = 'http://localhost:8080/perfumesystem-web/perfume';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getPerfumes (): Observable<Perfume[]> {
     const url = this.perfumeUrl+'/all';
    return this.http.get<Perfume[]>(url);
  }

  /** GET perfume by id*/
  getPerfume(id: number): Observable<Perfume> {
    const url = this.perfumeUrl+'/find/?id='+id;
    return this.http.get<Perfume>(url);
  }

/** GET perfume by id*/
  getPerfumesByBrand(id: number): Observable<Perfume[]> {
    const url = this.perfumeUrl+'/by_brand/?id='+id;
    return this.http.get<Perfume[]>(url);
  }

  /** POST: add a new perfume to the server */
  addPerfume (perfume: Object): void {
    const url = this.perfumeUrl+'/new';
    this.http.post(url, perfume, httpOptions).subscribe();
  }

  /** DELETE: delete the hero from the server */
  deletePerfume (perfume: Perfume): void {
    const url = this.perfumeUrl+'/remove';
    this.http.post(url,perfume, httpOptions).subscribe();
  }

  /** PUT: update the hero on the server */
  updatePerfume (perfume: Perfume): Observable<any> {
     const url = this.perfumeUrl+'/update';
    return this.http.post<Perfume>(url, perfume, httpOptions);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
}