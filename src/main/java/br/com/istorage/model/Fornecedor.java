package br.com.istorage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_FORNECEDORES")
@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq_id")
	@SequenceGenerator(sequenceName = "fornecedor_seq_id", name = "fornecedor_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "NOME_FORNECEDOR")
	public String nomeFornecedor;

	@Column(name = "CNPJ")
	public String cnpj;

	@Column(name = "INSCRICAO_ESTADUAL")
	public String inscricaoEsdadual;

	@Column(name = "OBSERVACAO")
	public String observacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEsdadual() {
		return inscricaoEsdadual;
	}

	public void setInscricaoEsdadual(String inscricaoEsdadual) {
		this.inscricaoEsdadual = inscricaoEsdadual;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Fornecedor toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Fornecedor entity = modelMapper.map(this, Fornecedor.class);
		return entity;
	}
}
