/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Angel Claros Quintero
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class objetoCofidiNit {
    
    private static final Logger LOG = Logger.getLogger(objetoCofidiNit.class.getName());
    
    
    
    @JsonProperty("nit")
    private String nit;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "objetoCofidiNit{" + "nit=" + nit + '}';
    }

    public objetoCofidiNit(String nit) {
        this.nit = nit;
    }

    public objetoCofidiNit() {
    }
    
    
    
    
    
    
}
