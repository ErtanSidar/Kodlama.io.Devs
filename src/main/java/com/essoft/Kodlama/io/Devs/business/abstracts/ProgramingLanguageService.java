package com.essoft.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.CreateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.GetAllProgramingLanguage;
import com.essoft.Kodlama.io.Devs.business.requests.PrograminLanguage.UpdateProgramingLanguage;
import com.essoft.Kodlama.io.Devs.core.utilities.results.DataResult;
import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;

public interface ProgramingLanguageService {
	DataResult<List<GetAllProgramingLanguage>> getAll();

	DataResult<GetAllProgramingLanguage> findById(int id);

	Result add(CreateProgramingLanguage createProgramingLanguage);

	Result update(UpdateProgramingLanguage updateProgramingLanguage);

	Result delete(int id);
}
