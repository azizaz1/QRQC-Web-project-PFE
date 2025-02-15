import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-stage-chart',
  templateUrl: './stage-chart.component.html',
  styleUrls: ['./stage-chart.component.scss']
})
export class StageChartComponent implements OnInit {
  
  @ViewChild('stageChart') stageChart: ElementRef;
  chart: Chart;

  constructor() { }

  ngOnInit(): void {
    console.log('ngOnInit called');

    // Generate mock data (replace this with your actual data)
    const labels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
    const data = [65, 59, 80, 81, 56, 55, 40];

    console.log(labels);
    console.log(data);

    // Create chart options
    const chartOptions: ChartOptions = {
      responsive: true,
      maintainAspectRatio: false
    };

    // Create the chart
    this.chart = new Chart(this.stageChart.nativeElement, {
      type: 'line',
      data: {
        labels: labels,
        datasets: [
          {
            label: 'Number of Stage Reports',
            data: data,
            fill: false,
            backgroundColor: 'rgba(75, 192, 192, 0.4)',
            borderColor: 'rgb(75, 192, 192)',
            borderWidth: 2,
            pointBackgroundColor: 'rgb(75, 192, 192)',
            pointBorderColor: 'rgb(75, 192, 192)',
            pointHoverBackgroundColor: 'rgb(75, 192, 192)',
            pointHoverBorderColor: 'rgb(75, 192, 192)'
          }
        ]
      },
      options: chartOptions
    });
  }
}
