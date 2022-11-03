package com.essoft.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.CreateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.GetAllProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguageTechnology.UpdateProgramingLanguageTechnology;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;

public interface ProgramingLanguageTechnologyService {
	DataResult<List<GetAllProgramingLanguageTechnology>> getAll();

	DataResult<GetAllProgramingLanguageTechnology> findById(int id);

	Result add(CreateProgramingLanguageTechnology createProgramingLanguageTechnology);

	Result update(UpdateProgramingLanguageTechnology updateProgramingLanguageTechnology);

	Result delete(int id);
}
