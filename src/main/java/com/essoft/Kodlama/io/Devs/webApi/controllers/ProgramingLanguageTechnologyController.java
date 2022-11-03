package com.essoft.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.essoft.Kodlama.io.Devs.business.abstracts.ProgramingLanguageTechnologyService;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.CreateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.GetAllProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.UpdateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/sub-technology")
public class ProgramingLanguageTechnologyController {

	private ProgramingLanguageTechnologyService programingLanguageTechnologyService;

	@Autowired
	public ProgramingLanguageTechnologyController(
			ProgramingLanguageTechnologyService programingLanguageTechnologyService) {
		super();
		this.programingLanguageTechnologyService = programingLanguageTechnologyService;
	}

	@GetMapping("getall")
	public DataResult<List<GetAllProgramingLanguageTechnology>> getAll() {
		return this.programingLanguageTechnologyService.getAll();
	}

	@GetMapping("findById/{id}")
	public DataResult<GetAllProgramingLanguageTechnology> findById(@PathVariable int id) {
		return this.programingLanguageTechnologyService.findById(id);
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateProgramingLanguageTechnology createProgramingLanguageTechnology) {
		return this.programingLanguageTechnologyService.add(createProgramingLanguageTechnology);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateProgramingLanguageTechnology updateProgramingLanguageTechnology) {
		return this.programingLanguageTechnologyService.update(updateProgramingLanguageTechnology);
	}

	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.programingLanguageTechnologyService.delete(id);
	}

}
