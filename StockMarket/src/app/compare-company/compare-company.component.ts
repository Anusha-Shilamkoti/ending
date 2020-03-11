import {
  Component, OnInit, ViewChild,
  ElementRef,
  AfterViewInit,
  OnDestroy,
  ChangeDetectorRef,
} from '@angular/core';
import { Router } from '@angular/router';
import { Company } from 'src/app/company';
import { Observable } from 'rxjs/internal/Observable';
import { Stockprice } from 'src/app/stockprice';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { of } from 'rxjs';
import { getSyntheticPropertyName } from '@angular/compiler/src/render3/util';
import * as Highcharts from 'highcharts';
import { CompanyService } from '../company.service';
import { SectorService } from '../sector.service';
import { StockexchangeService } from '../stockexchange.service';
import { Sector } from '../sector';
import { StockpriceService } from '../stockprice.service';
import { HighchartsService } from './highcharts.service';
@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  @ViewChild('charts') public chartEl: ElementRef;
  myGroup: FormGroup;
  constructor(private hcs: HighchartsService, private formBuilder: FormBuilder, private router: Router, private companyservice: CompanyService, private sectorservice: SectorService, private stockpriceservice: StockpriceService) { }
  companyList: Company[];
  companyListAll: Company[];
  sectorsList: Sector[];
  stockpriceList: Observable<Stockprice[]>;
  ngAfterViewInit() {
    
    this.hcs.createChart(this.chartEl.nativeElement);
  }
  ngOnInit() {
    this.myGroup = this.formBuilder.group({
      "choose": new FormControl([Validators.required]),
      "sectorname": new FormControl([Validators.required]),
      "companyname": new FormControl([Validators.required]),
      "fromdate": new FormControl([Validators.required]),
      "todate": new FormControl([Validators.required])
    })
    this.companyservice.getAllcompanies().subscribe(data => {
      this.companyList = data;
      this.companyListAll = data;
      this.companyList = this.companyList.filter(comp => comp.sector == 'NSE');
    })
    this.stockpriceservice.getAllstockprice().subscribe(data => {
      this.stockpriceList = data;
    })
    this.sectorservice.getAllsectors().subscribe(data => {
      this.sectorsList = data;
    })
  }
  sectorChange() {
   
    var sectorValue = this.myGroup.controls['sectorname'].value;
    this.companyList = this.companyListAll.filter(comp => comp.sector == sectorValue);
  }
}