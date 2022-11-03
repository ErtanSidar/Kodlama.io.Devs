package com.essoft.Kodlama.io.Devs.core.utilities.business;

import com.essoft.Kodlama.io.Devs.core.utilities.results.Result;

public class BusinessRules {

	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}

}
