import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUserDeleteConfirmComponent } from './admin-user-delete-confirm.component';

describe('AdminUserDeleteConfirmComponent', () => {
  let component: AdminUserDeleteConfirmComponent;
  let fixture: ComponentFixture<AdminUserDeleteConfirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUserDeleteConfirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUserDeleteConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
