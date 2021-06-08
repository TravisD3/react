import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserInfo } from '../../../models/userinfo.model';
import { UserService } from '../../../services/user.service';

import {MatDialog, MatDialogConfig} from '@angular/material';
import {AdminUserEditComponent} from '../admin-user-edit/admin-user-edit.component';
import {AdminUserDeleteConfirmComponent} from '../admin-user-edit/admin-user-delete-confirm/admin-user-delete-confirm.component';
import {Md5} from 'ts-md5';

@Component({
  selector: 'app-admin-user-search',
  templateUrl: './admin-user-search.component.html',
  styleUrls: ['./admin-user-search.component.css']
})
export class AdminUserSearchComponent implements OnInit {
  form: FormGroup;
  formSearchById: FormGroup;
  users: UserInfo[] = [];

  columnsToDisplay: string[] = ['id', 'username',  'name', 'password', 'modify'];
 
  constructor(private fb: FormBuilder, private userService: UserService, private diag: MatDialog) {
    this.form = fb.group({
      user_name: ['', [Validators.required,
        Validators.pattern('[A-Za-z0-9_@#$%&<> ]+')]],
    });
    this.formSearchById = fb.group({
      user_id: ['', [Validators.required,
        Validators.pattern('[0-9]+')]]
    });
  }

  ngOnInit() {
  }

  searchUserByName(user_name: string) {
    this.userService.getUserByName(user_name).subscribe(
      data => {
        this.users = data;
      }
    );
  }

  searchUserById(user_id: number) {
    this.userService.getUserById(user_id).subscribe(
      data => {
        this.users = data;
      }
    );
  }

  openEditDiag(user: UserInfo) {
    const diagConfig = new MatDialogConfig();
    diagConfig.disableClose = true;
    diagConfig.autoFocus = true;

    diagConfig.data = {
      title: 'Please input new password ',
      user: user
    };
    this.diag.open(AdminUserEditComponent, diagConfig).afterClosed().subscribe(
      value => {
        if (value.toString().startsWith('/DELETE/')) {
          const user_id: number = parseInt(value.toString().substring(8), 10);
          const diagConfirmConfig = new MatDialogConfig();
          diagConfirmConfig.disableClose = true;
          diagConfirmConfig.autoFocus = true;
          diagConfirmConfig.data = {
            user_name: user.username
          };
          this.diag.open(AdminUserDeleteConfirmComponent, diagConfirmConfig).afterClosed().subscribe(
            confirm_value => {
              if (confirm_value.toString() === 'YES') {
                this.userService.deleteUser(user_id).subscribe();
              }
            }
          );

          return;
        }
        if (value) {
          user.password = Md5.hashAsciiStr(value).toString();
          this.userService.updateUser(user).subscribe();
        }
      }
    );
  }
}
