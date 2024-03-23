package modelo;

public interface AbstractFactoryPortafolio {
	
	public CuentaNomina createCuentaNomina(Usuario usuario);
	public CuentaAhorros createCuentaAhorros(Usuario usuario);
	public TarjetaCredito createTarjetaCredito(Usuario usuario);
	public LibreInversion createLibreInversion(Usuario usuario);
	public CreditoHipotecario createCreditoHipotecario(Usuario usuario);
	public CDT createCDT(Usuario usuario);
	public FondoDeInversion createFondoDeInversion(Usuario usuario);
}
