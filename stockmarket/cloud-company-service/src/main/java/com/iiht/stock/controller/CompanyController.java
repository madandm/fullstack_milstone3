package com.iiht.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.CompanyEntity;
import com.iiht.stock.entity.IpoPlanedEntity;
import com.iiht.stock.service.CompanyService;
import com.iiht.stock.service.IpoService;
import com.iiht.stock.vo.CompanyModel;

@RestController
@RequestMapping("/api/company")
//@CrossOrigin(origins="http://localhost:4200")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private IpoService ipoService;
	
	@ResponseBody
	@PostMapping("/key")
	public CompanyEntity findByKey(@RequestParam(name="key") String key){
		List<CompanyEntity> result = companyService.findByNameOrCode(key);
		CompanyEntity companyEntity = new CompanyEntity();
		if (result != null && result.size() != 0){
			companyEntity = result.get(0);
		}
		return companyEntity;
	}
	@PostMapping("/all")
	public List<CompanyEntity> findAll(){
		List<CompanyEntity> result = companyService.findAll();
		return result;
	}
	
	
	@ResponseBody
	@PostMapping("/search")
	public CompanyModel findByNameOrCode(@RequestParam(name="key") String key){
		List<CompanyEntity> result = companyService.findByNameOrCode(key);
		CompanyModel companyModel = new CompanyModel();
		if (result != null && result.size() != 0){
			CompanyEntity companyEntity = result.get(0);
			companyModel.setBoardOfDrectors(companyEntity.getBoardOfDrectors());
			companyModel.setBrief(companyEntity.getBrief());
			companyModel.setCeo(companyEntity.getCeo());
			companyModel.setCompanyCode(companyEntity.getCompanyCode());
			companyModel.setCompanyName(companyEntity.getCompanyName());
			companyModel.setTurnOver(companyEntity.getTurnOver());
			List<String> resultSector = companyService.findBySecotId(companyEntity.getSectorId());
			if(resultSector != null && resultSector.size() != 0) {
				companyModel.setSectorName(resultSector.get(0));
			}
			List<String> resultExchange = companyService.findByExchangeId(companyEntity.getExchangeId());
			if(resultExchange != null && resultExchange.size() != 0) {
				companyModel.setExchangeName(resultExchange.get(0));
			}
		}
		
		return companyModel;
	}
	
	
	@PostMapping("/regist")
	public ResponseEntity<CompanyEntity> regist(@RequestBody CompanyEntity company){
		CompanyEntity search = companyService.findByCompanyCode(company.getCompanyCode());
		//company exist do nothing
		if(search != null) {
			return new ResponseEntity<CompanyEntity>(HttpStatus.OK);
		}else {
			//company not exist then insert
			CompanyEntity CompanyEntity = companyService.updatecompany(company);
			return ResponseEntity.status(HttpStatus.CREATED).body(CompanyEntity); 
		}
	}
	@PostMapping("/update")
	public ResponseEntity<CompanyEntity> update(@RequestBody CompanyEntity company){
		CompanyEntity CompanyEntity = companyService.updatecompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(CompanyEntity); 
	}
	
	@PostMapping("/delete")
	public void deleteAll(@RequestParam(name="companyName") String key){
	    String[] stuList = key.split(",");
	    List<String> LString = new ArrayList<String>();
	    for(String str : stuList){
	        LString.add(str);
	    }
	    companyService.deleteBatch(LString);
	}
	
	@PostMapping("/ipo")
	public ResponseEntity<IpoPlanedEntity> regist(@RequestBody IpoPlanedEntity ipo){
		IpoPlanedEntity search = ipoService.findById(ipo.getId());
		//ipo exist do nothing
		if(search != null) {
			return new ResponseEntity<IpoPlanedEntity>(HttpStatus.OK);
		}else {
			//ipo not exist then insert
			IpoPlanedEntity IpoEntity = ipoService.updateIpo(ipo);
			return ResponseEntity.status(HttpStatus.CREATED).body(IpoEntity); 
		}
	}
}
