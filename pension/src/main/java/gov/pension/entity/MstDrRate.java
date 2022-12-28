package gov.pension.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_DR_RATE")
public class MstDrRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DR_RATE_ID")
	private int drRateId;
	@Column(name = "PAY_CMMSN")
	private String payCmmsn;
	@Column(name = "SAL_MIN")
	private int salMin;
	@Column(name = "SAL_MAX")
	private int salMax;
	@Column(name = "MIN_AMT")
	private int minAmt;
	@Column(name = "EFF_DATE")
	private Timestamp effDate;
	@Column(name = "APPLIED_DATE")
	private Timestamp appliedDate;
	@Column(name = "DR_RATE")
	private Double drRate;
	@Column(name = "DR_RATE_FIX")
	private int drRateFix;
	@Column(name = "IS_DP")
	private int isDp;
	@Column(name = "DR_FLAG")
	private String drFlag;
	@Column(name = "IS_PENTION")
	private String isPension;
	@Column(name = "IS_GPO")
	private String isGpo;
	@Column(name = "IS_ACTIVE")
	private int isActive;
	@Column(name = "CREATED_BY")
	private int createdBy;
	@Column(name = "CREATED_DT")
	private Timestamp createdDt;
	@Column(name = "MODIFIED_BY")
	private int modifiedBy;
	@Column(name = "MODIFIED_DT")
	private Timestamp modifiedDt;
}