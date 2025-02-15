import { Component, OnInit } from '@angular/core';
import { StageService } from '../../service/stage.service';
import { ToastrService } from 'ngx-toastr';
import { Stage } from '../../model/stage';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { FormBuilder }
  from '@angular/forms'
@Component({
  selector: 'app-list-stage',
  templateUrl: './stage.component.html',
  styles: [
  ]
})
export class StageComponent implements OnInit {
  stage: Stage;

  constructor(public crudApi: StageService, public toastr: ToastrService,
    private router: Router, public fb: FormBuilder
    ) { }


  ngOnInit() {

    this.getData();
  }

  getData() {
    this.crudApi.getAll().subscribe(
      response => {
        this.crudApi.list = response;
      }
    );
  }

  removeData(id: string) {
    if (window.confirm('Are sure you want to delete this Catégorie ?')) {
      this.crudApi.deleteData(id)
        .subscribe(
          data => {
            console.log(data);
            this.toastr.warning(' data successfully deleted!');
            this.getData();
          },
          error => console.log(error));
    }
  }
  selectData(item: Stage) {
    this.crudApi.choixmenu = "M";
    this.crudApi.formData = this.fb.group(Object.assign({}, item));
    this.router.navigate(['/stage']);
  }
  addStage(){
    this.crudApi.choixmenu = "A";
    this.router.navigate(['/stage']);

  }

  
  
}