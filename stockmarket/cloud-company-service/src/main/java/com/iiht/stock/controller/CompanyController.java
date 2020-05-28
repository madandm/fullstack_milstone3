package com.iiht.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@PostMapping("/all")
	public List<CompanyModel> findAll(@RequestBody String key){
		return companyService.findAll(key);
	}
	@PostMapping("/key")
	public CompanyModel findByNameOrCode(@RequestBody String key){
		return companyService.findByNameOrCode(key);
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
	public void deleteAll(@RequestBody String id){
	    String[] stuList = id.split(",");
	    List<Integer> LString = new ArrayList<Integer>();
	    for(String str : stuList){
	        LString.add(new Integer(str));
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
