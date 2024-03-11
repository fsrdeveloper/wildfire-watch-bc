import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FirePointsComponent } from './fire-points.component';
import { HttpClientModule } from '@angular/common/http';

describe('FirePointsComponent', () => {
  let component: FirePointsComponent;
  let fixture: ComponentFixture<FirePointsComponent>;
  let httpTestingController: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FirePointsComponent ],
      imports: [ HttpClientModule, HttpClientTestingModule ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FirePointsComponent);
    component = fixture.componentInstance;
    httpTestingController = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch fire points data', () => {
    const mockData = [{}];
    component.applyFilters();
    const req = httpTestingController.expectOne('/fire-points?&fireStatus=&fireCause=&geographicDescription=');
    expect(req.request.method).toEqual('GET');
    req.flush(mockData);
    expect(component.firePoints).toEqual(mockData);
  });

  afterEach(() => {
    httpTestingController.verify();
  });
});