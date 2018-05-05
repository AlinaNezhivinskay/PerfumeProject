import { Component } from '@angular/core';
import { PerfumeService } from '../service/perfume.service';

import { Perfume } from '../entities/perfume';

@Component({
  selector: 'app-perfumes',
  templateUrl: './perfumes.component.html',
  styleUrls: ['./perfumes.component.css']
})
export class PerfumesComponent {
  perfumes: Object[];

  constructor(private perfumeService: PerfumeService) { }

  ngOnInit() {
    this.getPerfumes();
  }

  getPerfumes(): void {
    this.perfumeService.getPerfumes()
    .subscribe(perfumes => this.perfumes = perfumes);
  }
}