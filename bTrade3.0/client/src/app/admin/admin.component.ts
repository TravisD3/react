import { Component, Inject, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import {MatDialog, MatDialogConfig, MatDialogRef} from '@angular/material/dialog';

import { AdminUserAddComponent } from './admin-user/admin-user-add/admin-user-add.component';
import { UserInfo } from '../models/userinfo.model';
import { Md5 } from 'ts-md5/dist/md5';
import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  board: string;
  errorMessage: string;

  private data: UserInfo[];
  
  constructor(private userService: UserService, private addDiag: MatDialog) { }

  ngOnInit() {
    this.userService.getAdminBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );

    this.reload();
  }

  openAddDiag() {
    const diagConfig = new MatDialogConfig();
    diagConfig.disableClose = true;
    diagConfig.autoFocus = true;
    console.log("OpenAddDiag");
    this.addDiag.open(AdminUserAddComponent, diagConfig).afterClosed().subscribe(
      data => {
        if (data) {
          const user: UserInfo = {
            id: data.value.id ? data.value.id : this.nextUid(),
            email: data.value.email,
            name: data.value.name,
            password: Md5.hashAsciiStr(data.value.password).toString(),
            username: data.value.username
          };
          this.userService.addUser(user).subscribe();
        }
      }
    );
  }

  reload() {
    this.userService.getUsers().subscribe(
      data => {
        this.data = data;
      }
    );
  }

  nextUid(): number {
    this.reload();
    let max = 0;
    if (this.data) {
      for (let i = 0; i !== this.data.length; ++i) {
        if (max < this.data[i].id) {
          max = this.data[i].id;
        }
      }
    }
    return max + 1;
  }
}
