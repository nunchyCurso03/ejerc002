package es.santander.ascender.ejerc002.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Entity
public class Columna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // primary key

    @Column(name="numero_largo_1" )
    private long a1;

    @Min(value=5)
    @Column(name="numero_largo_2", nullable = false, unique = true )
    private Long a2;

    //Tipos de datos
        private String texto;

        private Boolean verdiFalso;
        private boolean primiBolean;

        private char letra;
        private Character letraReferencia;

        @Email
        private String email;




    //metemos getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getA1() {
        return a1;
    }

    public void setA1(long a1) {
        this.a1 = a1;
    }

    public Long getA2() {
        return a2;
    }

    public void setA2(Long a2) {
        this.a2 = a2;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getVerdiFalso() {
        return verdiFalso;
    }

    public void setVerdiFalso(Boolean verdiFalso) {
        this.verdiFalso = verdiFalso;
    }

    public boolean isPrimiBolean() {
        return primiBolean;
    }

    public void setPrimiBolean(boolean primiBolean) {
        this.primiBolean = primiBolean;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Character getLetraReferencia() {
        return letraReferencia;
    }

    public void setLetraReferencia(Character letraReferencia) {
        this.letraReferencia = letraReferencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    


}
