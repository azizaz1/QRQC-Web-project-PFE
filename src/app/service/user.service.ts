import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, of, tap, throwError } from 'rxjs';
import { User} from '../model/user';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }

from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class UserService {
 

  private baseUrl = '/api/users';
  choixmenu : string  = 'A';
  list:  any=[];
  islogin = false;
  admin = false;
  suser = false;
  client = false;
  four = false;
  host :string = 'http://localhost:8080';
  name : string = "Foulen";

  public formData:  FormGroup; 
  cookieService: any;
  toastr: any;
  constructor(private http: HttpClient) { }
 
  login(username: string, password: string): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/auth/${username}?password=${password}`)
      .pipe(
        tap(user => {
          if (user) {
            localStorage.setItem('currentUser', JSON.stringify(user));
          }
        })
      );
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
  updateData(id: string, updatedData: any, newPassword?: string): Observable<Object> {
    const url = `${this.baseUrl}/${id}`;
    const value = { ...updatedData, password: newPassword }; // Include the new password in the updated data
    return this.http.put(url, value);
  }
  deleteData(id: string): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAll(): Observable<any> {
   
    return this.http.get(`${this.baseUrl}`);
  }
  
  logout(): void {
    // Clear token from local storage upon logout
    localStorage.removeItem('token');
  }
  
changePassword(id: number, currentPassword: string, newPassword: string): Observable<void> {
  const url = `${this.baseUrl}/${id}/change-password`;
  const passwordData = { currentPassword, newPassword };
  return this.http.put(url, passwordData, { responseType: 'text' })
    .pipe(
      map(() => {}), // Map the response to void
      catchError((error: any) => {
        if (error instanceof ErrorEvent) {
          console.error('An error occurred:', error.message); // Log client-side error message
        } else {
          console.error(`Backend returned code ${error.status}, body was: ${error.error}`);
        }
        return throwError('Error changing password'); // Return a generic error message
      })
    );
}
  
  
  isLoggedIn(): boolean {
    const isLoggedIn = !!localStorage.getItem('token');
    console.log('Is user logged in:', isLoggedIn);
    return isLoggedIn;
  }
  

  sendWelcomeEmail(email: string): Observable<any> {
    // Replace this with your actual email sending logic if you have a backend
    console.log(`Sending welcome email to ${email}`);
    return of({ message: 'Welcome email sent successfully' });
  }
  
  getLoggedInUser(): User | null {
    const currentUserString = localStorage.getItem('currentUser'); // Change the key to 'currentUser'
    console.log('currentUserString:', currentUserString); // Log the value of currentUserString
    if (currentUserString) {
      const user = JSON.parse(currentUserString) as User;
      console.log('Parsed user:', user); // Log the parsed user object
      return user;
    } else {
      console.log('No user found in local storage');
      return null;
    }
  }
  
  
  getLoggedInUserId(): number | null {
    const loggedInUser = this.getLoggedInUser();
    return loggedInUser ? loggedInUser.id : null;
  }
  setCookieToken(username: string): void {
    // Generate a unique token for the user
    const token = this.generateToken(username);

    // Set the token in the cookie with an expiration date (e.g., 1 hour)
    const expirationDate = new Date();
    expirationDate.setHours(expirationDate.getHours() + 1); // Expires in 1 hour
    this.cookieService.set(username, token, expirationDate);
}
  private generateToken(username: string): string {
    // Generate a random token based on the username (this is just a simple example)
    return 'token_' + username;
  }


}
