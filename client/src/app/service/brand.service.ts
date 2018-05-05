import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BrandService {

  private brandUrl = 'http://localhost:8080/perfumesystem-web/brand';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getBrands (): Observable<Object[]> {
     const url = this.brandUrl+'/all';
    return this.http.get<Object[]>(url);
  }

  /** GET perfume by id*/
  getBrand(id: number): Observable<Object> {
    const url = this.brandUrl+'/find/?id='+id;
    return this.http.get<Object>(url);
  }
  
  /** POST: add a new perfume to the server */
  addBrand (brand: Object): void {
    const url = this.brandUrl+'/new';
    this.http.post(url, brand, httpOptions).subscribe();
  }

  /** DELETE: delete the hero from the server */
  deleteBrand (id: number): Observable<Object> {
    const url = this.brandUrl+'/remove';

    return this.http.post<Number>(url,id, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateBrand (brand: Object): Observable<any> {
     const url = this.brandUrl+'/update';
    return this.http.post<Object>(url, brand, httpOptions);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
}