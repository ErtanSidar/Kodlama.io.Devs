package com.essoft.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.essoft.Kodlama.io.Devs.business.abstracts.ProgramingLanguageService;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.CreateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.GetAllProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.UpdateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.core.utilities.mapping.ModelMapperService;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.ErrorResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;
import com.essoft.Kodlama.io.Devs.core.utilities.results.SuccessDataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.SuccessResult;
import com.essoft.Kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import com.essoft.Kodlama.io.Devs.entities.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
	private ProgramingLanguageRepository programingLanguageRepository;
	private ModelMapperService modelMapperService;

	public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository,
			ModelMapperService modelMapperService) {
		this.programingLanguageRepository = programingLanguageRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<GetAllProgramingLanguage>> getAll() {
		List<ProgramingLanguage> programingLanguages = this.programingLanguageRepository.findAll();
		List<GetAllProgramingLanguage> response = programingLanguages.stream()
				.map(programingLanguage -> modelMapperService.forDto().map(programingLanguage,
						GetAllProgramingLanguage.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllProgramingLanguage>>(response);
	}

	@Override
	public DataResult<GetAllProgramingLanguage> findById(int id) {
		ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id).get();
		GetAllProgramingLanguage response = this.modelMapperService.forDto().map(programingLanguage,
				GetAllProgramingLanguage.class);
		return new SuccessDataResult<>(response);
	}

	@Override
	public Result add(CreateProgramingLanguage createProgramingLanguage) {
		ProgramingLanguage programingLanguage = modelMapperService.forRequest().map(createProgramingLanguage,
				ProgramingLanguage.class);
		this.programingLanguageRepository.save(programingLanguage);
		return new SuccessResult("Programing language added");
	}

	@Override
	public Result update(UpdateProgramingLanguage updateProgramingLanguage) {
		ProgramingLanguage programingLanguage = modelMapperService.forRequest().map(updateProgramingLanguage,
				ProgramingLanguage.class);
		this.programingLanguageRepository.save(programingLanguage);
		return new SuccessResult("programing language updated");
	}

	@Override
	public Result delete(int id) {
		if (programingLanguageRepository.existsById(id)) {
			programingLanguageRepository.deleteById(id);
			return new SuccessResult("programing language deleted");
		} else
			return new ErrorResult();
	}

}
