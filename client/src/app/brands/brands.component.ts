import { Component } from '@angular/core';
import { BrandService } from '../service/brand.service';

@Component({
  selector: 'app-brands',
  templateUrl: './brands.component.html',
  styleUrls: ['./brands.component.css']
})
export class BrandsComponent {
  brands: Object[];

  constructor(private brandService: BrandService) { }

  ngOnInit() {
    this.getBrands();
  }

  getBrands(): void {
    this.brandService.getBrands()
    .subscribe(brands => this.brands = brands);
  }

  add(name: string, year:number): void {
    name = name.trim();
    if (!name) { return; }
    this.brandService.addBrand({ name,year } as Object)
      .subscribe(brand => {
        this.brands.push(brand);
      });
  }

  delete(id: number): void {
    this.brandService.deleteBrand(id).subscribe();
  }
}