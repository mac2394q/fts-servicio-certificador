package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.DbName;
import org.javalite.activejdbc.annotations.Table;

@DbName("trans_db")
@Table("FacturaDTE")
public class FacturaDTE extends Model {

    /*datos para armar DTE*/
    private String fecha_hora_emision;
    private String moneda;
    private String nit_emisor;
    private String nombre_emisor;
    private String codigo_establecimiento;
    private String nombre_comercial;
    private String afiliacion_iva;
    private String direccion_emisor;
    private String codPostal_emisor;
    private String municipio_emisor;
    private String departamento_emisor;
    private String pais_emisor;
    private String id_receptor;
    private String nombre_receptor;
    private String direccion_receptor;
    private String codPostal_receptor;
    private String municipio_receptor;
    private String departamento_receptor;
    private String pais_receptor;
    private String tipo_frase1;
    private String tipo_frase2;
    private String cod_escenario1;
    private String cod_escenario2;
    private String numLinea_item;
    private String bienoservicio_item;
    private String cantidad_item;
    private String uniMedida_item;
    private String descripcion_item;
    private String precioUnitario_item;
    private String precio_item;
    private String descuento_item;
    private String nombre_impuesto;
    private String codGravable_impuesto;
    private String montoGravable_impuesto;
    private String monto_impuesto;
    private String total_monto_impuesto;
    private String total;
    private String numeroAcceso;
    private String estador_certificacion;

    /*datos para consumir ws certificacion*/
    private String Requestor;
    private String Transaction;
    private String Country;
    private String Entity;
    private String User;
    private String UserName;
    private String Data1;
    private String Data2;
    private String Data3;

    /*Datos para respuesta*/
    private String Result;
    private String Code;
    private String Description;
    private String ResponseData1;
    private String numAutorizacion;
    private String serie;
    private String fechaHoraCertificacion;
    private String nombreCertificador;
    private String nitCertificador;
    private String cadenaFrase;

    public FacturaDTE() {
    }

    /**
     * @return the requestor
     */
    public String getRequestor() {
        return Requestor;
    }

    /**
     * @param requestor the requestor to set
     */
    public void setRequestor(String requestor) {
        Requestor = requestor;
    }

    /**
     * @return the transaction
     */
    public String getTransaction() {
        return Transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(String transaction) {
        Transaction = transaction;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        Country = country;
    }

    /**
     * @return the entity
     */
    public String getEntity() {
        return Entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(String entity) {
        Entity = entity;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return User;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        User = user;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        UserName = userName;
    }

    /**
     * @return the data1
     */
    public String getData1() {
        return Data1;
    }

    /**
     * @param data1 the data1 to set
     */
    public void setData1(String data1) {
        Data1 = data1;
    }

    /**
     * @return the data2
     */
    public String getData2() {
        return Data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(String data2) {
        Data2 = data2;
    }

    /**
     * @return the data3
     */
    public String getData3() {
        return Data3;
    }

    /**
     * @param data3 the data3 to set
     */
    public void setData3(String data3) {
        Data3 = data3;
    }

    public String getFecha_hora_emision() {
        return fecha_hora_emision;
    }

    public void setFecha_hora_emision(String fecha_hora_emision) {
        this.fecha_hora_emision = fecha_hora_emision;
    }

    public String getDireccion_emisor() {
        return direccion_emisor;
    }

    public void setDireccion_emisor(String direccion_emisor) {
        this.direccion_emisor = direccion_emisor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNombre_emisor() {
        return nombre_emisor;
    }

    public void setNombre_emisor(String nombre_emisor) {
        this.nombre_emisor = nombre_emisor;
    }

    public String getNit_emisor() {
        return nit_emisor;
    }

    public void setNit_emisor(String nit_emisor) {
        this.nit_emisor = nit_emisor;
    }

    public String getCodigo_establecimiento() {
        return codigo_establecimiento;
    }

    public void setCodigo_establecimiento(String codigo_establecimiento) {
        this.codigo_establecimiento = codigo_establecimiento;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getAfiliacion_iva() {
        return afiliacion_iva;
    }

    public void setAfiliacion_iva(String afiliacion_iva) {
        this.afiliacion_iva = afiliacion_iva;
    }

    public String getCodPostal_emisor() {
        return codPostal_emisor;
    }

    public void setCodPostal_emisor(String codPostal_emisor) {
        this.codPostal_emisor = codPostal_emisor;
    }

    public String getMunicipio_emisor() {
        return municipio_emisor;
    }

    public void setMunicipio_emisor(String municipio_emisor) {
        this.municipio_emisor = municipio_emisor;
    }

    public String getDepartamento_emisor() {
        return departamento_emisor;
    }

    public void setDepartamento_emisor(String departamento_emisor) {
        this.departamento_emisor = departamento_emisor;
    }

    public String getPais_emisor() {
        return pais_emisor;
    }

    public void setPais_emisor(String pais_emisor) {
        this.pais_emisor = pais_emisor;
    }

    public String getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(String id_receptor) {
        this.id_receptor = id_receptor;
    }

    public String getNombre_receptor() {
        return nombre_receptor;
    }

    public void setNombre_receptor(String nombre_receptor) {
        this.nombre_receptor = nombre_receptor;
    }

    public String getDireccion_receptor() {
        return direccion_receptor;
    }

    public void setDireccion_receptor(String direccion_receptor) {
        this.direccion_receptor = direccion_receptor;
    }

    public String getCodPostal_receptor() {
        return codPostal_receptor;
    }

    public void setCodPostal_receptor(String codPostal_receptor) {
        this.codPostal_receptor = codPostal_receptor;
    }

    public String getMunicipio_receptor() {
        return municipio_receptor;
    }

    public void setMunicipio_receptor(String municipio_receptor) {
        this.municipio_receptor = municipio_receptor;
    }

    public String getDepartamento_receptor() {
        return departamento_receptor;
    }

    public void setDepartamento_receptor(String departamento_receptor) {
        this.departamento_receptor = departamento_receptor;
    }

    public String getPais_receptor() {
        return pais_receptor;
    }

    public void setPais_receptor(String pais_receptor) {
        this.pais_receptor = pais_receptor;
    }

    public String getNumLinea_item() {
        return numLinea_item;
    }

    public void setNumLinea_item(String numLinea_item) {
        this.numLinea_item = numLinea_item;
    }

    public String getBienoservicio_item() {
        return bienoservicio_item;
    }

    public void setBienoservicio_item(String bienoservicio_item) {
        this.bienoservicio_item = bienoservicio_item;
    }

    public String getCantidad_item() {
        return cantidad_item;
    }

    public void setCantidad_item(String cantidad_item) {
        this.cantidad_item = cantidad_item;
    }

    public String getUniMedida_item() {
        return uniMedida_item;
    }

    public void setUniMedida_item(String uniMedida_item) {
        this.uniMedida_item = uniMedida_item;
    }

    public String getDescripcion_item() {
        return descripcion_item;
    }

    public void setDescripcion_item(String descripcion_item) {
        this.descripcion_item = descripcion_item;
    }

    public String getPrecioUnitario_item() {
        return precioUnitario_item;
    }

    public void setPrecioUnitario_item(String precioUnitario_item) {
        this.precioUnitario_item = precioUnitario_item;
    }

    public String getPrecio_item() {
        return precio_item;
    }

    public void setPrecio_item(String precio_item) {
        this.precio_item = precio_item;
    }

    public String getNombre_impuesto() {
        return nombre_impuesto;
    }

    public void setNombre_impuesto(String nombre_impuesto) {
        this.nombre_impuesto = nombre_impuesto;
    }

    public String getCodGravable_impuesto() {
        return codGravable_impuesto;
    }

    public void setCodGravable_impuesto(String codGravable_impuesto) {
        this.codGravable_impuesto = codGravable_impuesto;
    }

    public String getMontoGravable_impuesto() {
        return montoGravable_impuesto;
    }

    public void setMontoGravable_impuesto(String montoGravable_impuesto) {
        this.montoGravable_impuesto = montoGravable_impuesto;
    }

    public String getMonto_impuesto() {
        return monto_impuesto;
    }

    public void setMonto_impuesto(String monto_impuesto) {
        this.monto_impuesto = monto_impuesto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getResponseData1() {
        return ResponseData1;
    }

    public void setResponseData1(String responseData1) {
        ResponseData1 = responseData1;
    }

    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }
//	public String getTipo_doc_dte() {
//		return tipo_doc_dte;
//	}
//	public void setTipo_doc_dte(String tipo_doc_dte) {
//		this.tipo_doc_dte = tipo_doc_dte;
//	}

    public String getTipo_frase1() {
        return tipo_frase1;
    }

    public void setTipo_frase1(String tipo_frase1) {
        this.tipo_frase1 = tipo_frase1;
    }

    public String getTipo_frase2() {
        return tipo_frase2;
    }

    public void setTipo_frase2(String tipo_frase2) {
        this.tipo_frase2 = tipo_frase2;
    }

    public String getCod_escenario1() {
        return cod_escenario1;
    }

    public void setCod_escenario1(String cod_escenario1) {
        this.cod_escenario1 = cod_escenario1;
    }

    public String getCod_escenario2() {
        return cod_escenario2;
    }

    public void setCod_escenario2(String cod_escenario2) {
        this.cod_escenario2 = cod_escenario2;
    }

    public String getDescuento_item() {
        return descuento_item;
    }

    public void setDescuento_item(String descuento_item) {
        this.descuento_item = descuento_item;
    }

    public String getTotal_monto_impuesto() {
        return total_monto_impuesto;
    }

    public void setTotal_monto_impuesto(String total_monto_impuesto) {
        this.total_monto_impuesto = total_monto_impuesto;
    }

    public String getNumeroAcceso() {
        return numeroAcceso;
    }

    public void setNumeroAcceso(String numeroAcceso) {
        this.numeroAcceso = numeroAcceso;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFechaHoraCertificacion() {
        return fechaHoraCertificacion;
    }

    public void setFechaHoraCertificacion(String fechaHoraCertificacion) {
        this.fechaHoraCertificacion = fechaHoraCertificacion;
    }

    public String getNombreCertificador() {
        return nombreCertificador;
    }

    public void setNombreCertificador(String nombreCertificador) {
        this.nombreCertificador = nombreCertificador;
    }

    public String getNitCertificador() {
        return nitCertificador;
    }

    public void setNitCertificador(String nitCertificador) {
        this.nitCertificador = nitCertificador;
    }

    public String getCadenaFrase() {
        return cadenaFrase;
    }

    public void setCadenaFrase(String cadenaFrase) {
        this.cadenaFrase = cadenaFrase;
    }

    public String getEstador_certificacion() {
        return estador_certificacion;
    }

    public void setEstador_cer(String estador_cer) {
        this.estador_certificacion = estador_cer;
    }
}
