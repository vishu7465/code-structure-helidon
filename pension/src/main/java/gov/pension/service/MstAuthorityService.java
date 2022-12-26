package gov.pension.service;

import javax.enterprise.context.Dependent;

import gov.pension.entity.MstAuthority;
import gov.pension.exception.IFMSException;

@Dependent
public interface MstAuthorityService{

	public MstAuthority saveMstAuthority(MstAuthority authority) throws IFMSException;
	
}
