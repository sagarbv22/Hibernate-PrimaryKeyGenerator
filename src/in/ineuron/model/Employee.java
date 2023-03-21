package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicUpdate(value = true)
public class Employee implements Serializable {
	
	@Id
	@GenericGenerator(name = "gen1", strategy = "identity")//or increment
	@GeneratedValue(generator = "gen1")
	private Integer eid;
	private String ename;
	private String ecompany;
	private String ecity;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcompany() {
		return ecompany;
	}

	public void setEcompany(String ecompany) {
		this.ecompany = ecompany;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", ecompany=" + ecompany + ", ecity=" + ecity + "]";
	}
	
	
}
