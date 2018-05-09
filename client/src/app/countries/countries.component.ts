import { Component } from '@angular/core';
import { BrandService } from '../service/brand.service';

import { UserService } from '../service/user.service';
import { CountryService }  from '../service/country.service';

import { Country } from '../entities/country';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent {
  role:String;
  countries: Country[];

  country:Country=new Country();

  constructor(
    private userService: UserService,
    private countryService:CountryService
    ) { }

  ngOnInit() {
    this.getCountries();
    this.role=this.userService.getUser();
  }

  getCountries():void{
    this.countryService.getCountries()
    .subscribe(countries => this.countries = countries);
  }

  addCountry():void{
    this.countryService.addCountry(this.country).subscribe(c=>this.countries.push(c));
  }

  delete(country: Country): void {
    this.countryService.deleteCountry(country).subscribe(country=>{
      let index=this.countries.indexOf(this.countries.find(c=>c.id==country.id));
    if (index !== -1) {
        this.countries.splice(index, 1);
    } 
    });
  }
}