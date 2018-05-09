import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { PerfumeService }  from '../service/perfume.service';
import {Perfume} from '../entities/perfume'
import { UserService }  from '../service/user.service';

@Component({
  selector: 'app-perfume-detail',
  templateUrl: './perfume-detail.component.html',
  styleUrls: [ './perfume-detail.component.css' ]
})
export class PerfumeDetailComponent implements OnInit {
  perfume: Perfume;
  role:String;

  constructor(
    private route: ActivatedRoute,
    private perfumeService: PerfumeService,
    private userService: UserService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getPerfume();
    this.role=this.userService.getUser();
}
  getPerfume(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.perfumeService.getPerfume(id)
      .subscribe(perfume => this.perfume = perfume);
  }

  save(): void {
    this.perfumeService.updatePerfume(this.perfume)
      .subscribe(() => this.goBack());
  }
  goBack(): void {
    this.location.back();
  }
}