/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thecorralcoffee.sistemahuellitas.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author oliva
 */
public class Cita {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String diagnostico;
    private int mascotaId;
    private int vetId;

    public Cita() {
    }

    public Cita(int id, LocalDate fecha, LocalTime hora, String motivo, String diagnostico, int mascotaId, int vetId) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.mascotaId = mascotaId;
        this.vetId = vetId;
    }

    public Cita(LocalDate fecha, LocalTime hora, String motivo, String diagnostico, int mascotaId, int vetId) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.mascotaId = mascotaId;
        this.vetId = vetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    
}
