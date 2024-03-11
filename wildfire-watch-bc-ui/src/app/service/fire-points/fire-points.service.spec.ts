import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FirePointsService } from './fire-points-service';
import { HttpClientModule } from '@angular/common/http';

describe('FirePointsService', () => {
  let service: FirePointsService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientModule, HttpClientTestingModule ],
      providers: [ FirePointsService ]
    });
    service = TestBed.inject(FirePointsService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch fire points data', () => {
    const mockData = [{ fireStatus: 'Active',  fireCause : 'Unknown', geographicDescription: 'Forest' }];
    const req = httpTestingController.expectOne('/fire-points?year=2021&fireStatus=Active&fireCause=Unknown&geographicDescription=Forest');
    expect(req.request.method).toEqual('GET');
    req.flush(mockData);
  });

  afterEach(() => {
    httpTestingController.verify();
  });
});