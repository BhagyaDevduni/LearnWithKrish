import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { OrderStatusComponent } from './order-status/order-status.component';

const routes: Routes = [
    {path:'home',component:HomeComponent},
    {path:'',component:HomeComponent},
    {path:'user',component:UserComponent},
    {path:'orderStatus',component:OrderStatusComponent},
    
    
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }