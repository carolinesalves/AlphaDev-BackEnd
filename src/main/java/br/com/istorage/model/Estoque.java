package br.com.istorage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_ESTOQUE")
@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq_id")
	@SequenceGenerator(sequenceName = "estoque_seq_id", name = "estoque_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "QUANTIDADE")
	public int quantidade;

	@Column(name = "UNIDADE")
	public String unidade;

//	@Column(name = "DATA_VALIDADE")
//	public Date validade;

	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "FORNECEDOR_ID")
	private Fornecedor fornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

//	public Date getValidade() {
//		return validade;
//	}
//
//	public void setValidade(Date validade) {
//		this.validade = validade;
//	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Estoque toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Estoque entity = modelMapper.map(this, Estoque.class);
		return entity;
	}

}
