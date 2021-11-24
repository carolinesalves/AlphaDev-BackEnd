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
@Table(name = "tb_PEDIDOS")
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq_id")
	@SequenceGenerator(sequenceName = "pedido_seq_id", name = "pedido_seq_id", allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "PRODUTO_ID")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn (name ="FORNECEDOR_ID")
	private Fornecedor fornecedor;
	
	@Column(name = "QUANTIDADE")
	private String quantidade;
	
	@Column(name = "UNIDADE_MEDIDA")
	private String unidadeMedida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public Pedido toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Pedido entity = modelMapper.map(this, Pedido.class);
		return entity;
	
	}
}
