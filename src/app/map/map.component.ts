import { Component, OnInit } from '@angular/core';
import * as L from 'leaflet';  // Import Leaflet library

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {
  lat: number = 36.8065;  // Default coordinates (Tunis, Tunisia)
  lng: number = 10.1815;
  zoom: number = 2;  // Global zoom level to see multiple markers
  map: any;

  // Array of Visteon Locations (example coordinates)
  visteonLocations = [
    { name: 'Visteon Tunisia', lat: 37.0700, lng: 9.6785 },
    { name: 'Visteon USA', lat: 42.3601, lng: -71.0589 }, // Boston, USA
    { name: 'Visteon India', lat: 19.0760, lng: 72.8777 }, // Mumbai, India
    { name: 'Visteon Germany', lat: 51.1657, lng: 10.4515 }, // Germany
    { name: 'Visteon China', lat: 39.9042, lng: 116.4074 }, // Beijing, China
    { name: 'Visteon Mexico', lat: 19.4326, lng: -99.1332 }, // Mexico City, Mexico
    { name: 'Visteon Brazil', lat: -23.5505, lng: -46.6333 } // São Paulo, Brazil
  ];

  constructor() { }

  ngOnInit(): void {
    this.initMap();  // Initialize the map on component load
  }

  initMap() {
    // Initialize the map and set the view to the default coordinates and zoom
    this.map = L.map('map').setView([this.lat, this.lng], this.zoom);

    // Use OpenStreetMap tile layer for a free, detailed map
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 19,
    }).addTo(this.map);

    // Add marker for each Visteon location
    this.visteonLocations.forEach(location => {
      L.marker([location.lat, location.lng]).addTo(this.map)
        .bindPopup(location.name)
        .openPopup();
    });
  }
}
