import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStageQRQCComponent } from './add-stage-qrqc.component';

describe('AddStageQRQCComponent', () => {
  let component: AddStageQRQCComponent;
  let fixture: ComponentFixture<AddStageQRQCComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddStageQRQCComponent]
    });
    fixture = TestBed.createComponent(AddStageQRQCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
