import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { BrandService }  from '../service/brand.service';
import { CountryService }  from '../service/country.service';

import { Country } from '../entities/country';
import { Brand } from '../entities/brand';

@Component({
  selector: 'app-country-detail',
  templateUrl: './country-detail.component.html',
  styleUrls: [ './country-detail.component.css' ]
})
export class CountryDetailComponent implements OnInit {
  country: Country;
  brands:Brand[];

  constructor(
    private route: ActivatedRoute,
    private brandService: BrandService,
    private countryService: CountryService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getCountry();
    this.getBrandsByCountry();
  }

  getCountry(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.countryService.getCountry(id)
      .subscribe(country => this.country = country);
  }

  getBrandsByCountry(): void{
     const id = +this.route.snapshot.paramMap.get('id');
    this.brandService.getBrandsByCountry(id).subscribe(brands => this.brands = brands);
  }

  goBack(): void {
    this.location.back();
  }
}