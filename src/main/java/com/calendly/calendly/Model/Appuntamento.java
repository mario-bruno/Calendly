package com.calendly.calendly.Model;

import javafx.beans.property.*;
import javafx.scene.control.Button;

public class Appuntamento {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty email;
    private final SimpleStringProperty identificativo;
    private final SimpleStringProperty numero;
    private final SimpleStringProperty data;
    private final SimpleStringProperty dipendente;
    private final SimpleStringProperty servizio;
    private final SimpleDoubleProperty prezzo;
    public Appuntamento(Integer id, String email, String nome, String cognome, String numero, String data, String dipendente, String servizio, Double prezzo){
        this.id = new SimpleIntegerProperty(id);
        this.email = new SimpleStringProperty(email);
        this.identificativo = new SimpleStringProperty(nome + " " + cognome);
        this.numero = new SimpleStringProperty(numero);
        this.data = new SimpleStringProperty(data);
        this.dipendente = new SimpleStringProperty(dipendente);
        this.servizio = new SimpleStringProperty(servizio);
        this.prezzo = new SimpleDoubleProperty(prezzo);
    }

    public Appuntamento(String [] s){
        this.id = new SimpleIntegerProperty(Integer.parseInt(s[0]));
        this.email = new SimpleStringProperty(s[1]);
        this.identificativo = new SimpleStringProperty(s[2]+" "+s[3]);
        this.numero = new SimpleStringProperty(s[4]);
        this.data = new SimpleStringProperty(s[5]);
        this.dipendente = new SimpleStringProperty(s[6]);
        this.servizio = new SimpleStringProperty(s[7]);
        this.prezzo = new SimpleDoubleProperty(Double.parseDouble(s[8]));
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getIdentificativo() {
        return identificativo.get();
    }

    public SimpleStringProperty identificativoProperty() {
        return identificativo;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo.set(identificativo);
    }

    public String getNumero() {
        return numero.get();
    }

    public SimpleStringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getData() {
        return data.get();
    }

    public SimpleStringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public String getDipendente() {
        return dipendente.get();
    }

    public SimpleStringProperty dipendenteProperty() {
        return dipendente;
    }

    public void setDipendente(String dipendente) {
        this.dipendente.set(dipendente);
    }

    public String getServizio() {
        return servizio.get();
    }

    public SimpleStringProperty servizioProperty() {
        return servizio;
    }

    public void setServizio(String servizio) {
        this.servizio.set(servizio);
    }

    public double getPrezzo() {
        return prezzo.get();
    }

    public SimpleDoubleProperty prezzoProperty() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo.set(prezzo);
    }

}
