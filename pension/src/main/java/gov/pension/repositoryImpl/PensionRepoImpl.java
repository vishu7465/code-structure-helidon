package gov.pension.repositoryImpl;

import java.sql.Timestamp;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import gov.pension.entity.MstDrRate;
import gov.pension.exception.IFMSException;
import gov.pension.repository.MstDrRateRepo;

@ApplicationScoped
public class PensionRepoImpl implements MstDrRateRepo{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public MstDrRate saveMstDrRate(MstDrRate drRate) throws IFMSException {
		MstDrRate mstDrRate=new MstDrRate();
		Timestamp instant= Timestamp.from(Instant.now());  

mstDrRate.setDrRateId(drRate.getDrRateId());
mstDrRate.setPayCmmsn(drRate.getPayCmmsn());
mstDrRate.setSalMin(drRate.getSalMin());
mstDrRate.setSalMax(drRate.getSalMax());
mstDrRate.setMinAmt(drRate.getMinAmt());
mstDrRate.setEffDate(instant);
mstDrRate.setAppliedDate(instant);
mstDrRate.setDrRate(drRate.getDrRate());
mstDrRate.setDrRateFix(drRate.getDrRateFix());
mstDrRate.setIsDp(drRate.getIsDp());
mstDrRate.setDrFlag(drRate.getDrFlag());
mstDrRate.setIsPension(drRate.getDrFlag());
mstDrRate.setIsGpo(drRate.getIsGpo());
mstDrRate.setIsActive(drRate.getIsActive());
mstDrRate.setCreatedBy(drRate.getCreatedBy());
mstDrRate.setCreatedDt(instant);
mstDrRate.setModifiedBy(drRate.getModifiedBy());
mstDrRate.setModifiedDt(drRate.getModifiedDt());

entityManager.persist(mstDrRate);
		return mstDrRate;
	}

	
	
	
}
