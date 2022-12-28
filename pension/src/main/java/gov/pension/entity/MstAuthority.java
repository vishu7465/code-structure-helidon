package gov.pension.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;

import lombok.Data;

@Data
@Entity
@Table(name = "MST_AUTHORITY")
public class MstAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTHORITY_ID")
	private int authorityId;
	@Column(name = "AUTHORITY_CODE")
	private String authorityCode;
	@Column(name = "AUTHORITY_NAME")
	private String authorityName;
	@Column(name = "NEW_RVSN_FLAG")
	private String newRvsnFlag;
	@Column(name = "PENSION_FLAG")
	private String pensionFlag;
	@Column(name = "NOC")
	private int noc;
	@Column(name = "PAPER_TYPE")
	private String paperType;
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






