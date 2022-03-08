package com.immune.tienda.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "tienda" )
public class Usuario {
	  @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
  
    private String nombre;
  
    private String correo;

    private String password;
    
    private Integer id_rol;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getCorreo() {
      return correo;
    }

    public void setCorreo(String correo) {
      this.correo = correo;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public Integer getId_rol() {
      return id_rol;
    }

    public void setId_rol(Integer id_rol) {
      this.id_rol = id_rol;
    }

}
