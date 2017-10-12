package com.example.chris.contactodb;

/**
 * Created by chris on 11/10/2017.
 */

public class Contacto {
    private String usuario;
    private String email;
    private String tw;
    private String fechaN;
    private int tel,id;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getTw() {
        return tw;
    }

    public String getFechaN() {
        return fechaN;
    }

    public int getTel() {
        return tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.usuario + "\n" + this.email;
    }
}
