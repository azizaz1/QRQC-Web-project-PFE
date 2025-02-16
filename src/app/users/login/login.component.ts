import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['/add-stage.component.scss']

})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup; // Add non-null assertion operator here
  loginError: string;

  constructor(private userService: UserService, private toastr: ToastrService, private cookieService: CookieService,
              private fb: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      'username': [null, Validators.required],
      'password': [null, Validators.required]
    });
  }

  login() {
    // Check if user is already logged in
    

    if (this.loginForm.invalid) {
      return;
    }

    const username = this.loginForm.get('username')!.value;
    const password = this.loginForm.get('password')!.value;

    console.log('Attempting login with', { username, password });

    this.userService.login(username, password).subscribe(
      (user: User) => {
        if (user) {
          this.cookieService.set('token', 'dummy_token');

          //localStorage.setItem('loggedInUser', JSON.stringify(user)); // Store user data in local storage
          this.toastr.success('Login successful');
          localStorage.setItem('username', username);
          localStorage.setItem('password', password);

          this.router.navigate(['/stages']);
        } else {
          this.loginError = 'Invalid username or password';
        }
      },
      (error) => {
        console.error('Login failed:', error);
        this.loginError = 'Invalid username or password';
      }
    );
  }

  register() {
    this.router.navigate(['/register']);
  }
}
