package br.edu.infnet.apps3amazontp3.model;

import javax.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	@Column(name = "email")
    private String email;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @Column(name = "nome_arquivo_foto")
    private String nomeArquivoFoto;

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArquivoFoto() {
        return nomeArquivoFoto;
    }

    public void setNomeArquivoFoto(String nomeArquivoFoto) {
        this.nomeArquivoFoto = nomeArquivoFoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}



