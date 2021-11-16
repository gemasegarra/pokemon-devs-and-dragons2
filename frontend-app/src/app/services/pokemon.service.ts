import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  //Obtiene pokemon
  getPokemons(){
    return this.http.get(`https://pokeapi.co/api/v2/pokemon`);
  }

  getPokemonDetails(name: string){
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${name}`);
  }
  
}
