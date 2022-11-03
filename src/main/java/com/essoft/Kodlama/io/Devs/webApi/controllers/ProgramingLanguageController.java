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

import com.essoft.Kodlama.io.Devs.business.abstracts.ProgramingLanguageService;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.CreateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.GetAllProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.UpdateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/languages")
public class ProgramingLanguageController {
	private ProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguageController(ProgramingLanguageService programingLanguageService) {

		this.programingLanguageService = programingLanguageService;
	}

	@GetMapping("getall")
	public DataResult<List<GetAllProgramingLanguage>> getAll() {
		return this.programingLanguageService.getAll();
	}

	@GetMapping("findById/{id}")
	public DataResult<GetAllProgramingLanguage> findById(@PathVariable int id) {
		return this.programingLanguageService.findById(id);
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateProgramingLanguage createProgramingLanguage) {
		return this.programingLanguageService.add(createProgramingLanguage);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateProgramingLanguage updateProgramingLanguage) {
		return this.programingLanguageService.update(updateProgramingLanguage);
	}

	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.programingLanguageService.delete(id);
	}
}
