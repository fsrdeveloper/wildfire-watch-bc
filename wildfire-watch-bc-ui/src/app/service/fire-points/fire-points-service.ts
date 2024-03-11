import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment'; // Import environment
import { FirePoint } from 'src/app/mapping/fire-point';

@Injectable({
  providedIn: 'root'
})
export class FirePointsService {
  constructor(private http: HttpClient) {}

  getFirePoints(fireStatus: string, fireCause: string, geographicDescription: string): Observable<FirePoint> {
    const apiUrl = `${environment.apiUrl}/fire-points`; // Access apiUrl from environment
    return this.http.get<FirePoint>(apiUrl, {
      params: {
        fireStatus,
        fireCause,
        geographicDescription
      }
    });
  }
}
