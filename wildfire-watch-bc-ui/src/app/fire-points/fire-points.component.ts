import { Component, OnInit } from '@angular/core';
import { FirePointsService } from '../service/fire-points/fire-points-service';
import { Feature } from '../mapping/feature';
import { FirePoint } from '../mapping/fire-point';

@Component({
  selector: 'app-fire-points',
  templateUrl: './fire-points.component.html',
  styleUrls: ['./fire-points.component.css']
})
export class FirePointsComponent implements OnInit {
  fireStatus: string = '';
  fireCause: string = '';
  geographicDescription: string = '';
  firePoints: FirePoint | undefined ;
  isLoading: boolean = false;

  constructor(private firePointsService: FirePointsService) { }

  ngOnInit(): void {
    this.isLoading = true
    // Optionally, you can load initial data here
    this.applyFilters();
  }
  clear(): void {
    this.fireStatus = '';
    this.fireCause =  '' ; 
    this.geographicDescription = ''; 
    this.applyFilters();
  }
  applyFilters(): void {
    this.isLoading = true
    this.firePoints = undefined;
    // Call the service method to get fire points
    this.firePointsService.getFirePoints(this.fireStatus, this.fireCause, this.geographicDescription)
    .subscribe(
      (data: FirePoint) => {
        this.firePoints = data;
        this.isLoading = false;
      },
      (error: any) => {
        console.error('An error occurred while fetching fire points:', error);
        // Handle the error here, you can set isLoading to false or show an error message
        this.isLoading = false;
      }
    );
  }
}
