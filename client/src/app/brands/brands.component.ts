import { Component } from '@angular/core';
import { BrandService } from '../service/brand.service';

import { UserService } from '../service/user.service';
import { CountryService }  from '../service/country.service';

import { Brand } from '../entities/brand';

@Component({
  selector: 'app-brands',
  templateUrl: './brands.component.html',
  styleUrls: ['./brands.component.css']
})
export class BrandsComponent {
  role:String;
  countries: Object[];
  brands: Brand[];

  brand:Brand=new Brand();

  constructor(
    private brandService: BrandService,
    private userService: UserService,
    private countryService:CountryService
    ) { }

  ngOnInit() {
    this.getBrands();
    this.getCountries();
    this.role=this.userService.getUser();
  }

  getCountries():void{
    this.countryService.getCountries()
    .subscribe(countries => this.countries = countries);
  }
  getBrands(): void {
    this.brandService.getBrands()
    .subscribe(brands => this.brands = brands);
  }
  addBrand():void{
    this.brandService.addBrand(this.brand).subscribe(b=>this.brands.push(b));
  }

  delete(brand: Brand): void {
    this.brandService.deleteBrand(brand).subscribe(brand=>{
      let index=this.brands.indexOf(this.brands.find(b=>b.id==brand.id));
    if (index !== -1) {
        this.brands.splice(index, 1);
    } 
    });
  }
}