/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.control;

import com.udea.ws.NewWebService;
import com.udea.ws.Producto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Lenovo
 */
public class ProductoBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ProveedorWS/NewWebService.wsdl")
    private NewWebService service;

    
      
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
       
    
  public String guardarProd(){
     String msj=ingresarProducto(nombre,precio,stock,descripcion);
     FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"...");
     FacesContext.getCurrentInstance().addMessage(null, msg);
     limpiarForm();
     return "result";
  
  }  
  
  
  
    
  
  public String buscarProd(){
  
     String msj=buscarProducto(codigo);
     FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"...");
     FacesContext.getCurrentInstance().addMessage(null, msg);
     limpiarForm();
     return "index";
  
  
  }
  
  
  public List<Producto> getListaProd(){
  List<Producto> lista = consultarProducto();
  return lista;
  
  }
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    private String buscarProducto(int codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.ws.ProductoWS port = service.getProductoWSPort();
        return port.buscarProducto(codigo);
    }

    private java.util.List<com.udea.ws.Producto> consultarProducto() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.ws.ProductoWS port = service.getProductoWSPort();
        return port.consultarProducto();
    }

    private String ingresarProducto(java.lang.String nombre, double precio, int stock, java.lang.String descripcion) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.ws.ProductoWS port = service.getProductoWSPort();
        return port.ingresarProducto(nombre, precio, stock, descripcion);
    }
     private void limpiarForm() {
       
    this.codigo=0;
    this.descripcion="";
    this.nombre="";
    this.precio=0.0;
    this.stock=0;
    
    }
}
