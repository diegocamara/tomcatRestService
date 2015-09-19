package br.com.opendata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "TBEXEMPLO")
public class ExemploEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO")
	private int codigo;

	@Column
	@Size(min = 1, max = 100)
	private int valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.valor).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ExemploEntity) {
			final ExemploEntity exemploEntity = (ExemploEntity) obj;
			return new EqualsBuilder().append(this.valor, exemploEntity.getValor())
					.isEquals();
		} else {
			return false;
		}

	}

}
