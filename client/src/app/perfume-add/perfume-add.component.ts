import { Component, OnInit,ViewChild  } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { PerfumeService }  from '../service/perfume.service';
import { BrandService } from '../service/brand.service';

import { Perfume } from '../entities/perfume';
import { Brand } from '../entities/brand';

@Component({
  selector: 'app-perfume-detail',
  templateUrl: './perfume-add.component.html',
  styleUrls: [ './perfume-add.component.css' ]
})
export class PerfumeAddComponent implements OnInit {
  brands: Object[];
   @ViewChild("image")
  image: any;
  base64Image:String="";
  perfume={};

  constructor(
    private route: ActivatedRoute,
    private perfumeService: PerfumeService,
    private brandService: BrandService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getBrands();
  }
   getBrands(): void {
    this.brandService.getBrands()
    .subscribe(brands => this.brands = brands);
  }

  public imageChoosed(event:any){
    let reader  = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
  reader.onloadend = (e) => {
  this.image.nativeElement.src=reader.result;
  }
  }
  addPerfume(){
    /*let final_data;
        if (this.image) {
            //let image: FileList = this.image;
            const formData = new FormData();
            /*for (let i = 0; i < image.length; i++) {
                formData.append('image', image[i]);
            }
            formData.append('image',this.image.nativeElement.src);
            final_data = formData;
        } else {
            //Если нет файла, то слать как обычный JSON
            final_data = this.perfume;
        }*/
    this.perfumeService.addPerfume(this.perfume);
  }

  handleFileSelect(evt){
      var files = evt.target.files;
      var file = files[0];

    if (files && file) {
        var reader = new FileReader();

        reader.onload =this._handleReaderLoaded.bind(this);

        reader.readAsBinaryString(file);
    }
  }



  _handleReaderLoaded(readerEvt) {
     var binaryString = readerEvt.target.result;
      this.base64Image= btoa(binaryString);
    }

  goBack(): void {
    this.location.back();
  }
}