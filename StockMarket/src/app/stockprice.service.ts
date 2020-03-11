import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stockprice } from './stockprice';
//import { Stockexchange } from './stockexchange';

@Injectable({
  providedIn: 'root' 
})
export class StockpriceService {
  getStockprice() {
    throw new Error("Method not implemented."); 
  }
  private baseUrl='http://localhost:8020/StockPrice/stockprice/';

  constructor(private http:HttpClient) { }
  getAllstockprice():Observable<any>{
    return this.http.get<any>(this.baseUrl+'getAllstockprice');
  }
  saveStockPrice(stockprice:any):Observable<Stockprice>{
    return this.http.post<Stockprice>(this.baseUrl+'savestockprice',stockprice);
  }
  updateStockprice(companyCode:String, value:Stockprice):Observable<object>{
    return this.http.put<Stockprice>(this.baseUrl+'/updatestockprice/{companyCode}',companyCode);
  }
  find(companyCode:String):Observable<Stockprice>{
    return this.http.get<Stockprice>(this.baseUrl+'/find/'+companyCode);
  }

  delete(companyCode:String):Observable<object>{
    
    return  this.http.delete<Stockprice>(this.baseUrl+'/delete/'+companyCode);
   }
} 
