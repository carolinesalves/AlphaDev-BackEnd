package br.com.istorage.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_RECEBIDOS")
@Entity
public class Recebidos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recebidos_seq_id")
	@SequenceGenerator(sequenceName = "recebidos_seq_id", name = "recebidos_seq_id", allocationSize = 1)
	private int id;

	@Column(name = "DATA_RECEBIDO")
	private Date dataRecebido;

	@Column(name = "QUANTIDADE")
	private int quantidade;

	@Column(name = "DATA_VALIDADE")
	private Date validade;

	@OneToOne
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataRecebido() {
		return dataRecebido;
	}

	public void setDataRecebido(Date dataRecebido) {
		this.dataRecebido = dataRecebido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
