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
@Table(name = "tb_ESTOQUE")
@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq_id")
	@SequenceGenerator(sequenceName = "estoque_seq_id", name = "estoque_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "PRODUTO_ID")
	private String nomeProduto;
	
	@Column(name = "QUANTIDADE")
	public Integer quantidade;

	@Column(name = "UNIDADE")
	public String unidadeMedida;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Estoque toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		Estoque entity = modelMapper.map(this, Estoque.class);
		return entity;
	}

}
