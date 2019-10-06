package com.example.inmobiliaria;

public class Pagos {
    private int nroPago;
    private String fechaPago;
    private double importe;
    private String dire;

    public Pagos(int nroPago, String fechaPago, double importe, String dire) {
        this.nroPago = nroPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
        this.dire = dire;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }
}
