import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stage} from '../model/stage';
import * as pdfMake from "pdfmake/build/pdfmake";
import * as pdfFonts from 'pdfmake/build/vfs_fonts';

(<any>pdfMake).vfs = pdfFonts.pdfMake.vfs;
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }

from '@angular/forms';
import { ParametreService } from './parametre.service';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class StageService {
  submitForm(formData: any, userId: any) {
    throw new Error('Method not implemented.');
  }
 
  getList() {
    throw new Error('Method not implemented.');
  }
  private baseUrl = '/api/stages';
  private searchUrl = '/api/search';
  //private baseUrl2 =  '/api/users';
  private baseUrl2 = 'http://localhost:8080/api/stages';

  choixmenu : string  = 'A';
  list: any[];
  public formData:  FormGroup; 
  apiUrl: any;
  constructor(private http: HttpClient,private parametreService: ParametreService) { }
 
 
  getData(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  createData(formData: any, userId: number): Observable<Object> {
    const dataWithUserId = { ...formData, userId }; // Merge userId with formData
  
    return this.http.post(`${this.baseUrl}`, dataWithUserId);
  }

  addData(formData: any, userId: number): Observable<any> {
    console.log('userId:', userId); // Log the value of userId
    // Include the userId when making the HTTP request
    return this.http.post(`${this.baseUrl}`, formData, { params: { userId: userId.toString() } });
  }
  
  
  

  updatedata(id: string, value: any, userId: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteData(id: string): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAll(): Observable<any> {
   
    return this.http.get(`${this.baseUrl}`);
  }


  searchByDescription(description: string): Observable<Stage[]> {
    return this.http.get<Stage[]>(`${this.searchUrl}/search?description=${description}`);
  }
 

  searchByDateIncident(date: Date): Observable<Stage[]> {
    return this.http.get<Stage[]>(`${this.apiUrl}/searchByDateIncident?date=${date}`);
  }
  addStage(formData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, formData);
  }
  
}