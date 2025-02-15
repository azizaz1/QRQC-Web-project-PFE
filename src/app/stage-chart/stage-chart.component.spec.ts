import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StageChartComponent } from './stage-chart.component';

describe('StageChartComponent', () => {
  let component: StageChartComponent;
  let fixture: ComponentFixture<StageChartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StageChartComponent]
    });
    fixture = TestBed.createComponent(StageChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
