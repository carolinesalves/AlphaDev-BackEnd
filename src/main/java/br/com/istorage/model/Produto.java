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
@Table(name = "tb_PRODUTOS")
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq_id")
	@SequenceGenerator(sequenceName = "produto_seq_id", name = "produto_seq_id", allocationSize = 1)
	private int id;

	@Column(name = "NOME")
	private String nomeProduto;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "QUANTIDADE_MINIMA")
	private Integer quantidadeMinima;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nomeProduto;
	}

	public void setNome(String nome) {
		this.nomeProduto = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidadeMinima;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidadeMinima = quantidade;
	}
	
	public Produto toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Produto entity = modelMapper.map(this, Produto.class);
		return entity;
	}


}
