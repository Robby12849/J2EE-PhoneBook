package debari.roberto.database.pojo;
import java.util.Objects;

public class Nome {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private int ntel;
    
	public Nome( String nome, String cognome, String email,int ntel,int id ) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.ntel = ntel;
		this.id=id;
	}
	public Nome(String nome, String cognome, String email, int ntel) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.ntel = ntel;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNtel() {
        return ntel;
    }

    public void setNtel(int ntel) {
        this.ntel = ntel;
    }

	@Override
	public int hashCode() {
		return Objects.hash(cognome, email, id, nome, ntel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nome other = (Nome) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nome, other.nome) && ntel == other.ntel;
	}    

	
}
