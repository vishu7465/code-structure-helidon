package gov.pension.service;

import javax.enterprise.context.Dependent;

import gov.pension.entity.MstDrRate;
import gov.pension.exception.IFMSException;

@Dependent
public interface MstDrRateService{

	public MstDrRate saveMstDrRate(MstDrRate drRate) throws IFMSException;
	
}
