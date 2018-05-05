import { Component } from '@angular/core';
import { PerfumeService } from '../service/perfume.service';

import { Perfume } from '../entities/perfume';

@Component({
  selector: 'app-perfumes-admin',
  templateUrl: './perfumes-admin.component.html',
  styleUrls: ['./perfumes-admin.component.css']
})
export class PerfumesAdminComponent {
  perfumes: Perfume[];

  constructor(private perfumeService: PerfumeService) { }

  ngOnInit() {
    this.getPerfumes();
  }

  getPerfumes(): void {
    this.perfumeService.getPerfumes()
    .subscribe(perfumes => this.perfumes = perfumes);
  }

  delete(id: number): void {
    this.perfumeService.deletePerfume({ id } as Perfume);
  }
}