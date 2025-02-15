import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StageQRQC } from '../model/stageQRQC';

@Injectable({
  providedIn: 'root'
})
export class StageQRQCService {
  private apiUrl = '/api/stageqrqc';

  constructor(private http: HttpClient) { }

  getAll(): Observable<StageQRQC[]> {
    return this.http.get<StageQRQC[]>(this.apiUrl);
  }

  getById(id: number): Observable<StageQRQC> {
    return this.http.get<StageQRQC>(`${this.apiUrl}/${id}`);
  }

  create(stageQRQC: StageQRQC): Observable<StageQRQC> {
    return this.http.post<StageQRQC>(this.apiUrl, stageQRQC);
  }
  
  
  update(id: number, stageQRQC: StageQRQC): Observable<StageQRQC> {
    return this.http.put<StageQRQC>(`${this.apiUrl}/${id}`, stageQRQC);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
