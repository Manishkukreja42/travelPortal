import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegistrationSuccesfullComponent } from './user-registration-succesfull.component';

describe('UserRegistrationSuccesfullComponent', () => {
  let component: UserRegistrationSuccesfullComponent;
  let fixture: ComponentFixture<UserRegistrationSuccesfullComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRegistrationSuccesfullComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRegistrationSuccesfullComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
