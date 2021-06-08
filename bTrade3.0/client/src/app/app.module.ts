import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatFormFieldModule, MatInputModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { MatButtonModule, MatToolbarModule, MatTableModule } from '@angular/material';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule} from '@angular/material/select';
import { MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatSnackBarModule} from '@angular/material/snack-bar';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { PmComponent } from './pm/pm.component';
import { HttpModule } from '@angular/http';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { LogoutComponent } from './logout/logout.component';
import { AccountComponent } from './account/account.component';
import { AdminUserComponent } from './admin/admin-user/admin-user.component';
import { AdminUserSearchComponent } from './admin/admin-user/admin-user-search/admin-user-search.component';
import { AdminUserAddComponent } from './admin/admin-user/admin-user-add/admin-user-add.component';
import { TradeComponent } from './trade/trade.component';
import { TradeEditComponent } from './trade-edit/trade-edit.component';
import { CarListComponent } from './car-list/car-list.component';
import { OrdersComponent } from './orders/orders.component';
import { PortfoliosListComponent } from './portfolios-list/portfolios-list.component';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import {AdminUserEditComponent} from './admin/admin-user/admin-user-edit/admin-user-edit.component';
// tslint:disable-next-line:max-line-length
import {AdminUserDeleteConfirmComponent} from './admin/admin-user/admin-user-edit/admin-user-delete-confirm/admin-user-delete-confirm.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    AdminUserComponent,
    AdminUserSearchComponent,
    // 2020-09-16: Siyu Liu
    // add three 2 new component in here
    AdminUserAddComponent,
    AdminUserEditComponent,
    AdminUserDeleteConfirmComponent,
    PmComponent,
    LogoutComponent,
    AccountComponent,
    TradeComponent,
    TradeEditComponent,
    OrdersComponent,
    PortfoliosListComponent,
    ProfileEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    HttpClientModule,
    HttpModule,
    MatFormFieldModule,
    MatListModule,
    MatInputModule,
    MatDialogModule,
    MatTableModule,
    MatButtonModule,
    MatToolbarModule,
    MatSortModule,
    MatPaginatorModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatSnackBarModule
  ],
  // 2020-09-16, Siyu Liu: add 2 new component here
  entryComponents: [AdminUserAddComponent, AdminUserEditComponent, AdminUserDeleteConfirmComponent],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
