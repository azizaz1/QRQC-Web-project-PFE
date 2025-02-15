import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { QRQC } from '../model/qrqc';

@Injectable({
  providedIn: 'root'
})
export class QRQCService {
  private searchUrl = '/api/search2';
  private searchUrl2 = '/api/searchByDateRange'; // Updated endpoint for date range search

  private baseUrl = '/api/qrqcs';
  choixmenu: string = 'A';
  list: any[];
  public formData: FormGroup;

  constructor(private http: HttpClient) { }

  getData(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  

  addData(formData: any, stageId: number): Observable<any> {
    console.log('stageId:', stageId);
    return this.http.post(`${this.baseUrl}`, formData, { params: { stageId: stageId.toString() } });
  }
  
  searchQRQC(nomPrenom: string): Observable<QRQC[]> {
    return this.http.get<QRQC[]>(`${this.searchUrl}/search2?NomPrenom=${nomPrenom}`);
  }

  updateQRQC(id: string, formData: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, formData);
  }
  createData(formData: any): Observable<Object> {
    const stageId = formData.stageId;
    const dataWithStageId = { ...formData, stageId };
    return this.http.post(`${this.baseUrl}`, dataWithStageId);
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
   // Method to search QRQC by date range
   searchQRQCByDateRange(startDate: Date, endDate: Date): Observable<QRQC[]> {
    let params = new HttpParams()
      .set('startDate', startDate.toISOString().slice(0, 10)) // Convert Date to ISO string format yyyy-MM-dd
      .set('endDate', endDate.toISOString().slice(0, 10));

    return this.http.get<QRQC[]>(`${this.searchUrl2}`, { params: params });
  }
}
