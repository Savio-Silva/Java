package com.example.cadastro.de.clientes.models;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "cad_clients")
public class CadastroModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idclient;
    private String name;
    private String adress;
    private String email;

    public UUID getIdclient() {
        return idclient;
    }

    public void setIdclient(UUID idclient) {
        this.idclient = idclient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
