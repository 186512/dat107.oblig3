package oblig3;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;
    
    @Column(unique = true, nullable = false)
    private String brukernavn;
    
    private String fornavn;
    private String etternavn;
    private Date ansettelsesdato;
    private String stilling;
    private double månedslønn;

    @ManyToOne
    @JoinColumn(name = "avdeling_id", nullable = false)
    private Avdeling avdeling;
    
    @ManyToMany(mappedBy = "ansatte")
    private List<Prosjekt> prosjekter;

	public int getAnsattId() {
		return ansattId;
	}

	public void setansattId(int ansattId) {
		this.ansattId = ansattId;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Date getAnsettelsesdato() {
		return ansettelsesdato;
	}

	public void setAnsettelsesdato(Date ansettelsesdato) {
		this.ansettelsesdato = ansettelsesdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getMaanedslonn() {
		return månedslønn;
	}

	public void setMaanedslonn(double månedslønn) {
		this.månedslønn = månedslønn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public List<Prosjekt> getProsjekter() {
		return prosjekter;
	}

	public void setProsjekter(List<Prosjekt> prosjekter) {
		this.prosjekter = prosjekter;
	}

	@Override
	public String toString() {
		return "Ansatt [id=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", månedslønn=" + månedslønn
				+ ", avdeling=" + avdeling + ", prosjekter=" + prosjekter + "]";
	}

  
}
