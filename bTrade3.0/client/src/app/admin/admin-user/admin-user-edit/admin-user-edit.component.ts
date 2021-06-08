import { Component, Inject, OnInit } from '@angular/core';
import { ErrorStateMatcher, MAT_DIALOG_DATA } from '@angular/material';
import { UserInfo } from '../../../models/userinfo.model';
import { UserService } from '../../../services/user.service';
import {FormBuilder, FormGroup, Validators, FormControl, FormGroupDirective, NgForm} from '@angular/forms';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl || invalidParent);
  }
}

@Component({
  selector: 'app-admin-user-edit',
  templateUrl: './admin-user-edit.component.html',
  styleUrls: ['./admin-user-edit.component.css']
})

export class AdminUserEditComponent implements OnInit {
  title: string;
  user: UserInfo;
  form: FormGroup;
  matcher = new MyErrorStateMatcher();

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    @Inject(MAT_DIALOG_DATA) data, ) {
    this.title = data.title;
    this.user = data.user;
    this.form = fb.group({
      password: ['', [Validators.required,
        Validators.minLength(4),
        Validators.pattern('[A-Za-z0-9_@#$%&<>]+')]],
      confirmPassword: ['']
    }, { validator: this.checkPasswords });
  }


  ngOnInit() {
  }

  checkPasswords(form: FormGroup) {
    const pass = form.value.password;
    const confirmPass = form.value.confirmPassword;

    return pass === confirmPass ? null : { notSame: true };
  }
}
