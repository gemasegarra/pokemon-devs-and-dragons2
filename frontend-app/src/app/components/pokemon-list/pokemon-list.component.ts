import { Component, OnInit} from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';
import { PokemonDetailComponent } from '../pokemon-detail/pokemon-detail.component';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {
  pokemons: any[] = [];
  page = 1;
  selectedPokemon : any;

  @Output() selectPokemon = new EventEmitter<string>();

  constructor(
    private PokemonService: PokemonService
  ) { }

  ngOnInit(): void {
    this.PokemonService.getPokemons()
      .subscribe((response: any)=>{

        response.results.forEach((result: { name: string; }) => {
          this.PokemonService.getPokemonDetails(result.name)
            .subscribe((uniqResponse: any) =>{
              this.pokemons.push(uniqResponse);
              this.pokemons.sort(function(a, b) {
                return a.order - b.order;
            });
              console.log(this.pokemons);
            });
        });
      });
  }

}