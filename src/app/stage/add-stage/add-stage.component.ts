import { Component, OnInit } from '@angular/core';
import { StageService } from '../../service/stage.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../model/user';
import { UserService } from 'src/app/service/user.service';
import { Observable, of } from 'rxjs';
import { Stage } from 'src/app/model/stage';

@Component({
  selector: 'app-add-stage',
  templateUrl: './add-stage.component.html',
  styleUrls: ['./add-stage.component.scss']
})
export class AddStageComponent implements OnInit {
  successMessage: string = '';
  formData: FormGroup;
  selectedFile: File | null = null;
  users: User[] = [];
  userId: number | null = null; // Add userId variable

  constructor(
    public crudApi: StageService,
    public fb: FormBuilder,
    public toastr: ToastrService,
    private router: Router,
    private userService: UserService,
    private stageService: StageService,

  ) { }

  ngOnInit() {
    this.infoForm();
    this.getUsers();
    this.getUserId();
  
    if (this.crudApi.choixmenu === 'M' && this.crudApi.formData) {
      this.formData.patchValue(this.crudApi.formData.value);
    }
  }
  
 
  infoForm() {
    this.formData = this.fb.group({
      id: null,
      nom_entreprise: ['', [Validators.required]],
      titreStage: ['', [Validators.required]],
      description: ['', [Validators.required]],
      dateIncident: ['', [Validators.required]],
      lieuIncident: ['', [Validators.required]],
      equipementComposant: ['', [Validators.required]],
      dommagesMateriels: ['', [Validators.required]],
      graviteIncident: ['', [Validators.required]],
      facteursContributifs: ['', [Validators.required]],
      actionCorrective: ['', [Validators.required]],
      imageRapport: ['null', [Validators.required]],
      userId: [null, Validators.required] // Include userId in the form
    });
  }
  
  getUsers() {
    this.userService.getAll().subscribe(
      (users: User[]) => {
        this.users = users;
      },
      error => {
        console.error('Error fetching users:', error);
      }
    );
  }

  getUserId() {
    const loggedInUserId = this.userService.getLoggedInUserId(); // Assuming you have a method to get the ID of the logged-in user
    if (loggedInUserId) {
      this.userId = loggedInUserId;
      this.formData.patchValue({ userId: loggedInUserId }); // Set the userId in the form
    }
  }

  onSubmit() {
    if (this.formData.valid) {
      const formData = this.formData.value;
      const userId = formData.userId;
      delete formData.userId;
  
      if (this.crudApi.choixmenu === 'A') {
        // Add new incident report
        this.stageService.addData(formData, userId).subscribe(
          (response) => {
            this.toastr.success('Stage added successfully.', 'Success');
            this.router.navigate(['/stages']);
          },
          (error) => {
            console.error('Error adding stage:', error);
            this.toastr.error('Failed to add stage', 'Error');
          }
        );
      } else if (this.crudApi.choixmenu === 'M' && formData.id) {
        // Modify existing incident report
        this.stageService.updatedata(formData.id, formData, userId).subscribe(
          (response) => {
            this.toastr.success('Stage updated successfully.', 'Success');
            this.router.navigate(['/stages']);
          },
          (error) => {
            console.error('Error updating stage:', error);
            this.toastr.error('Failed to update stage', 'Error');
          }
        );
      }
    } else {
      this.toastr.error('Please fill out all required fields.', 'Error');
    }
  }
  
  lister() {
    this.router.navigate(['/stages']);
  }
  selectData(item: Stage) {
    // Populate form with selected item's data for modification
    this.formData.patchValue({
      id: item.id,
      nom_entreprise: item.nom_entreprise,
      titreStage: item.titreStage,
      description: item.description,
      dateIncident: item.dateIncident,
      lieuIncident: item.lieuIncident,
      equipementComposant: item.equipementComposant,
      dommagesMateriels: item.dommagesMateriels,
      graviteIncident: item.graviteIncident,
      facteursContributifs: item.facteursContributifs,
      actionCorrective: item.actionCorrective,
      imageRapport: item.imageRapport,
      userId: item.userId // Assuming userId is also part of the item data
    });
  }


}
