import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  changePasswordForm: FormGroup;
  error: string | null = null;
  id: number | null = null;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private router: Router // Inject Router service

  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id !== null) {
        this.id = +id; // Convert to number and assign to userId
      } else {
        // Handle the case where the ID is null
        this.error = 'User ID not found';
      }
    });

    this.changePasswordForm = this.formBuilder.group({
      currentPassword: ['', Validators.required],
      newPassword: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (!this.changePasswordForm) {
      return;
    }
    if (this.changePasswordForm.invalid) {
      return;
    }
    const currentPassword = this.changePasswordForm.get('currentPassword')?.value;
    const newPassword = this.changePasswordForm.get('newPassword')?.value;

    if (!currentPassword || !newPassword) {
      return;
    }

    if (this.id !== null) {
      this.userService.changePassword(this.id, currentPassword, newPassword).subscribe(
        () => {
          this.toastr.success('Password changed successfully');
          this.router.navigate(['/stages']); // Navigate to the '/stages' route
        },
        (error) => {
          console.error('Error changing password:', error);
          this.toastr.error('Error changing password'); // Display error message
        }
      );}}}
