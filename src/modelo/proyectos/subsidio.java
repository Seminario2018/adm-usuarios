package modelo.proyectos;

public class subsidio implements ISubsidios {

	private int anio;
	private String disposicion;
	private float monto;
	private String observaciones;
	public subsidio(int anio, String disposicion, float monto, String observaciones) {
		super();
		this.anio = anio;
		this.disposicion = disposicion;
		this.monto = monto;
		this.observaciones = observaciones;
	}
	
	@Override
	public int getAnio() {
		return anio;
	}
	
	@Override
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	@Override
	public String getDisposicion() {
		return disposicion;
	}
	
	@Override
	public void setDisposicion(String disposicion) {
		this.disposicion = disposicion;
	}
	
	@Override
	public float  getMonto() {
		return monto;
	}
	
	@Override
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	@Override
	public String getOberservaciones(){
		return observaciones;
	}
	
	@Override
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@Override
	public ISubsidios clone() {
		return new subsidio(anio, disposicion, monto, observaciones);
		
	}
	
	
}
