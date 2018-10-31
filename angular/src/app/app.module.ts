import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker'
import { BsDropdownModule } from 'ngx-bootstrap/dropdown'
import { ModalModule } from 'ngx-bootstrap/modal'
import { TooltipModule } from 'ngx-bootstrap/tooltip'
import { QueryBuilderModule } from 'angular2-query-builder';

import { DataTablesModule } from 'angular-datatables';

import { AppComponent } from './app.component';

import * as $ from 'jquery';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HeroDetailComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	DataTablesModule,
	QueryBuilderModule,
	BsDatepickerModule.forRoot(),
	TooltipModule.forRoot(),
	ModalModule.forRoot(),
	BsDropdownModule.forRoot(),
	ButtonsModule.forRoot(),
	AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
