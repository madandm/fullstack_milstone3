package com.iiht.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.StockExchangeEntity;
import com.iiht.stock.service.SectorService;
import com.iiht.stock.service.StockExchangeService;

@RestController
@RequestMapping("/api/mangeStock")
//@CrossOrigin(origins="http://localhost:4200")
public class BaseDataController {
	@Autowired
	private SectorService sectorService;
	@Autowired
	private StockExchangeService stockExchangeService;
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<StockExchangeEntity> regist(@RequestBody StockExchangeEntity stock){
		StockExchangeEntity search = stockExchangeService.findByExchangeName(stock.getExchangeName());
		//company exist do nothing
		if(search != null) {
			return new ResponseEntity<StockExchangeEntity>(HttpStatus.OK);
		}else {
			//company not exist then insert
			StockExchangeEntity stockExchangeEntity = 
					stockExchangeService.updateStockExchange(stock);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(stockExchangeEntity); 
		}
	}
	@ResponseBody
	@PostMapping("/all")
	public String findAll(){
		String strExchangelist = "";
		List<StockExchangeEntity> list = stockExchangeService.findAll();
		for(int i = 0; i < list.size(); i++) {
			strExchangelist = strExchangelist + list.get(i).getExchangeName() + ", ";
		}
		return strExchangelist;
	}
}