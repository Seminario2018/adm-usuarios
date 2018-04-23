package modelo.proyectos;

import sun.security.krb5.Realm;

public interface ISubsidios {
	
	public int getAnio();
	public void setAnio(int anio);
	public String getDisposicion();
	public void setDisposicion(String disposicion);
	public float getMonto();
	public void setMonto(float monto);
	public String getOberservaciones();
	public void setObservaciones(String observaciones);
	
	public ISubsidios clone();

}
