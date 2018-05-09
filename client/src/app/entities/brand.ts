import {Country} from '../entities/country'

export class Brand {
  id: number;
  name: string;
  site: string;

  country:Country=new Country();
}