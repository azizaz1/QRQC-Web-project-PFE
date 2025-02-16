import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormulaireService } from 'src/app/service/formulaire.service';

@Component({
  selector: 'app-formulaire',
  templateUrl: './formulaire.component.html',
  styles: [
  ]
})
export class FormulaireComponent implements OnInit {
  submitted = false;
  userFile: any;
    event: any;

  imagePath: any;
  imgURL: string | ArrayBuffer | null;
  
  constructor(public crudApi: FormulaireService ,public fb: FormBuilder,public toastr: ToastrService,
    private router : Router) { }
    
  ngOnInit() {
  
   
    this.infoForm();
   }

   get f() { return this.crudApi.formData.controls; }

  
  infoForm() {
    this.crudApi.formData = this.fb.group({
        id: null,
        nom_prenom: ['', [Validators.required]],
        mail: ['', [Validators.required]],
        specialité: ['', [Validators.required]],
        dossier: ['', [Validators.required]]

        
        });
    }
   
  

  onReset() {
    this.submitted = false;
      this.crudApi.formData.reset();
  }
  onSubmit() {
    
    this.submitted = true;
    const val = this.crudApi.formData.value;
   if (val.password == val.pwdd)
   {
      if (this.crudApi.choixmenu == "A")
      {
        this.addData();
      }
      else
      {
       this.updateData()
      }
    }
    else
    {
      this.toastr.warning( 'Vérifiet votre de passe ...');  
    }
}
  
   

addData() {
    this.crudApi.createData(this.crudApi.formData.value).
    subscribe( data=>{
    
    this.toastr.success( 'inscrit Faite avec Success'); 
    this.router.navigate(['/stagy']);
  });
}

  updateData()
  {
  
    this.crudApi.updatedata(this.crudApi.formData.value.id,this.crudApi.formData.value).
    subscribe( data => {
      this.toastr.success( 'Modification Faite avec Success');

      //this.router.navigate(['/users']);
    });
  }
  onSelectFile(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.userFile = file;
      // this.f['profile'].setValue(file);

      var mimeType = event.target.files[0].type;
      if (mimeType.match(/image\/*/) == null) {
        this.toastr.success('Only images are supported.');

        return;
      }
      var reader = new FileReader();
      this.imagePath = file;
      reader.readAsDataURL(file);
      reader.onload = (_event) => {
        this.imgURL = reader.result;
      }
    }
  }
}