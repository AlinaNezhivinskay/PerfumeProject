import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { PerfumeService }  from '../service/perfume.service';

@Component({
  selector: 'app-perfume-detail',
  templateUrl: './perfume-detail.component.html',
  styleUrls: [ './perfume-detail.component.css' ]
})
export class PerfumeDetailComponent implements OnInit {
  perfume: Object;


  constructor(
    private route: ActivatedRoute,
    private perfumeService: PerfumeService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getPerfume();
  }

  getPerfume(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.perfumeService.getPerfume(id)
      .subscribe(perfume => this.perfume = perfume);
  }

  goBack(): void {
    this.location.back();
  }
}