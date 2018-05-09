import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Brand } from '../entities/brand';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BrandService {

  private brandUrl = 'http://localhost:8080/perfumesystem-web/brand';  

  constructor(
    private http: HttpClient) { }

  /** GET perfumes from the server */
  getBrands (): Observable<Brand[]> {
     const url = this.brandUrl+'/all';
    return this.http.get<Brand[]>(url);
  }

  /** GET perfumes from the server */
  getBrandsByCountry (id:number): Observable<Brand[]> {
     const url = this.brandUrl+'/by_country?id='+id;
    return this.http.get<Brand[]>(url);
  }


  /** GET perfume by id*/
  getBrand(id: number): Observable<Brand> {
    const url = this.brandUrl+'/find/?id='+id;
    return this.http.get<Brand>(url);
  }
  
  /** POST: add a new perfume to the server */
  addBrand (brand: Brand):  Observable<Brand> {
    const url = this.brandUrl+'/new';
    return this.http.post<Brand>(url, brand, httpOptions);
  }

  /** DELETE: delete the hero from the server */
  deleteBrand (brand: Brand): Observable<Brand> {
    const url = this.brandUrl+'/remove';
    return this.http.post<Brand>(url,brand, httpOptions);
  }

  /** PUT: update the hero on the server */
  updateBrand (brand: Brand): Observable<Brand> {
     const url = this.brandUrl+'/update';
    return this.http.post<Brand>(url, brand, httpOptions);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
}