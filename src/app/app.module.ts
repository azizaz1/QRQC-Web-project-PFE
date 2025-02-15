import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MatTabsModule } from '@angular/material/tabs'; // Corrected import
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { AddStageComponent } from './stage/add-stage/add-stage.component';
import { ListStageComponent } from './stage/list-stage/list-stage.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './users/register/register.component';
import { AccueilComponent } from './accueil/accueil.component';
import { LoginComponent } from './users/login/login.component';
import { StageComponent } from './stagefront/stage/stage.component';
import { AddemploiComponent } from './emploi/addemploi/addemploi.component';
import { ListemploiComponent } from './emploi/listemploi/listemploi.component';
import { FormulaireComponent } from './formulaire/formulaire/formulaire.component';
import { StageChartComponent } from './stage-chart/stage-chart.component';
import { DateAdapter } from '@angular/material/core';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AddStageQRQCComponent } from './StageQRQC/add-stage-qrqc/add-stage-qrqc.component';
import { ListStageQRQCComponent } from './StageQRQC/list-stage-qrqc/list-stage-qrqc.component';
import { PowerbiReportComponent } from './powerbi-report/powerbi-report.component';
//import { EmbedService } from 'powerbi-client-angular'; // Ensure this import is correct
import { PowerBIEmbedModule } from 'powerbi-client-angular';
import { SafeUrlPipe } from './safe-url.pipe';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';  // <-- Import here


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AddStageComponent,
    ListStageComponent,
    LoginComponent,
    RegisterComponent,
    AccueilComponent,
    StageComponent,
    AddemploiComponent,
    ListemploiComponent,
    FormulaireComponent,
    StageChartComponent,
    ChangePasswordComponent,
    AddStageQRQCComponent,
    ListStageQRQCComponent,
    PowerbiReportComponent,
    SafeUrlPipe, // Ensure PowerbiReportComponent is listed here
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatTabsModule,
    BrowserAnimationsModule,
    LeafletModule,
    PowerBIEmbedModule, // Include PowerBIEmbedModule
    ToastrModule.forRoot(),
  ],
  providers: [
    //EmbedService // Add EmbedService to providers if not already added
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
