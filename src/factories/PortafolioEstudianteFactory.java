package factories;

import modelo.*;
import productosImpl.*;
import servicios.AprobadorDeCreditos;

public class PortafolioEstudianteFactory implements AbstractFactoryPortafolio {

    private AprobadorDeCreditos aprobador;

    public PortafolioEstudianteFactory(AprobadorDeCreditos aprobador) {
        this.aprobador = aprobador;
    }

    @Override
    public CuentaNomina createCuentaNomina(Usuario usuario) {
        return null;
    }

    @Override
    public CuentaAhorros createCuentaAhorros(Usuario usuario) {
        
        return new CuentaAhorrosImpl.Builder()
                .setTitular(usuario.getNumeroDocumento())
                .setSaldoInicial(50000)  
                .setTasaInteres(0.01)  
                .build();
    }

    @Override
    public TarjetaCredito createTarjetaCredito(Usuario usuario) {
    	
    	if (aprobador.aprobarCredito(usuario.getNumeroDocumento(), 0, AprobadorDeCreditos.TipoCredito.TARJETA_CREDITO)) {
    	double cupoAsignado = aprobador.calcularCupoTarjetaCredito(usuario.getIngresoMensual());
    	return new TarjetaCreditoImpl.Builder()
    	.setTitular(usuario.getNumeroDocumento())
    	.setLimiteCredito(cupoAsignado * 0.25)
    	.build();
    	}
    	return null;
    	}
    
    @Override
    public LibreInversion createLibreInversion(Usuario usuario) {
    	
        return null;
    }

    @Override
    public CreditoHipotecario createCreditoHipotecario(Usuario usuario) {
       
        return null;
    }

    @Override
    public CDT createCDT(Usuario usuario) {
        
        return new CDTImpl.Builder()
                .setTitular(usuario.getNumeroDocumento())
                .setMontoInvertido(200000) 
                .setPlazoDias(180) 
                .build();
    }

    @Override
    public FondoDeInversion createFondoDeInversion(Usuario usuario) {
        
        return new FondoDeInversionImpl.Builder()
                .setTitular(usuario.getNumeroDocumento())
                .setMontoInvertido(200000) 
                .build();
    }
}
