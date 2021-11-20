import { TrainerService } from 'src/app/services/trainer.service';
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

  isTrainerListEmpty!: boolean;

  emptyObject!: any;

  emptyTeamPokemon: any[] = []

  indexDetails!: number

  detailsPokemon: any;

  alertTrainer: boolean;

  alertPokemon: boolean;

  pokemonToAdd: any;

  typeListCheck!: any[];

  teamCompleted: boolean = false;

  pokemonAdded: boolean = false;



  constructor(
    private PokemonService: PokemonService, private trainerService: TrainerService
  ) {

    this.trainerList = [new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer("Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png")]

    this.emptyObject = {
      name: "-",
      imageUrl: "../../../assets/img/Level_Ball_battle_V.png"
    }

    this.emptyTeamPokemon = [{name: "-",
    imageUrl: "../../../assets/img/Level_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Luxury_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Quick_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Safari_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Ultra_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Master_Ball_battle_V.png"}]

    this.pictureSelected = "../../../assets/img/silueta-trainer.png"


    this.alertTrainer = false;

    this.alertPokemon = false;
  }


  ngOnInit(): void {
    this.getAllTrainers();
    this.getPokemons();
    this.getAllPokemons();
    this.detailsPokemonOpen = false
    this.teamPokemon = [{name: "-",
    imageUrl: "../../../assets/img/Level_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Luxury_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Quick_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Safari_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Ultra_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Master_Ball_battle_V.png"}]

    this.alertTrainer = false;
    this.alertPokemon = false;

  }

  openDetails(pokemonName: string, index: number){
    this.indexDetails = index;
    if(this.detailsPokemonOpen === true && pokemonName === this.detailsPokemon.name){

      this.detailsPokemonOpen = false;

    } else if(this.detailsPokemonOpen === false ){

      this.detailsPokemonOpen = true
      this.PokemonService.getPokemonDetails(pokemonName).subscribe((response: any)=>{

        this.detailsPokemon = response
        console.log(this.detailsPokemon)
          })

    } else if(this.detailsPokemonOpen === true && pokemonName !== this.detailsPokemon.name){
      this.PokemonService.getPokemonDetails(pokemonName).subscribe((response: any)=>{

        this.detailsPokemon = response
        console.log(this.detailsPokemon)
          })
    }
  }

  addPokemonCheck():void{

    if(this.trainerInput == ""){
      this.alertTrainer = true;
    }

    if(this.selectedPokemon === undefined){
      this.alertPokemon = true;
    } else{
      this.alertPokemon = false;
    }

    console.log(this.selectedPokemon)


    // if(this.trainerInput == ""){
    //   this.alertTrainer = true;
    // } else {
    //   this.alertTrainer = false;
    // }

    // console.log(this.selectedPokemon == undefined)


    // if(this.selectedPokemon == undefined){
    //   this.alertPokemon = true;
    // } else {
    //   this.alertPokemon = false;
    // }



    console.log(this.teamPokemon)
    for (let index = 0; index < this.teamPokemon.length; index++) {

      if(this.teamPokemon[index].name !== "-"){
        this.teamCompleted = true;
        this.pokemonAdded = false;
      }else{
        this.teamCompleted = false
      }

    }
    console.log(this.teamPokemon)
    if(this.teamCompleted === false && this.selectedPokemon !== undefined && this.trainerInput !== ""){
      this.addPokemon();
      this.pokemonAdded = true;
    }

    console.log(this.teamCompleted)


  }

  addPokemon(): void{


    console.log(this.teamPokemon)
    console.log(this.selectedPokemon)
    console.log(this.trainerInput)





    // if(this.selectedPokemon.types.length === 1){
    //   console.log(this.selectedPokemon.types[0].type.name)
    //   this.typeListCheck.push(this.selectedPokemon.types[0].type.name)

    // } else {
    //   this.typeListCheck.push(this.selectedPokemon.types[0].type.name)
    //   this.typeListCheck.push(this.selectedPokemon.types[1].type.name)
    // }

    if(this.selectedPokemon !== undefined){

      if(this.selectedPokemon.types.length === 1){
        this.pokemonToAdd = {
          name: this.selectedPokemon.name,
          imageUrl: this.selectedPokemon.sprites.front_default,
          typeList: [this.selectedPokemon.types[0].type.name],
          statsList: [{ name: this.selectedPokemon.stats[0].stat.name, value:  this.selectedPokemon.stats[0].base_stat}, { name: this.selectedPokemon.stats[1].stat.name, value:  this.selectedPokemon.stats[1].base_stat}]
        }

      }

      if(this.selectedPokemon.types.length !== 1){
        this.pokemonToAdd = {
          name: this.selectedPokemon.name,
          imageUrl: this.selectedPokemon.sprites.front_default,
          typeList: [this.selectedPokemon.types[0].type.name, this.selectedPokemon.types[1].type.name],
          statsList: [{ name: this.selectedPokemon.stats[0].stat.name, value:  this.selectedPokemon.stats[0].base_stat}, { name: this.selectedPokemon.stats[1].stat.name, value:  this.selectedPokemon.stats[1].base_stat}]
        }

      }





    console.log(this.pokemonToAdd.typeList)


    this.PokemonService.addPokemon(this.trainerInput, this.pokemonToAdd).subscribe((responsePost: any)=>{

      console.log(responsePost)
      this.PokemonService.getTeam(this.trainerInput).subscribe((response: any)=>{
        console.log(response)

        this.teamPokemon = [{name: "-",
    imageUrl: "../../../assets/img/Level_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Luxury_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Quick_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Safari_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Ultra_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Master_Ball_battle_V.png"}]


        for (let index = 0; index < response.length; index++) {
          this.teamPokemon.splice(index, 1, response[index]);
        }


        this.teamPokemon.splice((response.length + 1) , responsePost)
        console.log(this.teamPokemon)
      })

    })

  }


  }


  selectTrainer(): void{

    this.alertTrainer = false;
    // this.alertPokemon = false;
    this.teamCompleted = false;
    this.pokemonAdded = false;


    console.log(this.trainerInput)

    this.teamPokemon = [{name: "-",
    imageUrl: "../../../assets/img/Level_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Luxury_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Quick_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Safari_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Ultra_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Master_Ball_battle_V.png"}]

    this.getTeam(this.trainerInput)

    for (let index = 0; index < this.trainerList.length; index++) {
      if(this.trainerInput === this.trainerList[index].name){
        this.pictureSelected = this.trainerList[index].picture
      }
    }
    console.log(this.teamCompleted)

    this.detailsPokemonOpen = false

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

    console.log(this.pokemonInputValue)

    this.PokemonService.getPokemonDetails(pokemon).subscribe((response: any)=>{

      this.selectedPokemon = response
      console.log(this.selectedPokemon)
        })

    this.alertPokemon = false;
  }


  searcher(): void{
    this.searchPokemons = []

    console.log(this.searcherInput)

    this.getAllPokemons();

    this.pokemonsMatch = this.allPokemons.filter(pokemon => pokemon.includes(this.searcherInput.toLowerCase()))

    this.allPokemons = []

    if(this.searcherInput === ""){
      this.pokemonsMatch = []
      this.selectedPokemon = "";
    }

    if(this.searcherInput.toLowerCase() === this.pokemonsMatch[0]){
      this.PokemonService.getPokemonDetails(this.pokemonsMatch[0]).subscribe((response: any)=>{

        this.selectedPokemon = response
        console.log(this.selectedPokemon)
          })

    }

    if(this.selectedPokemon !== undefined){
      this.alertPokemon = false;
    }


  }

  getAllPokemons(): void{

    this.PokemonService.getAllPokemons().subscribe((response: any)=>{

      for (let index = 0; index < response.count; index++) {
        this.allPokemons.push(response.results[index].name)

      }

    })
  }

  getTeam(trainer: string): void{
    console.log(this.teamPokemon)
    console.log(trainer)
    this.PokemonService.getTeam(trainer).subscribe((response: any)=>{
      console.log(response)

      for (let index = 0; index < response.length; index++) {
        this.teamPokemon.splice(index, 1, response[index]);
      }
      console.log(this.teamPokemon)
    })


  }


  deletePokemon(id: number, index: number): void{
    console.log(this.teamPokemon)
    console.log(this.emptyTeamPokemon)
    console.log(id)
    console.log(index)

    this.PokemonService.deletePokemon(id).subscribe((deleteResponse: any)=>{
      this.PokemonService.getTeam(this.trainerInput).subscribe((response: any)=>{
        console.log(response)

        this.teamPokemon = [{name: "-",
    imageUrl: "../../../assets/img/Level_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Luxury_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Quick_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Safari_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Ultra_Ball_battle_V.png"}, {name: "-",
    imageUrl: "../../../assets/img/Master_Ball_battle_V.png"}]


        for (let index = 0; index < response.length; index++) {
          this.teamPokemon.splice(index, 1, response[index]);
        }
        console.log(this.teamPokemon)
      })

    })

  }


  getAllTrainers(){
    this.trainerService.getTrainers().subscribe({
      next: dataResult => {
        this.trainerList = dataResult;
        if (this.trainerList.length == 0) {
          this.isTrainerListEmpty = true;
        } else {
          this.isTrainerListEmpty = false;
        }
      }
      ,
      error: error => {
        console.error("Ther was an error!", error);
      }
    })
  }


  }
