import { Component, OnInit,ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { CountryService }  from '../service/country.service';
import { BrandService } from '../service/brand.service';


@Component({
  selector: 'app-perfume-detail',
  templateUrl: './brand-add.component.html',
  styleUrls: [ './brand-add.component.css' ]
})
export class BrandAddComponent implements OnInit {
   brand={};
   countries: Object[];


  constructor(
    private route: ActivatedRoute,
    private brandService: BrandService,
    private countryService: CountryService,
     private location: Location
  ) {}

  ngOnInit(): void {
    this.getCountries();
  }

  getCountries():void{
    this.countryService.getCountries()
    .subscribe(countries => this.countries = countries);
  }

  addBrand():void{
    this.brandService.addBrand(this.brand);
    this.location.back();
  }
 }