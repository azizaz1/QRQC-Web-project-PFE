import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';

import { StageQRQC } from '../../model/stageQRQC';
import { StageQRQCService } from 'src/app/service/stageQRQC.service';

@Component({
  selector: 'app-add-stage-qrqc',
  templateUrl: './add-stage-qrqc.component.html',
  styleUrls: ['./add-stage-qrqc.component.scss']
})
export class AddStageQRQCComponent implements OnInit {
  formData: FormGroup;
  selectedFile: File | null = null;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    
    private toastr: ToastrService,
    private stageQRQCService: StageQRQCService,
    
  ) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.formData = this.fb.group({
      id: [null],
      dateHeure: ['', [Validators.required]],
      signalePar: ['', [Validators.required]],
      departementLigne: ['', [Validators.required]],
      descriptionProbleme: ['', [Validators.required]],
      gravite: ['', [Validators.required]],
      actionImmediate: ['', [Validators.required]],
      analyseCauseRacine: ['', [Validators.required]],
      actionsCorrectives: ['', [Validators.required]],
      personneResponsable: ['', [Validators.required]],
      dateLimiteActions: ['', [Validators.required]],
      verificationActions: ['', [Validators.required]],
      actionsSuivi: ['', [Validators.required]],
      statut: ['', [Validators.required]],
      commentairesNotes: ['', [Validators.required]]
    });
  }

  resetForm() {
    this.formData.reset();
  }

  onFileSelected(event: any) {
    if (event.target.files && event.target.files.length > 0) {
      this.selectedFile = event.target.files[0];
    }
  }

  onSubmit() {
    if (this.formData.valid) {
      const formData: StageQRQC = this.formData.value;
      // Ensure that stageQRQCService.create returns an Observable
      this.stageQRQCService.create(formData).subscribe(
        (response) => {
          this.toastr.success('Stage QRQC added successfully', 'Success');
          this.router.navigate(['/stages']);
        },
        (error) => {
          console.error('Error adding stage QRQC:', error);
          this.toastr.error('Failed to add stage QRQC', 'Error');
        }
      );
    } else {
      this.toastr.error('Please fill out all required fields.');
    }
  }

  navigateToList() {
    this.router.navigate(['/stages']);
  }
}
