package app.certificaDTE;

import static app.certificaDTE.CertificarDte.certifica_dte;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import static org.javalite.app_config.AppConfig.p;

public class procesosCofidi {
    
    public static CofidiConsultaNit proceso_consulta_nit(CofidiConsultaNit obj) {
       
       return consultaNitCofidiWS(obj);
    }
    
    public static CofidiConsultaNit consultaNitCofidiWS(CofidiConsultaNit obj) {
       
//        String url = obj.getUrl();
        HttpClient httpClient = null;
        String xmlsoap;
        try {
            xmlsoap = generarObjetoEnvelope(obj);
            
            httpClient = new DefaultHttpClient();

            String timeout1 = p("development.timeout");
            int timeout = Integer.parseInt(timeout1);
            HttpParams httpParams = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, timeout * 1000);
            HttpConnectionParams.setSoTimeout(httpParams, timeout * 1000);

            HttpPost postRequest = new HttpPost(obj.getUrl());
            StringEntity input = new StringEntity(xmlsoap);
            //input.setContentType("application/soap+xml"); 
            input.setContentType("text/xml;charset=UTF-8"); 
            postRequest.setEntity(input);
            // procesar respuest

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                obj.setResultado("false");
                obj.setEstado(0);
                obj.setError("No hay conexion con el host");
                obj.setDescripcion("ERROR ["+String.valueOf(response.getStatusLine().getStatusCode())+"]");
                System.out.println("\n**************ERROR***************");
                System.out.println(obj.getError()+" "+obj.getDescripcion());
                System.out.println("\n Response : "+response.toString());
                System.out.println("**************ERROR***************");
                
            }
            
            DocumentBuilderFactory factoryDoc = DocumentBuilderFactory.newInstance();
            Document XMLDocument = factoryDoc.newDocumentBuilder().parse(response.getEntity().getContent());
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr1 = xpath.compile("//getNITResult/Response/Result");
            String codigo = String.class.cast(expr1.evaluate(XMLDocument, XPathConstants.STRING));
            
            if (codigo.equals("true")) {
                XPathExpression expr2 = xpath.compile("//getNITResult/Response/NIT");
                XPathExpression expr3 = xpath.compile("//getNITResult/Response/nombre");

                String nit = String.class.cast(expr2.evaluate(XMLDocument, XPathConstants.STRING));
                String nombre = String.class.cast(expr3.evaluate(XMLDocument, XPathConstants.STRING));
                String descripcion = "Peticion Procesada";

                obj.setResultado(codigo);
                obj.setNombre(nombre);
                obj.setNit(nit);
                obj.setEstado(1);
                obj.setDescripcion(descripcion);
                System.out.println("\nRESPONSE true : "+response.toString());

            } else {
                String descripcion = "Peticion Procesada";
                XPathExpression expr4 = xpath.compile("//getNITResult/Response/Result/error");
                String error = String.class.cast(expr4.evaluate(XMLDocument, XPathConstants.STRING));
                obj.setError(error);
                obj.setEstado(2);
                obj.setDescripcion(descripcion);
            }
            

        } catch (UnknownHostException e) {
            obj.setResultado("false");
            obj.setEstado(0);
            obj.setError("Direccion desconocida del host");
            obj.setDescripcion(e.getMessage());
            e.printStackTrace();
            return obj;
            
        } catch (ConnectTimeoutException e) {
            obj.setResultado("false");
            obj.setEstado(0);
            obj.setError("Tiempo de conexion con el host agotada");
            obj.setDescripcion(e.getMessage());
            e.printStackTrace();
            return obj;

        } catch (SocketTimeoutException e) {
            obj.setResultado("false");
            obj.setEstado(0);
            obj.setError("Tiempo de espera del socket por lectura  agotado");
            obj.setDescripcion(e.getMessage());
            e.printStackTrace();
            return obj;
                       
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return obj;
    }
    
    
    public static String generarObjetoEnvelope(CofidiConsultaNit obj){
        String  xmlsoap = "<?xml version=\"1.0\"?>"
                    +"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
                    + "   <soapenv:Header/>\r\n"
                    + "   <soapenv:Body>\r\n"
                    + "      <tem:getNIT>\r\n"
                    + "         <tem:vNIT>" + obj.getNit()+ "</tem:vNIT>\r\n"
                    + "         <tem:Entity>" + obj.getEntity() + "</tem:Entity>\r\n"
                    + "         <tem:Requestor>" + obj.getRequestor() + "</tem:Requestor>\r\n"
                    + "      </tem:getNIT>\r\n"
                    + "   </soapenv:Body>\r\n"
                    + "</soapenv:Envelope>";

//        String  xmlsoap = "<?xml version=\"1.0\"?>"
//                + "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ws=\"http://www.fact.com.mx/schema/ws\">\r\n"
//                    + "   <soap:Header/>\r\n"
//                    + "   <soape:Body>\r\n"
//                    + "      <tem:getNIT>\r\n"
//                    + "         <tem:vNIT>" + obj.getNit()+ "</tem:vNIT>\r\n"
//                    + "         <tem:Entity>" + obj.getEntity() + "</tem:Entity>\r\n"
//                    + "         <tem:Requestor>" + obj.getRequestor() + "</tem:Requestor>\r\n"
//                    + "      </tem:getNIT>\r\n"
//                    + "   </soap:Body>\r\n"
//                    + "</soap:Envelope>";
        //System.out.println("\n Obj Envelope : "+xmlsoap);
        System.out.println(xmlsoap);
        return xmlsoap;
        
    }

    
    
}
