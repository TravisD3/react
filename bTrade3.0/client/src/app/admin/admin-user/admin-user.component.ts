import { Component, OnInit } from '@angular/core';
import { UserInfo } from '../../models/userinfo.model';
import { UserService } from '../../services/user.service';

import { MatDialog, MatDialogConfig } from '@angular/material';
import { AdminUserEditComponent } from './admin-user-edit/admin-user-edit.component';
import { Md5 } from 'ts-md5/dist/md5';
import { AdminUserAddComponent } from './admin-user-add/admin-user-add.component';
import {AdminUserDeleteConfirmComponent} from './admin-user-edit/admin-user-delete-confirm/admin-user-delete-confirm.component';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {

  users: UserInfo[];

  columnsToDisplay: string[] = ['id', 'username',  'name', 'password', 'modify'];
  // columnsToDisplay: string[] = ['id', 'username',  'name', 'modify'];
  constructor(private userService: UserService, private diag: MatDialog) { }

  ngOnInit() {
    this.reload();
  }

  reload() {
    this.userService.getUsers().subscribe(
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
          user.password = value;
          this.userService.updateUser(user).subscribe();
        }
      }
    );
  }

  openAddDiag() {
    const diagConfig = new MatDialogConfig();
    diagConfig.disableClose = true;
    diagConfig.autoFocus = true;

    this.diag.open(AdminUserAddComponent, diagConfig).afterClosed().subscribe(
      data => {
        if (data) {
          const userInfo: UserInfo = {
            // id: null,
            // password: Md5.hashAsciiStr(data.value.password).toString(),
            password: data.value.password,
            id: data.value.id ? data.value.id : this.nextUid(),
            email: data.value.email,
            username: data.value.username,
            name: data.value.name,
          };
          this.userService.addUser(userInfo).subscribe();
        }
      }
    );
  }

  nextUid(): number {
    this.reload();
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
