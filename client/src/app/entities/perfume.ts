import { Brand }     from './brand';
import { PerfumeCondition }     from './condition';
import { NotePyramide }     from './notePyramide';

export class Perfume {
  id: number;
  name: string;
  image: string;
  type: string;
  brand: Brand=new Brand();
  releaseYear: number;
  
  condition: PerfumeCondition=new PerfumeCondition();

  notePyramide:NotePyramide[]=new Array();
}