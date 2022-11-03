package com.essoft.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essoft.Kodlama.io.Devs.business.abstracts.ProgramingLanguageTechnologyService;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.CreateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.GetAllProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.UpdateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.core.utilities.mapping.ModelMapperService;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.ErrorResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;
import com.essoft.Kodlama.io.Devs.core.utilities.results.SuccessDataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.SuccessResult;
import com.essoft.Kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageTechnologyRepository;
import com.essoft.Kodlama.io.Devs.entities.ProgramingLanguageTechnology;

@Service
public class ProgramingLanguageTechnologyManager implements ProgramingLanguageTechnologyService {

	private ProgramingLanguageTechnologyRepository programingLanguageTechnologyRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProgramingLanguageTechnologyManager(
			ProgramingLanguageTechnologyRepository programingLanguageTechnologyRepository,
			ModelMapperService modelMapperService) {
		this.programingLanguageTechnologyRepository = programingLanguageTechnologyRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<GetAllProgramingLanguageTechnology>> getAll() {
		List<ProgramingLanguageTechnology> programingLanguageTechnologies = this.programingLanguageTechnologyRepository
				.findAll();
		List<GetAllProgramingLanguageTechnology> response = programingLanguageTechnologies
				.stream().map(programingLanguageTechnology -> modelMapperService.forDto()
						.map(programingLanguageTechnology, GetAllProgramingLanguageTechnology.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProgramingLanguageTechnology>>(response);
	}

	@Override
	public DataResult<GetAllProgramingLanguageTechnology> findById(int id) {
		ProgramingLanguageTechnology programingLanguageTechnology = programingLanguageTechnologyRepository.findById(id)
				.get();
		GetAllProgramingLanguageTechnology response = this.modelMapperService.forDto().map(programingLanguageTechnology,
				GetAllProgramingLanguageTechnology.class);
		return new SuccessDataResult<>(response);
	}

	@Override
	public Result add(CreateProgramingLanguageTechnology createProgramingLanguageTechnology) {
		ProgramingLanguageTechnology programingLanguageTechnology = modelMapperService.forRequest()
				.map(createProgramingLanguageTechnology, ProgramingLanguageTechnology.class);
		this.programingLanguageTechnologyRepository.save(programingLanguageTechnology);
		return new SuccessResult("programing language technology added");
	}

	@Override
	public Result update(UpdateProgramingLanguageTechnology updateProgramingLanguageTechnology) {
		ProgramingLanguageTechnology programingLanguageTechnology = modelMapperService.forRequest().map(updateProgramingLanguageTechnology, ProgramingLanguageTechnology.class);
		this.programingLanguageTechnologyRepository.save(programingLanguageTechnology);
		return new SuccessResult("programing language technology updated");
	}

	@Override
	public Result delete(int id) {
		if (programingLanguageTechnologyRepository.existsById(id)) {
			programingLanguageTechnologyRepository.deleteById(id);
			return new SuccessResult("programing language technology deleted");
		} else
			return new ErrorResult();
	}

}
