import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trainer } from '../models/trainer.model';


@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  readonly baseUrl = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  getTrainers(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(this.baseUrl + '/trainers');
  }

  deleteTrainer(name: string): Observable<any> {
    return this.http.delete(this.baseUrl + '/trainers/' + name);
  }
}
