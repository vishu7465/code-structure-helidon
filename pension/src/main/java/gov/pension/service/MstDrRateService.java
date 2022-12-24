package gov.pension.service;

import javax.enterprise.context.Dependent;

import gov.pension.entity.MstDrRate;

@Dependent
public interface MstDrRateService{

	public MstDrRate saveMstDrRate(MstDrRate drRate);
	
}
