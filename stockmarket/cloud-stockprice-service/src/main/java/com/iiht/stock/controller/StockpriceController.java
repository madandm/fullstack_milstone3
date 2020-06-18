package com.iiht.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public StockpriceModel findStockPriceforSearch(@RequestParam(name="key") String key) {
		List<StockpriceEntity> resutList = stockpriceService.findStockPrice(key,"","");
		List<String> maxdayList = stockpriceService.findMaxDayofMonth(key);
		StockpriceModel stockpriceModel = new StockpriceModel();
		//xAxis:dataperiod
		String dayPeriod[] = new String[resutList.size()];
		//yAxis:[open, current, low, high]
		String dayPrice[][] = new String[resutList.size()][4];
		int i = 0;
		//day period display
		for (StockpriceEntity model : resutList) {
			dayPeriod[i] = String.valueOf(model.getPriceDate());
			dayPrice[i][0] = String.valueOf(model.getOpenPrice());
			dayPrice[i][1] = String.valueOf(model.getCurrentPrice());
			dayPrice[i][2] = String.valueOf(model.getLowPrice());
			dayPrice[i][3] = String.valueOf(model.getHighPrice());
			i++;
		}
		stockpriceModel.setDayPrice(dayPrice);
		stockpriceModel.setDayPeriod(dayPeriod);
		stockpriceModel.setPrice(dayPrice[resutList.size()][1]);
		
		i =0;
		//week period display
		for (StockpriceEntity model : resutList) {
			//if the day is friday the display
			if(6 == model.getWeek()) {
				i++;
			}
		}
		//xAxis:dataperiod
		String weekPeriod[] = new String[i];
		//yAxis:[open, current, low, high]
		String weekPrice[][] = new String[i][4];
		i = 0;
		for (StockpriceEntity model : resutList) {
			//if the day is friday the display
			if(6 == model.getWeek()) {
				weekPeriod[i] = String.valueOf(model.getPriceDate());
				weekPrice[i][0] = String.valueOf(model.getOpenPrice());
				weekPrice[i][1] = String.valueOf(model.getCurrentPrice());
				weekPrice[i][2] = String.valueOf(model.getLowPrice());
				weekPrice[i][3] = String.valueOf(model.getHighPrice());
				i++;
			}
		}
		stockpriceModel.setWeekPrice(weekPrice);
		stockpriceModel.setWeekPeriod(weekPeriod);	

		i =0;
		//xAxis:dataperiod
		String monthPeriod[] = new String[maxdayList.size()];
		//yAxis:[open, current, low, high]
		String monthPrice[][] = new String[maxdayList.size()][4];
		//week period display
		//month period display
		for (StockpriceEntity model : resutList) {
			for(int j=0; j<maxdayList.size(); j++) {
				if(model.getPriceDate().equals(maxdayList.get(j))) {
					monthPeriod[i] = String.valueOf(model.getPriceDate());
					monthPrice[i][0] = String.valueOf(model.getOpenPrice());
					monthPrice[i][1] = String.valueOf(model.getCurrentPrice());
					monthPrice[i][2] = String.valueOf(model.getLowPrice());
					monthPrice[i][3] = String.valueOf(model.getHighPrice());
					i++;
				}
			}
		}
		
		stockpriceModel.setMonthPrice(monthPrice);
		stockpriceModel.setMonthPeriod(monthPeriod);	
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
