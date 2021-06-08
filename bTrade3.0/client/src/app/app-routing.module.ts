import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import { AdminUserComponent } from './admin/admin-user/admin-user.component';
import { AdminUserSearchComponent } from './admin/admin-user/admin-user-search/admin-user-search.component';

import { LogoutComponent } from './logout/logout.component';
import { AccountComponent } from './account/account.component';
import { TradeComponent } from './trade/trade.component';
import { TradeEditComponent } from './trade-edit/trade-edit.component';
import { OrdersComponent } from './orders/orders.component';
import { PortfoliosListComponent } from './portfolios-list/portfolios-list.component';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'accounts',
        component: AccountComponent
    },
    {
        path: 'trade',
        component: TradeEditComponent
    },
    {
        path: 'orders',
        component: OrdersComponent
    },
    {
        path: 'portfolios',
        component: PortfoliosListComponent
    },
    {
        path: 'profile-add',
        component: ProfileEditComponent
    },
    {
        path: 'profile-edit/:id',
        component: ProfileEditComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'pm',
        component: PmComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'admin/users',
        component: AdminUserComponent
    },
    {
        path: 'admin/users/search',
        component: AdminUserSearchComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'auth/logout',
        component: LogoutComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
