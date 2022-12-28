package gov.pension.repositoryImpl;

import java.sql.Timestamp;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import gov.pension.entity.MstAuthority;
import gov.pension.exception.PensionException;
import gov.pension.repository.MstAuthorityRepo;

@ApplicationScoped
public class MstAuthorityRepoImpl implements MstAuthorityRepo{
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public String saveMstAuthority(MstAuthority authority) throws PensionException  {
		MstAuthority mstAuthority=new MstAuthority();
		try {
		
		Timestamp instant= Timestamp.from(Instant.now());  
		mstAuthority.setAuthorityId(authority.getAuthorityId());
		mstAuthority.setAuthorityCode(authority.getAuthorityCode());
		mstAuthority.setAuthorityName(authority.getAuthorityName());
		mstAuthority.setNewRvsnFlag(authority.getNewRvsnFlag());
		mstAuthority.setPensionFlag(authority.getPensionFlag());
		mstAuthority.setNoc(authority.getNoc());
		mstAuthority.setPaperType(authority.getPaperType());
		mstAuthority.setIsActive(authority.getIsActive());
		mstAuthority.setCreatedBy(authority.getCreatedBy());
		mstAuthority.setCreatedDt(instant);
		mstAuthority.setModifiedBy(authority.getModifiedBy());
		mstAuthority.setModifiedDt(instant);
		entityManager.persist(mstAuthority);
		return "Data Saved Successfully";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new PensionException(e.getMessage());
		}
		
	}

}
