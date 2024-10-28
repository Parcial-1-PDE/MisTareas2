package com.myproyect.mistareas2;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String nombre;
    private String descripcion;
    private String fecha;
    private String prioridad;
    private double coste;

    public Tarea(String nombre, String descripcion, String fecha, String prioridad, double coste) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.coste = coste;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public String getPrioridad() { return prioridad; }
    public double getCoste() { return coste; }
}
