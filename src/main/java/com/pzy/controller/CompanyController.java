package com.pzy.controller;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzy.entity.Company;
import com.pzy.service.CompanyService;


/***
 * @author panchaoyang
 *
 */
@Controller
@RequestMapping("/admin/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("index")
	public String index() {
		return "admin/company/index";
	}
	@RequestMapping("create")
	public String create() {
		return "admin/company/create";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(
			@RequestParam(value = "sEcho", defaultValue = "1") int sEcho,
			@RequestParam(value = "iDisplayStart", defaultValue = "0") int iDisplayStart,
			@RequestParam(value = "iDisplayLength", defaultValue = "10") int iDisplayLength, String companyname
			) throws ParseException {
		int pageNumber = (int) (iDisplayStart / iDisplayLength) + 1;
		int pageSize = iDisplayLength;
		Page<Company> companys = companyService.findAll(pageNumber, pageSize, companyname);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", companys.getContent());
		map.put("iTotalRecords", companys.getTotalElements());
		map.put("iTotalDisplayRecords", companys.getTotalElements());
		map.put("sEcho", sEcho);
		return map;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public  String save(Company company, Model mode) {
		companyService.save(company);
		mode.addAttribute("state", "success");
		mode.addAttribute("msg", "保存成功");
		return "admin/company/create";
	}
	@RequestMapping(value = "/update")
	@ResponseBody
	public Map<String, Object> update(Company company) {
		companyService.save(company);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");
		map.put("msg", "保存成功");
		return map;
	}
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			companyService.delete(id);
			map.put("state", "success");
			map.put("msg", "删除成功");
		} catch (Exception e) {
			map.put("state", "error");
			map.put("msg", "删除失败，外键约束");
		}
        return map;
	}

	@RequestMapping(value = "/get/{id}")
	@ResponseBody
	public Map<String, Object> get(@PathVariable Long id ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("object", companyService.find(id));
		map.put("state", "success");
		map.put("msg", "成功");
		return map;
	}
}
