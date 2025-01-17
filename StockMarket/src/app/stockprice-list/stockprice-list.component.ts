import { Component, OnInit } from '@angular/core';
import { StockpriceService } from '../stockprice.service';
import { Observable } from 'rxjs';
import { Stockprice } from '../stockprice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stockprice-list',
  templateUrl: './stockprice-list.component.html',
  styleUrls: ['./stockprice-list.component.css']
})
export class StockpriceListComponent implements OnInit {

  constructor(private router:Router, private stockpriceservice:StockpriceService) { }
  stockpricelist:Observable<any[]>;

  ngOnInit(){
    this.stockpriceservice.getAllstockprice().subscribe(data=>{
      this.stockpricelist=data;
     }) 
  }
  deleteStockprice(stockprice:Stockprice)

  {
 
   this.stockpriceservice.delete(stockprice.companyCode).subscribe(data=>{
 
   this.stockpriceservice.getAllstockprice().subscribe(data=>{this.stockpricelist=data;});
 
  });
  }
  updateStockprice(stockprice : Stockprice ) {
    window.localStorage.removeItem("edit-companyCode");
  
    window.localStorage.setItem("edit-companyCode", stockprice.companyCode.toString());
  
    this.router.navigate(['create-stockprice']);
  
   } 
 
}
