package app.certificaDTE;



import org.apache.commons.codec.binary.Base64;

public class GeneraDte {
	
	public String generar_xml(FacturaDte datos)
	{
		String dte = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
					"<dte:GTDocumento xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:cfc=\"http://www.sat.gob.gt/dte/fel/CompCambiaria/0.1.0\" xmlns:cno=\"http://www.sat.gob.gt/face2/ComplementoReferenciaNota/0.1.0\" xmlns:cex=\"http://www.sat.gob.gt/face2/ComplementoExportaciones/0.1.0\" xmlns:cfe=\"http://www.sat.gob.gt/face2/ComplementoFacturaEspecial/0.1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" Version=\"0.1\" xmlns:dte=\"http://www.sat.gob.gt/dte/fel/0.2.0\">\r\n" +
					"  <dte:SAT ClaseDocumento=\"dte\">\r\n" + 
					"    <dte:DTE ID=\"DatosCertificados\">\r\n" + 
					"      <dte:DatosEmision ID=\"DatosEmision\">\r\n" +
				"        <dte:DatosGenerales Tipo=\"FACT\" FechaHoraEmision=\""+datos.getFecha_hora_emision()+"\" CodigoMoneda=\""+datos.getMoneda()+"\" NumeroAcceso=\""+datos.getNumeroAcceso()+"\" />\r\n" +
				"        <dte:Emisor NITEmisor=\""+datos.getNit_emisor()+"\" NombreEmisor=\""+datos.getNombre_emisor()+"\" CodigoEstablecimiento=\""+datos.getCodigo_establecimiento()+"\" NombreComercial=\""+datos.getNombre_comercial()+"\" AfiliacionIVA=\""+datos.getAfiliacion_iva()+"\">\r\n" +
					"          <dte:DireccionEmisor>\r\n" + 
					"            <dte:Direccion>"+datos.getDireccion_emisor()+"</dte:Direccion>\r\n" + 
					"            <dte:CodigoPostal>"+datos.getCodPostal_emisor()+"</dte:CodigoPostal>\r\n" + 
					"            <dte:Municipio>"+datos.getMunicipio_emisor()+"</dte:Municipio>\r\n" + 
					"            <dte:Departamento>"+datos.getDepartamento_emisor()+"</dte:Departamento>\r\n" + 
					"            <dte:Pais>"+datos.getPais_emisor()+"</dte:Pais>\r\n" + 
					"          </dte:DireccionEmisor>\r\n" + 
					"        </dte:Emisor>\r\n" + 
					"        <dte:Receptor IDReceptor=\""+datos.getId_receptor()+"\" NombreReceptor=\""+datos.getNombre_receptor()+"\">\r\n" + 
					"          <dte:DireccionReceptor>\r\n" + 
					"            <dte:Direccion>"+datos.getDireccion_receptor()+"</dte:Direccion>\r\n" + 
					"            <dte:CodigoPostal>"+datos.getCodPostal_receptor()+"</dte:CodigoPostal>\r\n" + 
					"            <dte:Municipio>"+datos.getMunicipio_receptor()+"</dte:Municipio>\r\n" + 
					"            <dte:Departamento>"+datos.getDepartamento_receptor()+"</dte:Departamento>\r\n" + 
					"            <dte:Pais>"+datos.getPais_receptor()+"</dte:Pais>\r\n" + 
					"          </dte:DireccionReceptor>\r\n" + 
					"        </dte:Receptor>\r\n" + 
					"        <dte:Frases>\r\n" + 
					"          <dte:Frase TipoFrase=\""+datos.getTipo_frase1()+"\" CodigoEscenario=\""+datos.getCod_escenario1()+"\" />\r\n" + 
					"		  <dte:Frase TipoFrase=\""+datos.getTipo_frase2()+"\" CodigoEscenario=\""+datos.getCod_escenario2()+"\" />\r\n" + 
					"        </dte:Frases>\r\n" + 
					"        <dte:Items>\r\n" + 
					"          <dte:Item NumeroLinea=\""+datos.getNumLinea_item()+"\" BienOServicio=\""+datos.getBienoservicio_item()+"\">\r\n" + 
					"            <dte:Cantidad>"+datos.getCantidad_item()+"</dte:Cantidad>\r\n" + 
					"            <dte:UnidadMedida>"+datos.getUniMedida_item()+"</dte:UnidadMedida>\r\n" + 
					"            <dte:Descripcion>"+datos.getDescripcion_item()+"</dte:Descripcion>\r\n" + 
					"            <dte:PrecioUnitario>"+datos.getPrecioUnitario_item()+"</dte:PrecioUnitario>\r\n" + 
					"            <dte:Precio>"+datos.getPrecio_item()+"</dte:Precio>\r\n" + 
					"            <dte:Descuento>"+datos.getDescuento_item()+"</dte:Descuento>\r\n" + 
					"            <dte:Impuestos>\r\n" + 
					"              <dte:Impuesto>\r\n" + 
					"                <dte:NombreCorto>"+datos.getNombre_impuesto()+"</dte:NombreCorto>\r\n" + 
					"                <dte:CodigoUnidadGravable>"+datos.getCodGravable_impuesto()+"</dte:CodigoUnidadGravable>\r\n" + 
					"                <dte:MontoGravable>"+datos.getMontoGravable_impuesto()+"</dte:MontoGravable>\r\n" + 
					"                <dte:MontoImpuesto>"+datos.getMonto_impuesto()+"</dte:MontoImpuesto>\r\n" + 
					"              </dte:Impuesto>\r\n" + 
					"            </dte:Impuestos>\r\n" + 
					"            <dte:Total>"+datos.getTotal()+"</dte:Total>\r\n" + 
					"          </dte:Item>\r\n" + 
					"        </dte:Items>\r\n" + 
					"        <dte:Totales>\r\n" + 
					"          <dte:TotalImpuestos>\r\n" + 
					"            <dte:TotalImpuesto NombreCorto=\""+datos.getNombre_impuesto()+"\" TotalMontoImpuesto=\""+datos.getTotal_monto_impuesto()+"\" />\r\n" + 
					"          </dte:TotalImpuestos>\r\n" + 
					"          <dte:GranTotal>"+datos.getTotal()+"</dte:GranTotal>\r\n" + 
					"        </dte:Totales>\r\n" + 
					"      </dte:DatosEmision>\r\n" + 
					"    </dte:DTE>\r\n" + 
					"  </dte:SAT>\r\n" + 
					"</dte:GTDocumento>";
		String dte64 = codificar_base64(dte);
		return dte64;		
	}
	
	public String generar_xml_anulacion(DatosAnulacion datos)
	{
		String dte = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
					"<dte:GTAnulacionDocumento xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" Version=\"0.1\" xmlns:dte=\"http://www.sat.gob.gt/dte/fel/0.1.0\">\r\n" +
					"	<dte:SAT>\r\n" + 
					"		<dte:AnulacionDTE ID=\"DatosCertificados\">\r\n" + 
					"			<dte:DatosGenerales \r\n" + 
					"			ID=\"DatosAnulacion\" \r\n" + 
					"			NumeroDocumentoAAnular=\""+datos.getNum_doc_anular()+"\" \r\n" + 
					"			NITEmisor=\""+datos.getNit_emisor()+"\" \r\n" + 
					"			IDReceptor=\""+datos.getId_receptor()+"\" \r\n" + 
					"			FechaEmisionDocumentoAnular=\""+datos.getFechaEmisionDoc_anular()+"\" \r\n" + 
					"			FechaHoraAnulacion=\""+datos.getFecha_hora_anulacion()+"\" \r\n" + 
					"			MotivoAnulacion=\""+datos.getMotivo_anulacion()+"\" \r\n" + 
					"			/>\r\n" + 
					"		</dte:AnulacionDTE>\r\n" + 
					"	</dte:SAT>\r\n" + 
					"</dte:GTAnulacionDocumento>";
		
		/*System.out.println("xml: " + dte);*/
		String dte64 = codificar_base64(dte);
		return dte64;		
	}
	
	public String codificar_base64(String dtexml)
	{
		byte[] bytesEncoded = Base64.encodeBase64(dtexml.getBytes());
		/*byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);*/
		return new String(bytesEncoded);
	}

}
