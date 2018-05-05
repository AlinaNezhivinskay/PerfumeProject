import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CountryService {

  private countryUrl = 'http://localhost:8080/perfumesystem-web/country';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getCountries (): Observable<Object[]> {
     const url = this.countryUrl+'/all';
    return this.http.get<Object[]>(url);
  }

  /** GET perfume by id*/
  getCountry(id: number): Observable<Object> {
    const url = this.countryUrl+'/find/?id='+id;
    return this.http.get<Object>(url);
  }
  
  /** POST: add a new perfume to the server */
  addCountry (country: Object): Observable<Object> {
    const url = this.countryUrl+'/new';
    return this.http.post<Object>(url, country, httpOptions);
  }

  /** DELETE: delete the hero from the server */
  deleteCountry (id: number): Observable<Object> {
    const url = this.countryUrl+'/remove';
    return this.http.post<Number>(url,id, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateCountry (country: Object): Observable<any> {
     const url = this.countryUrl+'/update';
    return this.http.post<Object>(url, country, httpOptions);
  }