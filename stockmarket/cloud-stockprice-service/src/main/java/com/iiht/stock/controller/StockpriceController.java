package com.iiht.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.StockpriceEntity;
import com.iiht.stock.service.StockpriceService;
import com.iiht.stock.vo.StockpriceModel;

@RestController
@RequestMapping("/api/echart")
//@CrossOrigin(origins="http://localhost:4200")
public class StockpriceController {
	@Autowired
	private StockpriceService stockpriceService;

	@ResponseBody
	@PostMapping("/search")
	public StockpriceModel findStockPriceforSearch(@RequestBody StockpriceModel inputmodel) {
		String key = "";
		if(inputmodel != null) {
			key = inputmodel.getKey1();
		}
		List<StockpriceEntity> resutList = stockpriceService.findStockPrice(key,"","");
		List<String> maxdayList = stockpriceService.findMaxDayofMonth(inputmodel.getKey1());
		StockpriceModel stockpriceModel = new StockpriceModel();
		//xAxis:dataperiod
		String dataPeriod[] = new String[resutList.size()];
		//yAxis:[open, current, low, high]
		String dataPrice[][] = new String[resutList.size()][4];
		int i = 0;
		//day period display
		if("day".equals(inputmodel.getPeriod())) {
			for (StockpriceEntity model : resutList) {
				dataPeriod[i] = String.valueOf(model.getPriceDate());
				dataPrice[i][0] = String.valueOf(model.getOpenPrice());
				dataPrice[i][1] = String.valueOf(model.getCurrentPrice());
				dataPrice[i][2] = String.valueOf(model.getLowPrice());
				dataPrice[i][3] = String.valueOf(model.getHighPrice());
				i++;
			}
		}else if("week".equals(inputmodel.getPeriod())) {
		//week period display
			for (StockpriceEntity model : resutList) {
				//if the day is friday the display
				if(6 == model.getWeek()) {
					dataPeriod[i] = String.valueOf(model.getPriceDate());
					dataPrice[i][0] = String.valueOf(model.getOpenPrice());
					dataPrice[i][1] = String.valueOf(model.getCurrentPrice());
					dataPrice[i][2] = String.valueOf(model.getLowPrice());
					dataPrice[i][3] = String.valueOf(model.getHighPrice());
					i++;
				}
			}
			
		}else if("month".equals(inputmodel.getPeriod())) {
		//month period display
			for (StockpriceEntity model : resutList) {
				for(int j=0; j<maxdayList.size(); j++) {
					if(model.getPriceDate().equals(maxdayList.get(j))) {
						dataPeriod[i] = String.valueOf(model.getPriceDate());
						dataPrice[i][0] = String.valueOf(model.getOpenPrice());
						dataPrice[i][1] = String.valueOf(model.getCurrentPrice());
						dataPrice[i][2] = String.valueOf(model.getLowPrice());
						dataPrice[i][3] = String.valueOf(model.getHighPrice());
						i++;
					}
				}
			}
		}
		stockpriceModel.setDataPrice(dataPrice);
		stockpriceModel.setDataPeriod(dataPeriod);
		return stockpriceModel;
	}

	@ResponseBody
	@PostMapping("/compare")
	public List<StockpriceModel> findStockPriceforCompare
					(@RequestBody StockpriceModel stockpriceModel) {
		List<StockpriceModel> disaplayList = new ArrayList<StockpriceModel>();
		String key1 = "";
		String key2 = "";
		String from = "";
		String end = "";
		if(stockpriceModel != null) {
			key1 = stockpriceModel.getKey1();
			key2 = stockpriceModel.getKey2();
			from = stockpriceModel.getPeriodFrom();
			end = stockpriceModel.getPeriodEnd();
		}
		//company1
		StockpriceModel model1 = getStockPrice(key1, from, end);
		disaplayList.add(model1);
		//company2
		StockpriceModel model2 = getStockPrice(key2, from, end);
		disaplayList.add(model2);
		
		return disaplayList;
	}
	/**
	 * get dateperiod for xAxis dataprice for yAxis
	 * @param key:company name or code
	 * @param from:period from
	 * @param end:period end
	 * @return StockpriceModel
	 */
	private StockpriceModel getStockPrice(String key, String from, String end) {
		List<StockpriceEntity> resultList = stockpriceService.findStockPrice(key, from, end);
		//xAxis:dataperiod
		String dataPeriod[] = new String[resultList.size()];
		//yAxis:[open, current, low, high]
		String dataPrice[][] = new String[resultList.size()][4];
		StockpriceModel stockpriceModel = new StockpriceModel();
		int i = 0;
		for (StockpriceEntity model : resultList) {
			dataPeriod[i] = String.valueOf(model.getPriceDate());
			dataPrice[i][0] = String.valueOf(model.getOpenPrice());
			dataPrice[i][1] = String.valueOf(model.getCurrentPrice());
			dataPrice[i][2] = String.valueOf(model.getLowPrice());
			dataPrice[i][3] = String.valueOf(model.getHighPrice());
			i++;
		}
		stockpriceModel.setDataPrice(dataPrice);
		stockpriceModel.setDataPeriod(dataPeriod);
		return stockpriceModel;
	}
}
