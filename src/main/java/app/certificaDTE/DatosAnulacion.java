package app.certificaDTE;



public class DatosAnulacion {
/*datos para anulacion*/
private String num_doc_anular;
private String nit_emisor;
private String id_receptor;
private String fechaEmisionDoc_anular;
private String fecha_hora_anulacion;
private String motivo_anulacion;

private String tipo_doc_dte;

/*datos para consumir ws certificacion*/
private	String Requestor; 
private	String Transaction; 
private	String Country; 
private	String Entity; 
private	String User; 
private	String UserName; 
private	String Data1; 
private	String Data2; 
private	String Data3;
private String urlWS;

/*Datos para respuesta*/
private  String Result;
private String Code;
private String Description;
private String ResponseData1;
public String getNum_doc_anular() {
	return num_doc_anular;
}
public void setNum_doc_anular(String num_doc_anular) {
	this.num_doc_anular = num_doc_anular;
}
public String getId_receptor() {
	return id_receptor;
}
public void setId_receptor(String id_receptor) {
	this.id_receptor = id_receptor;
}
public String getNit_emisor() {
	return nit_emisor;
}
public void setNit_emisor(String nit_emisor) {
	this.nit_emisor = nit_emisor;
}
public String getFechaEmisionDoc_anular() {
	return fechaEmisionDoc_anular;
}
public void setFechaEmisionDoc_anular(String fechaEmisionDoc_anular) {
	this.fechaEmisionDoc_anular = fechaEmisionDoc_anular;
}
public String getFecha_hora_anulacion() {
	return fecha_hora_anulacion;
}
public void setFecha_hora_anulacion(String fecha_hora_anulacion) {
	this.fecha_hora_anulacion = fecha_hora_anulacion;
}
public String getMotivo_anulacion() {
	return motivo_anulacion;
}
public void setMotivo_anulacion(String motivo_anulacion) {
	this.motivo_anulacion = motivo_anulacion;
}
public String getTipo_doc_dte() {
	return tipo_doc_dte;
}
public void setTipo_doc_dte(String tipo_doc_dte) {
	this.tipo_doc_dte = tipo_doc_dte;
}
public String getRequestor() {
	return Requestor;
}
public void setRequestor(String requestor) {
	Requestor = requestor;
}
public String getTransaction() {
	return Transaction;
}
public void setTransaction(String transaction) {
	Transaction = transaction;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getEntity() {
	return Entity;
}
public void setEntity(String entity) {
	Entity = entity;
}
public String getUser() {
	return User;
}
public void setUser(String user) {
	User = user;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getData2() {
	return Data2;
}
public void setData2(String data2) {
	Data2 = data2;
}
public String getData1() {
	return Data1;
}
public void setData1(String data1) {
	Data1 = data1;
}
public String getData3() {
	return Data3;
}
public void setData3(String data3) {
	Data3 = data3;
}
public String getUrlWS() {
	return urlWS;
}
public void setUrlWS(String urlWS) {
	this.urlWS = urlWS;
}
public String getResult() {
	return Result;
}
public void setResult(String result) {
	Result = result;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getResponseData1() {
	return ResponseData1;
}
public void setResponseData1(String responseData1) {
	ResponseData1 = responseData1;
}
}
