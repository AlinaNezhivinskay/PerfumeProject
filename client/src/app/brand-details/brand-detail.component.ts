import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { BrandService }  from '../service/brand.service';
import { PerfumeService }  from '../service/perfume.service';


@Component({
  selector: 'app-brand-detail',
  templateUrl: './brand-detail.component.html',
  styleUrls: [ './brand-detail.component.css' ]
})
export class BrandDetailComponent implements OnInit {
  brand: Object;
  perfumes:Object[];

  constructor(
    private route: ActivatedRoute,
    private brandService: BrandService,
    private perfumeService: PerfumeService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getBrand();
    this.getPerfumesByBrand();
  }

  getBrand(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.brandService.getBrand(id)
      .subscribe(brand => this.brand = brand);
  }

  getPerfumesByBrand(): void{
     const id = +this.route.snapshot.paramMap.get('id');
    this.perfumeService.getPerfumesByBrand(id).subscribe(perfumes => this.perfumes = perfumes);
  }

  goBack(): void {
    this.location.back();
  }
}