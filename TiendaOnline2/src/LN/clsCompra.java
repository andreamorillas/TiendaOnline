package LN;

import java.io.Serializable;

import COMUN.clsConstantes;
import COMUN.clsExcepcionParametroIncorrecto;

public class clsCompra implements itfProperty, Serializable
{

	private String nickname;
	private int codigo;
	private int id;
	public clsCompra(String nickname, int codigo, int id) {
		super();
		this.nickname = nickname;
		this.codigo = codigo;
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getStringProperty(String propiedad) {
		switch(propiedad)
		{
			case clsConstantes.NICKCOMPRA: return this.getNickname();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	}
	@Override
	public Integer getIntegerProperty(String propiedad) {
		switch(propiedad)
		{
			case clsConstantes.CODIGOCOMPRA: return this.getCodigo();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
			}
	@Override
	public Float getFloatProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double getDoubleProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public char getCharProperty(String propiedad) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean getBooleanProperty(String propiedad) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsCompra other = (clsCompra) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "clsCompra [nickname=" + nickname + ", codigo=" + codigo
				+ ", id=" + id + "]";
	}
	
	
	
	
	
	
}
