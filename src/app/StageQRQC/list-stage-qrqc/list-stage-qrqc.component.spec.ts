import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListStageQRQCComponent } from './list-stage-qrqc.component';

describe('ListStageQRQCComponent', () => {
  let component: ListStageQRQCComponent;
  let fixture: ComponentFixture<ListStageQRQCComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListStageQRQCComponent]
    });
    fixture = TestBed.createComponent(ListStageQRQCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
