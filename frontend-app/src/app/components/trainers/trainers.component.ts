import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Trainer } from '../../models/trainer.model';

@Component({
  selector: 'app-trainers',
  templateUrl: './trainers.component.html',
  styleUrls: ['./trainers.component.css']
})
export class TrainersComponent implements OnInit {

  trainerList: Trainer[]
  hobbiesList: string[]
  pictureList: string[]

  registerForm: FormGroup;
  nameInput: FormControl;
  ageInput: FormControl;
  hobbyInput: FormControl;
  pictureInput: FormControl;


  constructor() {
    this.trainerList = [new Trainer(0,"Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer(1,"Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer(2,"Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer(3,"Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png"),
    new Trainer(4,"Rubén", 18, "Champion","https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png")]

    this.hobbiesList= ["Bugcatcher", "Blackbelt", "Picnicker", "Champion", "Hiker", "Fisherman", "Scientist", "Swimmer", "Pokemaniac", "Cooltrainer" ]
    this.pictureList = ["https://cdn2.bulbagarden.net/upload/5/55/Red_Blue_Bug_Catcher.png", "https://cdn2.bulbagarden.net/upload/8/81/XY_Black_Belt.png", "https://cdn2.bulbagarden.net/upload/2/22/ORAS_Picnicker.png",
    "https://cdn2.bulbagarden.net/upload/thumb/8/83/FireRed_LeafGreen_Red.png/278px-FireRed_LeafGreen_Red.png", "https://cdn2.bulbagarden.net/upload/6/6b/Ruby_Sapphire_Hiker.png","https://cdn2.bulbagarden.net/upload/f/fc/ORAS_Fisherman.png",
    "https://cdn2.bulbagarden.net/upload/d/d0/XY_Scientist_F.png", "https://cdn2.bulbagarden.net/upload/3/39/XY_Swimmer_M.png", "https://cdn2.bulbagarden.net/upload/3/32/ORAS_Pok%C3%A9_Maniac.png",
    "https://cdn2.bulbagarden.net/upload/6/6f/XY_Ace_Trainer_F.png"]

    this.nameInput = new FormControl("", [Validators.required]);
    this.ageInput = new FormControl("", [Validators.required]);
    this.hobbyInput = new FormControl("", [Validators.required]);
    this.pictureInput = new FormControl("", [Validators.required]);

    this.registerForm = new FormGroup({
      name: this.nameInput,
      age: this.ageInput,
      hobby: this.hobbyInput,
      picture: this.pictureInput
    })


   }

  ngOnInit(): void {
  }


  onSubmit(): void{
    console.log("Creating trainer")
    console.log(this.registerForm.value)
  }

  selectPicture(): void{
    for (let index = 0; index < this.hobbiesList.length; index++) {
      if(this.hobbyInput.value == this.hobbiesList[index])
        this.pictureInput.setValue(this.pictureList[index])
    }
  }

  deleteTrainer(): void{
    console.log("Deleting trainer")
  }

}
