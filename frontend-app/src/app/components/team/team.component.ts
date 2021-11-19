import { PokemonService } from 'src/app/services/pokemon.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Trainer } from './../../models/trainer.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {


  trainerList: Trainer[]


  trainerInput: string = "";
  pokemonInputValue!: string;

  pictureSelected: string;
  pokemonSelected!: any;

  allPokemons: any[] = []
  pokemonsMatch: any[] = []
  searchPokemons: any[] = []


  teamPokemon: any[] = []


  pokemons: any[] = [];
  page = 1;
  itemsPerPage = 8;
  selectedPokemon : any;
  query: string = "";
  total: number = 0;

  searcherInput: string = ""

  detailsPokemonOpen!: boolean;

  stateZeroOne: boolean = true;



  constructor(
    private PokemonService: PokemonService
  ) {

    this.trainerList = [new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png")]

    this.teamPokemon = ['charizard', "pikachu", "bulbasaur", "moltres"]


   this.pictureSelected = "../../../assets/img/silueta-trainer.png"
  }


  ngOnInit(): void {
    this.getPokemons();
    this.getAllPokemons();
    this.detailsPokemonOpen = false
  }

  openDetails(){
    this.detailsPokemonOpen = !this.detailsPokemonOpen

  }

  addPokemon(): void{


    console.log(this.selectedPokemon)


  }

  selectTrainer(): void{
    this.pictureSelected = this.trainerInput
    console.log(this.pictureSelected)
  }

  changeColorOne(){

    this.stateZeroOne = !this.stateZeroOne;
  }


  getPokemons() {
    this.PokemonService.getPokemons(this.itemsPerPage, (this.page - 1)*this.itemsPerPage)
      .subscribe((response: any)=>{
        this.total = response.count;
        response.results.forEach((result: { name: string; }) => {
          this.PokemonService.getPokemonDetails(result.name)
            .subscribe((uniqResponse: any) =>{
              this.pokemons.push(uniqResponse);
              this.pokemons.sort(function(a, b) {
                return a.order - b.order;
              });
            });
        });
      });
  }

  visualizePokemon(pokemon: any): void{

    console.log(pokemon)



    this.pokemonInputValue = pokemon["name"]




    this.PokemonService.getPokemonDetails(pokemon).subscribe((response: any)=>{

      this.selectedPokemon = response
      console.log(this.selectedPokemon)
        })




  }


  searcher(): void{
    this.searchPokemons = []

    console.log(this.searcherInput)

    this.getAllPokemons();



    this.pokemonsMatch = this.allPokemons.filter(pokemon => pokemon.includes(this.searcherInput))

    this.allPokemons = []



    // this.pokemonsMatch.forEach(pokemon => {
    //   this.PokemonService.getPokemonDetails(pokemon).subscribe((response: any)=>{
    //     this.searchPokemons.push(response)
    //     this.searchPokemons.sort(function(a, b) {
    //       return a.id - b.id;
    //     })
    //   })
    // });



    // console.log(this.pokemons)

    // console.log(this.searchPokemons)

    if(this.searcherInput === ""){
      this.pokemonsMatch = []
    }

    if(this.searcherInput === this.pokemonsMatch[0]){
      this.PokemonService.getPokemonDetails(this.pokemonsMatch[0]).subscribe((response: any)=>{

        this.selectedPokemon = response
        console.log(this.selectedPokemon)
          })

    }


  }

  getAllPokemons(): void{

    this.PokemonService.getAllPokemons().subscribe((response: any)=>{

      for (let index = 0; index < response.count; index++) {
        this.allPokemons.push(response.results[index].name)

      }

      // console.log(this.allPokemons)

      // console.log(response.results[0].name)
    })
  }


}
