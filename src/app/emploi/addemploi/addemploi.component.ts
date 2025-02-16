import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable, of } from 'rxjs';
import { Stage } from 'src/app/model/stage';
import { QRQCService } from 'src/app/service/qrqc.service';
import { StageService } from 'src/app/service/stage.service';

@Component({
  selector: 'app-addemploi',
  templateUrl: './addemploi.component.html',
  styles: []
})
export class AddemploiComponent implements OnInit {
  activeTab: number = 0;
  formDataTabs: FormGroup[] = [];
  stages: Stage[] = [];
  stageId: number | null = null;
  formData: FormGroup; // Use FormGroup type
  stageIdControl: FormControl;


  constructor(
    public crudApi: QRQCService,
    public fb: FormBuilder,
    public toastr: ToastrService,
    private stageService: StageService,
    private qrqcService: QRQCService,

    private router: Router
  ) { }

  ngOnInit() {
    this.initializeFormTabs();
    this.fetchAllStageData(); // Call getStages() when the component initializes
    this.stageIdControl = this.fb.control('', Validators.required); // Initialize stageIdControl
    this.formData = this.fb.group({
      stageIdControl: this.stageIdControl,
      // Add other form controls for the tabs here
    });
  }

  initializeFormTabs() {
    for (let i = 0; i < 10; i++) {
      if (i === 0) {
        this.formDataTabs.push(this.createD1FormGroup());
      } else if (i === 1) {
        this.formDataTabs.push(this.createD2FormGroup());
      } else if (i === 2) {
        this.formDataTabs.push(this.createD3FormGroup());
      } else if (i === 3) {
        this.formDataTabs.push(this.createD4FormGroup()); // Create form group for D4
      } else if (i === 4) {
        this.formDataTabs.push(this.createD5FormGroup()); // Create form group for D5
      } else if (i === 5) {
        this.formDataTabs.push(this.createD6FormGroup()); // Create form group for D6
      } else {
        this.formDataTabs.push(this.createEmptyFormGroup());
      }
    }
  }

  createD1FormGroup(): FormGroup {
    return this.fb.group({
      id: null,
      nomPrenom: ['', Validators.required],
      responsable: ['', Validators.required],
      date: new Date(),
      produit: ['', Validators.required],
      ref: ['', Validators.required],
      tracabilite: ['', Validators.required],
      problemDescription: ['', Validators.required],
      quantiteisole: [null, Validators.required],
      nbrPieceDefaut: [null, Validators.required],
      niveau: ['', Validators.required],
      //stageId: [null, Validators.required], // Include userId in the form

    });
  }

  createD2FormGroup(): FormGroup {
    return this.fb.group({
      quoi: ['', Validators.required],
      qui: ['', Validators.required],
      combien: ['', Validators.required],
      quand: ['', Validators.required],
      qu: ['', Validators.required],
      comment: ['', Validators.required],
      pourquoi: ['', Validators.required]
    });
  }

  createD3FormGroup(): FormGroup {
    return this.fb.group({
      isolationEmplacement: ['', Validators.required],
      isolationDetails: ['', Validators.required],
      isolationDate: ['', Validators.required],
      isolationOuiNon: [false],
      repassageEmplacement: ['', Validators.required],
      repassageDetails: ['', Validators.required],
      repassageDate: ['', Validators.required],
      repassageOuiNon: [false],
      alerteProcessEmplacement: ['', Validators.required],
      alerteProcessDetails: ['', Validators.required],
      alerteProcessDate: ['', Validators.required],
      alerteProcessOuiNon: [false],
      alerteMaintenanceEmplacement: ['', Validators.required],
      alerteMaintenanceDetails: ['', Validators.required],
      alerteMaintenanceDate: ['', Validators.required],
      alerteMaintenanceOuiNon: [false],
      alerteFournisseurEmplacement: ['', Validators.required],
      alerteFournisseurDetails: ['', Validators.required],
      alerteFournisseurDate: ['', Validators.required],
      alerteFournisseurOuiNon: [false],
      changementLotEmplacement: ['', Validators.required],
      changementLotDetails: ['', Validators.required],
      changementLotDate: ['', Validators.required],
      changementLotOuiNon: [false],
      dtcOuvertEmplacement: ['', Validators.required],
      dtcOuvertDetails: ['', Validators.required],
      dtcOuvertDate: ['', Validators.required],
      dtcOuvertOuiNon: [false],
      traitementAlerteDetails: ['', Validators.required],
      traitementAlerteDate: ['', Validators.required],
      traitementAlerteDetails2: ['', Validators.required],

    });
  }

  createD4FormGroup(): FormGroup {
    return this.fb.group({
      p1CauseNonDetection: ['', Validators.required],
      p1CauseOccurrence: ['', Validators.required],
      p2CauseNonDetection: ['', Validators.required],
      p2CauseOccurrence: ['', Validators.required],
      p3CauseNonDetection: ['', Validators.required],
      p3CauseOccurrence: ['', Validators.required],
      p4CauseNonDetection: ['', Validators.required],
      p4CauseOccurrence: ['', Validators.required],
      p5CauseNonDetection: ['', Validators.required],
      p5CauseOccurrence: ['', Validators.required],

    });
  }

  createD5FormGroup(): FormGroup {
    return this.fb.group({
      actions1: ['', Validators.required],
      actions2: ['', Validators.required],
      actions3: ['', Validators.required],
      actions4: ['', Validators.required],
      corrective1: ['', Validators.required],
      corrective2: ['', Validators.required],
      corrective3: ['', Validators.required],
      corrective4: ['', Validators.required],
      preventive1: ['', Validators.required],
      preventive2: ['', Validators.required],
      preventive3: ['', Validators.required],
      preventive4: ['', Validators.required],
      actionCloturee1: [false],
      actionCloturee2: [false],
      actionCloturee3: [false],
      actionCloturee4: [false],
      pilote1: ['', Validators.required],
      pilote2: ['', Validators.required],
      pilote3: ['', Validators.required],
      pilote4: ['', Validators.required],
    });
  }

  createD6FormGroup(): FormGroup {
    return this.fb.group({
      quantiteProduitAvant: [null, Validators.required],
      quantiteDefectueuseAvant: [null, Validators.required],
      quantiteProduitApres: [null, Validators.required],
      quantiteDefectueuseApres: [null, Validators.required],
      cloturisationPourcentage: ['', Validators.required],
      qrqcNonCloture: [false],
      qrqcNonEscalade: [false]
    });
  }

  createEmptyFormGroup(): FormGroup {
    return this.fb.group({});
  }

  switchTab(index: number) {
    this.activeTab = index;
  }
  submitForm(): Observable<any> {
    if (this.formData.valid) {
      const formData = this.formData.value;
      const stageId = formData.userId; // Ensure userId is properly assigned
  
      return this.stageService.createData(formData, stageId);
    }
    return of(); // Return an empty observable if form is invalid
  }

  addQRQCData(formData: any, stageId: number): void {
    this.qrqcService.addData(formData, stageId).subscribe(
      (response) => {
        // Handle successful response
        this.toastr.success(response.message, 'Success');
        this.router.navigate(['/emplois']);
      },
      (error) => {
        // Handle error
        console.error('Error adding QRQC data:', error);
        this.toastr.error('Failed to add QRQC data', 'Error');
      }
    );
  }
  
  
  fetchAllStageData() {
    this.stageService.getAll().subscribe(
      (stages: Stage[]) => {
        this.stages = stages;
      },
      error => {
        console.error('Error fetching stages:', error);
      }
    );
  }

  onSubmit() {
    const stageId = this.stageIdControl.value;
  
    // Validate stageId
    if (!stageId) {
      this.toastr.error('Please select a stage');
      return;
    }
  
    const formData = this.getFormData();
    formData.stageId = stageId; // Include stageId in formData
  
    // Call the service method to add QRQC data
    this.addQRQCData(formData, stageId);
  }
  
  private getFormData(): any {
    let formData = {};
    for (let form of this.formDataTabs) {
      formData = { ...formData, ...form.value };
    }
    return formData;
  }
  
  
  
  addData(form: FormGroup) {
    const formData = this.getFormData();
    this.crudApi.createData(formData).subscribe(
      () => {
        this.toastr.success('Data added successfully', 'Success!');
        this.router.navigate(['/emplois']);
      },
      (error) => {
        console.error('Error adding data:', error);
        this.toastr.error('Failed to add data', 'Error');
      }
    );
  }
  
  updateData(form: FormGroup) {
    this.crudApi.updatedata(form.value.id, form.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['/emplois']);
      });
  }
  
  
  
  
  
  lister() {
    this.router.navigate(['/emplois']);
  }

  
 
}
