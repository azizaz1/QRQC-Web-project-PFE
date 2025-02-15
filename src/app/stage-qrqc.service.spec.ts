import { TestBed } from '@angular/core/testing';

import { StageQRQCService } from './stage-qrqc.service';

describe('StageQRQCService', () => {
  let service: StageQRQCService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StageQRQCService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
