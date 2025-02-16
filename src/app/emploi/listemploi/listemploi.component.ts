import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { QRQC } from '../../model/qrqc';
import { QRQCService } from 'src/app/service/qrqc.service';
import { Router } from '@angular/router';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
const pdfMake = require('pdfmake/build/pdfmake.js');
import * as pdfFonts from 'pdfmake/build/vfs_fonts';

(<any>pdfMake).vfs = pdfFonts.pdfMake.vfs;
@Component({
  selector: 'app-listemploi',
  templateUrl: './listemploi.component.html',
  styles: []
})
export class ListemploiComponent implements OnInit {
  qrqcs: QRQC[] = [];
  searchForm: FormGroup;
  searchQuery: string = '';
  filteredItems: any[] = [];
  //filteredItems: QRQC[] = [];
  searchResults: QRQC[] = [];
  startDate: Date;
  endDate: Date;

  @ViewChild('table') table: ElementRef;

  constructor(public crudApi: QRQCService,
              public toastr: ToastrService,
              private router: Router,
              public fb: FormBuilder) { this.searchForm = this.fb.group({
                nomPrenom: ['']
              });
              this.startDate = new Date(); // Example: current date
              this.endDate = new Date(); // Example: current date
            }
  ngOnInit() {
    this.getData();
    //this.onSearchChange();

  }

  getData() {
    this.crudApi.getAll().subscribe(
      response => {
        this.crudApi.list = response;
        this.filteredItems = response; // Assign response to filteredItems
      }
    );
  }
  search(): void {
    // Filter items based on the search query
    if (this.searchQuery.trim() === '') {
      // If search query is empty, show all items
      this.filteredItems = this.crudApi.list;
    } else {
      // Otherwise, filter items based on description
      this.filteredItems = this.crudApi.list.filter(item => 
        item.nomPrenom.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    }
  }
  searchByDateRange(): void {
    console.log('Start Date:', this.startDate);
    console.log('End Date:', this.endDate);
  
    // Filter items based on the selected date range
    this.filteredItems = this.crudApi.list.filter(item =>
      this.isWithinDateRange(item.date)
    );
  
    console.log('Filtered Items:', this.filteredItems);
  }
  
  isWithinDateRange(itemDate: Date): boolean {
    console.log('Item Date:', itemDate);
    return itemDate >= this.startDate && itemDate <= this.endDate;
  }
  
  
  removeData(id: string) {
    if (window.confirm('Are you sure you want to delete this entry?')) {
      this.crudApi.deleteData(id).subscribe(
        data => {
          console.log(data);
          this.toastr.warning('Data successfully deleted!');
          this.getData();
        },
        error => console.log(error)
      );
    }
  }

  selectData(item: QRQC) {
    this.crudApi.choixmenu = "M";
    this.crudApi.formData = this.fb.group(Object.assign({}, item));
    this.router.navigate(['/emploiss']);
  }

  addEmploi() {
    this.crudApi.choixmenu = "A";
    this.router.navigate(['/emploiss']);
  }

  generatePdf() {
    const currentDateTime = new Date().toLocaleString('en-US', { 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        second: 'numeric'
    });

  const document = this.getDocument(currentDateTime); // Pass currentDate to your document generation function
  alert("mrigl");

  pdfMake.createPdf(document).open();
}
  getDocument(currentDate: string){
    return {
     
      content: [
        {
          
          columns: [
            
            [
              {
              
                image: 'data:image/png;base64,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', 
                width: 130, 
                height: 130
              },
              { text: 'Visteon', style: 'name' },
              { text: 'Date: ' + currentDate, style: 'date' }, // Including the current date here
              { text: 'Address: 1, 2 rue André Ampère - 2083 - Pôle Technologique - El Ghazala.' },
              { text: 'Email: mslim@visteon.com' },
              { text: 'Tel: 70 250 000' }
          
               
            ],
          ]
        },
        
        
        {
          text: 'Liste Des Rapports incidents',
          bold: true,
          
          fontSize: 30,
          alignment: 'center',
          margin: [0, 0, 0, 20]
        },

             this.getList(this.crudApi.list),
             {
     
             },


        {
          text: 'Signature',
          style: 'sign',
          alignment: 'right'

        },

       

      ],

      styles: {
        header: {
          fontSize: 18,
          bold: true,

          decoration: 'underline'
        },
        name: {
          fontSize: 16,
          bold: true
        },

        ligne: {
          fontSize: 12,
          bold: true,
          italics: true
        },
        sign: {
          margin: [0, 50, 0, 10],
          alignment: 'right',
          italics: true
        },
        tableHeader: {
          bold: true,
          fontSize: 15,
          alignment: 'center'
        }
      }
    };
  }


  getList(items: QRQC[]) {
    return {
      table: {
        widths: [15, 160, 160,160],
        body: [
          [
            {
              text: 'id',
              style: 'tableHeader'
            },
            {
            text: 'nomPrenom',
            style: 'tableHeader'
          },
          {
            text: 'responsable	',
            style: 'tableHeader'
          },
          {
            text: 'produit',
            style: 'tableHeader'
          },
          
          ],
         ...items.map(ed => {
            return [ed.id,ed.nomPrenom, ed.responsable, ed.produit];
          })
        ]
      }
    };
  }
  
}
