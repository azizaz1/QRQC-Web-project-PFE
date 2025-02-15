import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormulaireService {

  private baseUrl = '/api/forms';
  choixmenu : string  = 'A';
  list:  any=[];

  host :string = 'http://localhost:8080';
  
  name : string = "Foulen";

  public formData:  FormGroup; 

  constructor(private http: HttpClient) { }
 
  login(username :string,pwd : string ) {
    return this.http.get(`${this.baseUrl}/auth/${username}`);
   
   } 
   
   verifEmail(email :string) {
    return this.http.get(`${this.baseUrl}/verif/${email}`);
   
   }  
  getData(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  
  createData(info: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, info);
  }
  
  updatedata(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteData(id: string): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAll(): Observable<any> {
   
    return this.http.get(`${this.baseUrl}`);
  }
  
  uploadFile(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    const req = new HttpRequest('POST', '<Server URL of the file upload>', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

}

