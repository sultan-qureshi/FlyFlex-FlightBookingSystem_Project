import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookflightComponent } from './bookflight.component';

describe('BookflightComponent', () => {
  let component: BookflightComponent;
  let fixture: ComponentFixture<BookflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
