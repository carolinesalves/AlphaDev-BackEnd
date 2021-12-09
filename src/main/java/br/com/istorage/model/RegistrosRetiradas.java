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
@Table(name = "tb_REGISTROS")
@Entity
public class RegistrosRetiradas {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registros_seq_id")
	@SequenceGenerator(sequenceName = "registros_seq_id", name = "registros_seq_id", allocationSize = 1)
	private int id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "QUANTIDADE")
	private int quantidade;

	@Column(name = "DATA_RETIRADA")
	private String dataRetirada;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public RegistrosRetiradas toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		RegistrosRetiradas entity = modelMapper.map(this, RegistrosRetiradas.class);
		return entity;
	}
}
