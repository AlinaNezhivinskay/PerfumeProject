import { Component } from '@angular/core';
import { PerfumeService } from '../service/perfume.service';

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

  add(name: string, year:number): void {
    name = name.trim();
    if (!name) { return; }
    this.perfumeService.addPerfume({ name,year } as Object)
      .subscribe(perfume => {
        this.perfumes.push(perfume);
      });
  }

  delete(id: number): void {
    this.perfumeService.deletePerfume(id).subscribe();
  }
}