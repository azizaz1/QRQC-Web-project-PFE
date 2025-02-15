import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { AddStageComponent } from './stage/add-stage/add-stage.component';
import { ListStageComponent } from './stage/list-stage/list-stage.component';
import { LoginComponent } from './users/login/login.component';

import { StageComponent } from './stagefront/stage/stage.component';
import { ListemploiComponent } from './emploi/listemploi/listemploi.component';
import { AddemploiComponent } from './emploi/addemploi/addemploi.component';
import { FormulaireComponent } from './formulaire/formulaire/formulaire.component';
import { RegisterComponent } from './users/register/register.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AddStageQRQCComponent } from './StageQRQC/add-stage-qrqc/add-stage-qrqc.component';
import { PowerbiReportComponent } from './powerbi-report/powerbi-report.component'; // Import your Power BI report component
import { MapComponent } from './map/map.component';

import { AuthGuard } from './auth.guard'; // Import the AuthGuard

const routes: Routes = [
  {
    path: '',
    component: MenuComponent,

    children: [
      { path: 'stages', component: ListStageComponent, canActivate: [AuthGuard] },
     
            { path: 'stage', component: AddStageComponent, canActivate: [AuthGuard] }, 
      
      //{ path: 'emplois', component: ListemploiComponent, canActivate: [AuthGuard] }, // Protect route
      // Protect route
      { path: 'emplois', component: ListemploiComponent, canActivate: [AuthGuard]}, // Protect route
      { path: 'emploiss', component: AddemploiComponent , canActivate: [AuthGuard]}, // Protect route
      //{ path: 'emploiss', component: AddemploiComponent, canActivate: [AuthGuard] }, // Protect route

      { path: 'qrqc', component: AddStageQRQCComponent, canActivate: [AuthGuard]}, // Add route for AddStageQRQCComponent
      { path: 'change-password/:id', component: ChangePasswordComponent, canActivate: [AuthGuard] },
      { path: 'dashboard', component: PowerbiReportComponent, canActivate: [AuthGuard] }, // Route for Power BI report component
      { path: 'map', component: MapComponent, canActivate: [AuthGuard]  },

      // Other routes...

    ]
  },

  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'stagy', component: StageComponent },
  { path: 'forms', component: FormulaireComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
