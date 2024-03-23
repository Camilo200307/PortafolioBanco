package modelo;

public class Usuario {
    private String numeroDocumento;
    private TipoCliente tipoCliente;
    private boolean esEmpleado;
    private String nitEmpresa;
    private int edad;
    private int scoreDatacredito;
    private double ingresoMensual;

   
    public Usuario(String numeroDocumento, TipoCliente tipoCliente,boolean esEmpleado, String nitEmpresa, int edad, int scoreDatacredito, double ingresoMensual) {
        this.numeroDocumento = numeroDocumento;
        this.tipoCliente = tipoCliente;
        this.esEmpleado = esEmpleado;
        this.nitEmpresa = nitEmpresa;
        this.edad = edad;
        this.scoreDatacredito = scoreDatacredito;
        this.ingresoMensual = ingresoMensual;
    }

    // Getters
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public int getEdad() {
        return edad;
    }

    public int getScoreDatacredito() {
        return scoreDatacredito;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setScoreDatacredito(int scoreDatacredito) {
        this.scoreDatacredito = scoreDatacredito;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }
}
