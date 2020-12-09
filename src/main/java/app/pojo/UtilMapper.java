package app.pojo;

import app.certificaDTE.CofidiConsultaNit;
import app.models.Cliente;
import app.models.Configuracion;
import app.models.FacturaDTE;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Date;

public class UtilMapper {

    static FtsTransaction ftsTransaction;
    private static String uniMedida_item;
    private static String bienoservicio_item;
    private static String descripcion_item;
    static Cliente cliente;
    private static objetoCofidiNit objCofidiNit;

    public static app.certificaDTE.FacturaDte map(FtsTransaction ftsTransaction) {
        //mapeo de datos para cacheo 
        UtilMapper.ftsTransaction = ftsTransaction;
        mapFtsTransaction();
        cliente = Cliente.findById(ftsTransaction.getCliente_uuid());
        System.out.println(cliente.toJson(true));


        app.certificaDTE.FacturaDte datosDte = new app.certificaDTE.FacturaDte();
        datosDte.setFecha_hora_emision(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
        datosDte.setMoneda("GTQ");//tabla de configuraciones  todo

        datosDte.setNit_emisor(getValorAlpha("nit_emisor"));
        datosDte.setNombre_emisor(getValorAlpha("nombre_emisor"));
        datosDte.setCodigo_establecimiento(getValorAlpha("codigo_establecimiento"));//
        datosDte.setNombre_comercial(getValorAlpha("nombre_comercial"));
        datosDte.setAfiliacion_iva("GEN");
        datosDte.setDireccion_emisor(getValorAlpha("direccion_emisor"));
        datosDte.setCodPostal_emisor(getValorAlpha("codPostal_emisor"));
        datosDte.setMunicipio_emisor(getValorAlpha("municipio_emisor"));
        datosDte.setDepartamento_emisor(getValorAlpha("departamento_emisor"));
        datosDte.setPais_emisor("GT");
        datosDte.setId_receptor(getbyIdCliente("identificacion"));
        datosDte.setNombre_receptor(getbyIdCliente("nombre"));
        datosDte.setDireccion_receptor(getbyIdCliente("direccion"));
        datosDte.setCodPostal_receptor(getbyIdCliente("codigoPostal"));
        datosDte.setMunicipio_receptor(getbyIdCliente("ciudad"));
        datosDte.setDepartamento_receptor(getbyIdCliente("provincia"));
        datosDte.setPais_receptor(getbyIdCliente("pais"));
        datosDte.setTipo_frase1(getValorAlpha("Tipo_frase1"));//  todo:consultar configuraciones
        datosDte.setTipo_frase2(getValorAlpha("Tipo_frase2"));//  todo:consultar configuraciones
        datosDte.setCod_escenario1(getValorAlpha("Cod_escenario1"));//  todo:consultar configuraciones
        datosDte.setCod_escenario2(getValorAlpha("Cod_escenario2"));// todo:consultar configuraciones
        datosDte.setNumLinea_item("1");
        datosDte.setBienoservicio_item(bienoservicio_item);
        datosDte.setCantidad_item("1.00000000");
        datosDte.setUniMedida_item(uniMedida_item);
        datosDte.setDescripcion_item(descripcion_item);// todo: consultar configuraciones pendiente por definir por VAS
        datosDte.setPrecioUnitario_item(getDecimalFormat("#0.000000").format(ftsTransaction.getPrecioTab()));// todo: validar formato por 0 decimales
        datosDte.setPrecio_item(getDecimalFormat("#0.000000").format(ftsTransaction.getPrecioTab()));// todo: validar formato por 0 decimales
        datosDte.setDescuento_item("0");
        datosDte.setNombre_impuesto(getValorAlpha("nombre_impuesto"));
        datosDte.setCodGravable_impuesto(getValorAlpha("codGravable_impuesto"));
        datosDte.setMontoGravable_impuesto(getDecimalFormat("#0.00000").format(ftsTransaction.getPrecioTab()-ftsTransaction.getSegVial()));
        datosDte.setMonto_impuesto(getDecimalFormat("#0.00000").format(ftsTransaction.getSegVial()));
        datosDte.setTotal_monto_impuesto(getDecimalFormat("#0.000000").format(ftsTransaction.getSegVial()));
        datosDte.setTotal(getDecimalFormat("##.00").format(ftsTransaction.getPrecioTab()));
        /*datos para consumir ws certificacion*/
        datosDte.setRequestor(getValorAlpha("requestor"));
        datosDte.setTransaction("SYSTEM_REQUEST");
        datosDte.setCountry("GT");
        datosDte.setEntity(getValorAlpha("entity"));
        datosDte.setUser(getValorAlpha("user"));
        datosDte.setUserName(getValorAlpha("UserName"));
        datosDte.setData1("POST_DOCUMENT_SAT");
//        datosDte.setData2("");
        datosDte.setData3(ftsTransaction.getIdPeaje()+String.format("%02d", ftsTransaction.getCarrilTab())+String.format("%10s", ftsTransaction.getTiqueteTab()).replace(' ','0'));// todo: formato de dos digitos
        datosDte.setUrlWS(getValorAlpha("UrlWS"));
        datosDte.setNombreCertificador(getValorAlpha("nombre_certificador"));
        datosDte.setNitCertificador(getValorAlpha("nit_certificador"));
        datosDte.setCadenaFrase(getValorAlpha("cadena_frase"));
        datosDte.setIdDte(getIdDte());

        return datosDte;
    }


    public static app.certificaDTE.DatosAnulacion mapAnulacion(FtsTransaction ftsTransaction) {
        //mapeo de datos para cacheo
        UtilMapper.ftsTransaction = ftsTransaction;
        mapFtsTransaction();
        FacturaDTE  mFacturaDTE=  FacturaDTE.first("numAutorizacion = ?", ftsTransaction.getClave_acceso());

        app.certificaDTE.DatosAnulacion  datosAnulacion = new app.certificaDTE.DatosAnulacion();
        datosAnulacion.setNum_doc_anular(ftsTransaction.getClave_acceso());
        datosAnulacion.setNit_emisor(mFacturaDTE.getString("nit_emisor"));
        datosAnulacion.setFechaEmisionDoc_anular(mFacturaDTE.getString("fecha_hora_emision"));
        datosAnulacion.setId_receptor(mFacturaDTE.getString("id_receptor"));
        datosAnulacion.setFecha_hora_anulacion(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
        datosAnulacion.setMotivo_anulacion("Anulación por Corrección de tabulación");
        datosAnulacion.setTipo_doc_dte("DatosAnulacion");
        /*datos para consumir ws certificacion*/
        datosAnulacion.setRequestor(getValorAlpha("requestor"));
        datosAnulacion.setTransaction("SYSTEM_REQUEST");
        datosAnulacion.setCountry("GT");
        datosAnulacion.setEntity(getValorAlpha("entity"));
        datosAnulacion.setUser(getValorAlpha("user"));
        datosAnulacion.setUserName(getValorAlpha("UserName"));
        datosAnulacion.setData1("VOID_DOCUMENT");
//        datosDte.setData2("");
//        datosAnulacion.setData3(ftsTransaction.getIdPeaje()+String.format("%02d", ftsTransaction.getCarrilTab())+String.format("%9s", ftsTransaction.getTiqueteTab()).replace(' ','0'));// todo: formato de dos digitos
        datosAnulacion.setUrlWS(getValorAlpha("UrlWS"));


        return datosAnulacion;
    }
    
    
    
    
    public static CofidiConsultaNit map(objetoCofidiNit objCofidiNit) {
         //mapeo de datos para cacheo 
        UtilMapper.objCofidiNit = objCofidiNit;
       
        app.certificaDTE.CofidiConsultaNit datosDte = new app.certificaDTE.CofidiConsultaNit ();
        
        datosDte.setNit(objCofidiNit.getNit());
        datosDte.setEntity(getValorAlpha("Entity_codifi_nit",23));
        datosDte.setRequestor(getValorAlpha("Requestor_codifi_nit",23));
        datosDte.setUrl(getValorAlpha("urlWS_codifi_nit",23));
        
        System.out.println("\n**************Datos de solicitud ws***************");
        System.out.println("Nit "+objCofidiNit.getNit()+"\n Entity "+datosDte.getEntity()+"\n Requestor "+datosDte.getRequestor()+"\n URL WS"+datosDte.getUrl());
        System.out.println("**************Datos de solicitud WS***************\n");
        return datosDte;
        
    }

    private static String getValorAlpha(String Parametro) {
        return Configuracion
                .findFirst("Parametro = ? and codigo = ?",
                        Parametro,
                        ftsTransaction.getIdPeaje())
                .getString("ValorAlpha");
    }
    
    
    private static String getValorAlpha(String Parametro,int peaje) {
        return Configuracion
                .findFirst("Parametro = ? and codigo = ? ",
                    Parametro,
                    peaje)
                .getString("ValorAlpha");
    }

    /*private static String getbyIdCliente(String campo) {
        return Cliente.findById(ftsTransaction.getCliente_uuid()).get(campo).toString();
    }*/

    private static String getbyIdCliente(String campo) {
        return cliente.get(campo).toString();
    }

    private static String getIdDte()
    {
        UUID idOne;
        idOne = UUID.randomUUID();
        return idOne+"";
    }

    private static void mapFtsTransaction() {

        if (ftsTransaction.getTipoTurno() == 9) {

            uniMedida_item = "UNI";
            bienoservicio_item = "B";
            descripcion_item= "Venta de tag";
        } else if(ftsTransaction.getTipoTurno() == 3 ||  ftsTransaction.getTipoTurno() == 18 || ftsTransaction.getTipoTurno() == 19) {
            uniMedida_item = "SRV";
            bienoservicio_item = "S";
            descripcion_item= "Recarga ";
        }else{
            uniMedida_item = "SRV";
            bienoservicio_item = "S";
            descripcion_item= "Motos / Vehiculos ";
        }
    }
    
    private static  DecimalFormat getDecimalFormat(String patron){
        
       DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
       otherSymbols.setDecimalSeparator('.');
       DecimalFormat decimalFormat= new DecimalFormat(patron,otherSymbols);
       return decimalFormat;
        
    }

    
    

}
