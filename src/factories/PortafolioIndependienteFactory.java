package factories;

import modelo.*;
import productosImpl.*;
import servicios.AprobadorDeCreditos;

public class PortafolioIndependienteFactory implements AbstractFactoryPortafolio {

    private AprobadorDeCreditos aprobador;

    public PortafolioIndependienteFactory(AprobadorDeCreditos aprobador) {
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
                .setSaldoInicial(100000)  
                .setTasaInteres(0.02)  
                .build();
    }

    @Override
    public TarjetaCredito createTarjetaCredito(Usuario usuario) {
        
        if (aprobador.aprobarCredito(usuario.getNumeroDocumento(), 0, AprobadorDeCreditos.TipoCredito.TARJETA_CREDITO)) {
            double cupoAsignado = aprobador.calcularCupoTarjetaCredito(usuario.getIngresoMensual());
            return new TarjetaCreditoImpl.Builder()
                    .setTitular(usuario.getNumeroDocumento())
                    .setLimiteCredito(cupoAsignado)
                    .build();
        }
        return null;
    }

    @Override
    public LibreInversion createLibreInversion(Usuario usuario) {
        
        if (aprobador.aprobarCredito(usuario.getNumeroDocumento(), 1000000, AprobadorDeCreditos.TipoCredito.LIBRE_INVERSION)) {
            return new LibreInversionImpl.Builder()
                    .setTitular(usuario.getNumeroDocumento())
                    .setMontoInvertido(1000000)  
                    .build();
        }
        return null;
    }

    @Override
    public CreditoHipotecario createCreditoHipotecario(Usuario usuario) {
        
        double montoSolicitado = 150000000;  
        if (aprobador.aprobarCredito(usuario.getNumeroDocumento(), montoSolicitado, AprobadorDeCreditos.TipoCredito.HIPOTECARIO)) {
            return new CreditoHipotecarioImpl.Builder()
                    .setTitular(usuario.getNumeroDocumento())
                    .setMontoCredito(montoSolicitado)
                    .build();
        }
        return null;
    }

    @Override
    public CDT createCDT(Usuario usuario) {
        
        return new CDTImpl.Builder()
                .setTitular(usuario.getNumeroDocumento())
                .setMontoInvertido(1000000)  
                .setPlazoDias(360) 
                .build();
    }

    @Override
    public FondoDeInversion createFondoDeInversion(Usuario usuario) {
        
        return new FondoDeInversionImpl.Builder()
                .setTitular(usuario.getNumeroDocumento())
                .setMontoInvertido(500000)  
                .build();
    }

    
}
