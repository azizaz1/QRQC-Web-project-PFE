import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import emailjs from 'emailjs-com';  // Import EmailJS

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: []
})
export class RegisterComponent implements OnInit {
  submitted = false;
  imgURL: any;
  pwdd: string;
  acceptTerms: string;

  constructor(
    public crudApi: UserService,
    public fb: FormBuilder,
    public toastr: ToastrService,
    private router: Router
  ) {}

  ngOnInit() {
    this.infoForm();
  }

  infoForm() {
    this.crudApi.formData = this.fb.group({
      id: null,
      username: ['', Validators.required],
      nom: ['', Validators.required],
      role: ['', Validators.required],
      email: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+$/)
        ]
      ],
      pwdd: ['', Validators.required],
      password: ['', Validators.required],
      acceptTerms: ['', Validators.required]
    });
  }

  ResetForm() {
    this.crudApi.formData.reset();
  }

  onSubmit() {
    const val = this.crudApi.formData.value;
    if (val.password === val.pwdd) {
      if (this.crudApi.choixmenu === 'A') {
        this.addData();
      } else {
        this.updateData();
      }
    } else {
      this.toastr.warning('Vérifiez votre mot de passe ...');
    }
  }

  lister() {
    this.router.navigate(['/stages']);
  }

  addData() {
    this.crudApi.createData(this.crudApi.formData.value).subscribe(data => {
      this.toastr.success('Register Faite avec Success');
      // Send a welcome email after successful registration
      this.sendWelcomeEmail(this.crudApi.formData.value.email);
      this.router.navigate(['/login']);
    });
  }

  updateData() {
    this.crudApi.updatedata(this.crudApi.formData.value.id, this.crudApi.formData.value)
      .subscribe(data => {
        this.toastr.success('Modification Faite avec Success');
        // Optionally, navigate or perform another action
      });
  }

  backtologin() {
    this.router.navigate(['/login']);
  }

  // Function to send a welcome email using EmailJS
  sendWelcomeEmail(userEmail: string) {
    // Define the template parameters here
    const templateParams = {
      to_email: this.crudApi.formData.value.email,  // User's email
      to_name: this.crudApi.formData.value.username, // User's name      subject: 'Welcome to Our Platform!',
      message: 'Welcome Sir! Thank you for registering with us.'
    };

    emailjs.send('service_cpjeraq', 'template_xll2azf', templateParams, '83updgVcuh_ACU-RW')
      .then(
        response => {
          console.log('Email sent successfully!', response.status, response.text);
        },
        error => {
          console.error('Email failed to send:', error);
        }
      );
      // Send using Outlook
emailjs.send('service_rvn8euc', 'template_xll2azf', templateParams, '83updgVcuh_ACU-RW')
.then(response => console.log('Email sent via Outlook!', response.status, response.text))
.catch(error => console.error('Outlook failed:', error));
  }
}
