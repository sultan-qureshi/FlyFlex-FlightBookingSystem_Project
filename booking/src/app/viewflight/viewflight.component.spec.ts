import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewflightComponent } from './viewflight.component';

describe('ViewflightComponent', () => {
  let component: ViewflightComponent;
  let fixture: ComponentFixture<ViewflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
