import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { UserInfo } from '../../../models/userinfo.model';
import { UserService } from '../../../services/user.service';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-user-add',
  templateUrl: './admin-user-add.component.html',
  styleUrls: ['./admin-user-add.component.css', '../admin-user-edit/admin-user-edit.component.css']
})
export class AdminUserAddComponent implements OnInit {
  private form: FormGroup;
  private users: UserInfo[];

  constructor(private dialogRef: MatDialogRef<AdminUserAddComponent>,
              private userService: UserService,
              private fb: FormBuilder) {

  }

  reload() {
    this.userService.getUsers().subscribe(
      data => {
        this.users = data;
    });
  }

  ngOnInit() {
    this.reload();

    const forbiddenNameValidator = (control: AbstractControl): {[key: string]: any} | null => {
      if (this.users) {
        for (let i = 0; i !== this.users.length; ++i) {
          if (this.users[i].username === control.value) {
            return { username: true };
          }
        }
      }
      return null;
    };

    const forbiddenUidNoValidator = (control: AbstractControl): {[key: string]: any} | null => {
      if (this.users) {
        for (let i = 0; i !== this.users.length; ++i) {
          if (this.users[i].id === parseInt(control.value, 10)) {
            return { id: true };
          }
        }
      }
      return null;
    };

    this.form = this.fb.group({
      email: ['', [Validators.required,
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
        forbiddenNameValidator]],
      name: ['', [Validators.required,
        Validators.pattern('[A-Za-z0-9_@#$%&<> ]+'),
        forbiddenNameValidator]],
      username: ['', [Validators.required,
                       Validators.pattern('[A-Za-z0-9_@#$%&<> ]+'),
                       forbiddenNameValidator]],
      password: ['', [Validators.required,
                      Validators.minLength(4),
                      Validators.pattern('[A-Za-z0-9_@#$%&<>]+')]],
      id: ['', [/*Validators.required,*/
                    Validators.pattern('[0-9]+'),
                    forbiddenUidNoValidator]]
    });
  }

  submit(form) {
    console.log(form.prototype);
    this.dialogRef.close(form);
  }

  nextUid(): number {
    // this.reload();
    let max = 0;
    if (this.users) {
      for (let i = 0; i !== this.users.length; ++i) {
        if (max < this.users[i].id) {
          max = this.users[i].id;
        }
      }
    }
    return max + 1;
  }
}
