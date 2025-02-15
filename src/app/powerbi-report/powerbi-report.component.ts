import { Component, OnInit } from '@angular/core';
import { IEmbedConfiguration } from 'powerbi-client';

@Component({
  selector: 'app-powerbi-report',
  templateUrl: './powerbi-report.component.html',
  styleUrls: ['./powerbi-report.component.scss']
})
export class PowerbiReportComponent implements OnInit {

  embedUrl: string;

  constructor() { }

  ngOnInit(): void {
    // Replace with your "Publish to Web" URL
    this.embedUrl = 'https://app.powerbi.com/reportEmbed?reportId=8ffba97c-96c8-4a7b-9e0e-2cb4cc80f9ad&autoAuth=true&ctid=604f1a96-cbe8-43f8-abbf-f8eaf5d85730';
    this.embedPowerBIReport();
  }

  embedPowerBIReport(): void {
    const embedConfig: IEmbedConfiguration = {
      type: 'report',
      id: '8ffba97c-96c8-4a7b-9e0e-2cb4cc80f9ad',
      embedUrl: this.embedUrl,
      // accessToken and tokenType are not required for "Publish to Web"
      settings: {
        panes: {
          filters: {
            expanded: false,
            visible: true
          }
        }
      }
    };

    const embedContainer = document.getElementById('embedContainer');
    const powerbi = new (window as any).powerbi.service.Service(
      (window as any).powerbi.factories.hpmFactory,
      (window as any).powerbi.factories.wpmpFactory,
      (window as any).powerbi.factories.routerFactory
    );
    powerbi.embed(embedContainer, embedConfig);
  }
}
