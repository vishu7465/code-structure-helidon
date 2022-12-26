package gov.pension.serviceImpl;

import javax.inject.Inject;

import gov.pension.entity.MstAuthority;
import gov.pension.exception.IFMSException;
import gov.pension.repository.MstAuthorityRepo;
import gov.pension.service.MstAuthorityService;

public class MstAuthorityServiceImpl implements MstAuthorityService {

	@Inject
	MstAuthorityRepo authorityRepo;

	@Override
	public MstAuthority saveMstAuthority(MstAuthority authority) throws IFMSException {

		return authorityRepo.saveMstAuthority(authority);
	}

}
