import { TestBed } from '@angular/core/testing';

import { PlanformationService } from './planformation.service';

describe('PlanformationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlanformationService = TestBed.get(PlanformationService);
    expect(service).toBeTruthy();
  });
});
