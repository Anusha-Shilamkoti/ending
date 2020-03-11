import { Injectable } from '@angular/core';

import * as Highcharts from 'highcharts';

import { Company } from 'src/app/company';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';



@Injectable()

export class HighchartsService {

 companyList: Company[];

 charts = [];

 defaultOptions = {

  title: {

    text: 'Compare Company Growth by Sector'

  },

  subtitle: {

    text: 'Source: moneycontrol.com'

  },

  yAxis: {

    title: {

      text: 'compare stock price'

    }

  }, 

  legend: {

    layout: 'vertical',

    align: 'right',

    verticalAlign: 'middle'

  },

  plotOptions: {

    series: {

      pointStart:2010

    }

  },

  series: [{

    name: 'tcs',

    data: [90000, 20000, 10000, 30000, 60000, 10000, 30000]

  },

  {

   name: 'cts',

   data: [70000, 30000, 30000, 20000, 70000, 90000, 50000]

 }

 ]

 }



 private baseUrl='http://localhost:8017/stockprice/';

 constructor(private http: HttpClient) {

  

  }
 getGraphData(): Observable<any> {
   return this.http.get<any>(this.baseUrl + '/getGraphData');
 }
 


 createChart(container, options?: any) {

  let opts = !!options ? options : this.defaultOptions;

  let e = document.createElement("div");



  container.appendChild(e);



  if(!!opts.chart) {

   opts.chart['renderTo'] = e;

  }

  else {

   opts.chart = {

    'renderTo': e

   }

  }

  this.charts.push(new Highcharts.Chart(opts));

 }



 removeFirst() {

  this.charts.shift();

 }



 removeLast() {

  this.charts.pop();

 }



 getChartInstances(): number {

  return this.charts.length;

 }



 getCharts() {

  return this.charts;

 }

}