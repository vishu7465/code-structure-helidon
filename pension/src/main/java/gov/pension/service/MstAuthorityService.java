package gov.pension.service;

import javax.enterprise.context.ApplicationScoped;

import gov.pension.entity.MstAuthority;
import gov.pension.exception.PensionException;

@ApplicationScoped
public interface MstAuthorityService{

	public String saveMstAuthority(MstAuthority authority) throws PensionException;
	
}
