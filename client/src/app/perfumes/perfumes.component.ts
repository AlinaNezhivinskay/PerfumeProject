import { Component } from '@angular/core';
import { PerfumeService } from '../service/perfume.service';

import { UserService } from '../service/user.service';

import { Perfume } from '../entities/perfume';

@Component({
  selector: 'app-perfumes',
  templateUrl: './perfumes.component.html',
  styleUrls: ['./perfumes.component.css']
})
export class PerfumesComponent {
  role:String;
  perfumes: Object[];

  constructor(
    private perfumeService: PerfumeService,
    private userService: UserService,
    ) { }

  ngOnInit() {
    this.getPerfumes();
    this.role=this.userService.getUser();
  }

  getPerfumes(): void {
    this.perfumeService.getPerfumes()
    .subscribe(perfumes => this.perfumes = perfumes);
  }
  delete(perfume:Perfume): void {
    this.perfumeService.deletePerfume(perfume);
  }
}