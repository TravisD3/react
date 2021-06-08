import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-admin-user-delete-confirm',
  templateUrl: './admin-user-delete-confirm.component.html',
  styleUrls: ['../admin-user-edit.component.css', './admin-user-delete-confirm.component.css']
})
export class AdminUserDeleteConfirmComponent implements OnInit {
  user_name: string;
  id: any;

  constructor(@Inject(MAT_DIALOG_DATA) data) {
    this.user_name = data.user_name;
  }

  ngOnInit() {
  }

}
