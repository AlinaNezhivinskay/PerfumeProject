 import { NoteGroup }     from './noteGroup';

export class Note {
    id: number;
    image :string;
    name: string;

    group:NoteGroup=new NoteGroup();
  }