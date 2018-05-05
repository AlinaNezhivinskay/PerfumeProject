import { Brand }     from './brand';
import { PerfumeCondition }     from './condition';

export class Perfume {
  id: number;
  name: string;
  image: string;
  type: string;
  brand: string;
  releaseYear: number;
  
  weather:string;
  temperature:number;
  daytime:string;
}