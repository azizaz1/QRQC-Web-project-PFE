import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from '../service/user.service';
import { ToastrService } from 'ngx-toastr';
import { containerAnimation } from '../container.animations';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
  animations: [containerAnimation]


})
export class MenuComponent implements OnInit {
  
  loggedInUsername: string | null;
  loggedInUserId: number | null;

  constructor(
    private router: Router,
    private cookieService: CookieService,
    private userService: UserService,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    const loggedInUser = this.userService.getLoggedInUser();
    if (loggedInUser) {
      this.loggedInUsername = localStorage.getItem('username');

      //this.loggedInUsername = loggedInUser.username;
      this.loggedInUserId = loggedInUser.id;
    } else {
      this.loggedInUsername = localStorage.getItem('username');
      this.loggedInUserId = this.userService.getLoggedInUserId();
    }
  }

  logout() {
    // Clear user details from localStorage
    localStorage.removeItem('loggedInUser');
    localStorage.removeItem('username');
    localStorage.removeItem('password');
    this.cookieService.delete('token');
  
    // Redirect the user to the login page
    this.router.navigate(['/login']);
    this.toastr.success('Logged out successfully');
  }
  

  navigateToChangePassword(): void {
    if (this.loggedInUserId !== null) {
      this.router.navigate(['/change-password', this.loggedInUserId]);
    } else {
      console.error('User ID is not available.');
    }
  }
}
