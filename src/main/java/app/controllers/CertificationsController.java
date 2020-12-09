/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Configuracion;
import app.models.FacturaDTE;
import app.pojo.FtsTransaction;
import app.pojo.FtsTransactionDeserialize;
import app.pojo.UtilMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import app.certificaDTE.CertificarDte;
import app.certificaDTE.CofidiConsultaNit;
import app.certificaDTE.procesosCofidi;
import app.models.AnulacionDTE;
import app.pojo.objetoCofidiNit;
import java.nio.charset.CodingErrorAction;

import java.util.Map;

/**
 *
 * @author efrax
 */
public class CertificationsController  extends AppController {


    @POST
    public void certify() throws JsonProcessingException {
        FacturaDTE mFacturaDte= new FacturaDTE();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,true);
        String getRequestString = getRequestString();
        System.out.println("json "+ getRequestString);
        FtsTransaction ftsTransaction = mapper.readValue(getRequestString, FtsTransaction.class);

        app.certificaDTE.FacturaDte facturaDtePre = UtilMapper.map(ftsTransaction);
        app.certificaDTE.FacturaDte facturaDtePost = CertificarDte.proceso_certificacion_fact(facturaDtePre);
        Map<String, String> map = mapper.convertValue(facturaDtePost, Map.class);
        mFacturaDte.fromMap(map);

        mFacturaDte.saveIt();
//        System.out.println("getRequestString(): "+FacturaDtePost);
        respond(mapper.writeValueAsString(facturaDtePost)).contentType("application/json");
//        render().noLayout();
    }
    
    @POST
    public void consultaNitCofidi() throws JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,true);
        String getRequestString = getRequestString();
        
        System.out.println("\n**************ENCABEZADO JSON***************");
        System.out.println("json "+ getRequestString);
        System.out.println("**************ENCABEZADO mapper.readValuBEZADO JSON***************\n");
        objetoCofidiNit objCofidiNit = mapper.readValue(getRequestString, objetoCofidiNit.class);
        
        app.certificaDTE.CofidiConsultaNit objNitCofidiPre = UtilMapper.map(objCofidiNit);
        CofidiConsultaNit objNitCofidiPost = procesosCofidi.proceso_consulta_nit(objNitCofidiPre);
        Map<String, String> map = mapper.convertValue(objNitCofidiPost, Map.class);
        
      System.out.println("\n**************getRequestString()***************");
      System.out.println("getRequestString(): "+objNitCofidiPost);
      System.out.println("**************getRequestString()***************\n");

        respond(mapper.writeValueAsString(objNitCofidiPost)).contentType("application/json");

    }

    @POST
    public void cancel() throws JsonProcessingException {
        AnulacionDTE mAnulacionDTE = new AnulacionDTE();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,true);
        FtsTransaction ftsTransaction = mapper.readValue(getRequestString(), FtsTransaction.class);

        app.certificaDTE.DatosAnulacion  datosAnulacionPre= UtilMapper.mapAnulacion(ftsTransaction);
        app.certificaDTE.DatosAnulacion datosAnulacionPost = CertificarDte.proceso_certificacion_anulacion(datosAnulacionPre);
        Map<String, String> map = mapper.convertValue(datosAnulacionPost, Map.class);
        mAnulacionDTE.fromMap(map);
        mAnulacionDTE.saveIt();
        respond(mapper.writeValueAsString(datosAnulacionPost)).contentType("application/json");
    }
    
}
