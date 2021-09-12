import { TestBed } from '@angular/core/testing';

import { TravelPortalService } from './travel-portal.service';

describe('TravelPortalService', () => {
  let service: TravelPortalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelPortalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
