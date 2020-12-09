package app.certificaDTE;

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

public class CertificarDte {

    public static FacturaDte proceso_certificacion_fact(FacturaDte objeto) {
        String sCadena = objeto.getData3();
        String parte1 = sCadena.substring(0, 4);
        //String parte2 = sCadena.substring(9,14); //str.substring(str.length()-5,str.length());
        String parte2 = sCadena.substring(sCadena.length() - 5, sCadena.length());
        String num_entero = parte1 + parte2;
        objeto.setNumeroAcceso(num_entero);
        GeneraDte xml = new GeneraDte();
        String dte64;
        dte64 = xml.generar_xml(objeto);
        objeto.setData2(dte64);
        FacturaDte objeto_certificar = certifica_dte(objeto);
        return objeto_certificar;
    }

    public static DatosAnulacion proceso_certificacion_anulacion(DatosAnulacion objeto) {
        GeneraDte xml = new GeneraDte();
        String dte64 = xml.generar_xml_anulacion(objeto);
        objeto.setData2(dte64);
        DatosAnulacion objeto_certificar = certifica_dte_anulacion(objeto);
        return objeto_certificar;
    }
    
    

    public static FacturaDte certifica_dte(FacturaDte objeto) {
        // cliente http
        String url = objeto.getUrlWS();
        HttpClient httpClient = null;
        try {
            String xmlsoap = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ws=\"http://www.fact.com.mx/schema/ws\">\r\n"
                    + "   <soap:Header/>\r\n"
                    + "   <soap:Body>\r\n"
                    + "      <ws:RequestTransaction>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Requestor>" + objeto.getRequestor() + "</ws:Requestor>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Transaction>" + objeto.getTransaction() + "</ws:Transaction>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Country>" + objeto.getCountry() + "</ws:Country>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Entity>" + objeto.getEntity() + "</ws:Entity>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:User>" + objeto.getUser() + "</ws:User>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:UserName>" + objeto.getUserName() + "</ws:UserName>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data1>" + objeto.getData1() + "</ws:Data1>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data2>" + objeto.getData2() + "</ws:Data2>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data3>" + objeto.getData3() + "</ws:Data3>\r\n"
                    + "      </ws:RequestTransaction>\r\n"
                    + "   </soap:Body>\r\n"
                    + "</soap:Envelope>";
            // llamada a servicio
            httpClient = new DefaultHttpClient();

            String timeout1 = p("development.timeout");
            int timeout = Integer.parseInt(timeout1);
            HttpParams httpParams = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, timeout * 1000);
            HttpConnectionParams.setSoTimeout(httpParams, timeout * 1000);

            HttpPost postRequest = new HttpPost(url);
            StringEntity input = new StringEntity(xmlsoap);
            input.setContentType("application/soap+xml");
            postRequest.setEntity(input);
            // procesar respuest

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                objeto.setResult("no hay conexion contingencia");
                objeto.setCode("9999");
                objeto.setDescription("no hay conexion con el certificador generar Contingencia");
                objeto.setResponseData1("");
                if (objeto.getEstado_certificacion() == null) {
                    objeto.setEstado_certificacion("2");
                }
                return objeto;
            }

            // Obtener informaci�n de la respuesta
            DocumentBuilderFactory factoryDoc = DocumentBuilderFactory.newInstance();
            Document XMLDocument = factoryDoc.newDocumentBuilder().parse(response.getEntity().getContent());
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr1 = xpath.compile("//RequestTransactionResult/Response/Code");
            String codigo = String.class.cast(expr1.evaluate(XMLDocument, XPathConstants.STRING));
            if (codigo.equals("1")) {
                XPathExpression expr2 = xpath.compile("//RequestTransactionResult/Response/Identifier/DocumentGUID");
                XPathExpression expr3 = xpath.compile("//RequestTransactionResult/ResponseData/ResponseData1");
                XPathExpression expr4 = xpath.compile("//RequestTransactionResult/Response/Result");
                XPathExpression expr5 = xpath.compile("//RequestTransactionResult/Response/Description");
                XPathExpression expr6 = xpath.compile("//RequestTransactionResult/Response/Identifier/Serial");
                XPathExpression expr7 = xpath.compile("//RequestTransactionResult/Response/TimeStamp");
                String numAutorizacion = String.class.cast(expr2.evaluate(XMLDocument, XPathConstants.STRING));
                String DTE_certificado = String.class.cast(expr3.evaluate(XMLDocument, XPathConstants.STRING));
                String result = String.class.cast(expr4.evaluate(XMLDocument, XPathConstants.STRING));
                String description = String.class.cast(expr5.evaluate(XMLDocument, XPathConstants.STRING));
                String serial = String.class.cast(expr6.evaluate(XMLDocument, XPathConstants.STRING));
                String fechaHoraCert = String.class.cast(expr7.evaluate(XMLDocument, XPathConstants.STRING));
                objeto.setResult(result);
                objeto.setCode(codigo);
                objeto.setDescription(description);
                objeto.setResponseData1(DTE_certificado);
                objeto.setNumAutorizacion(numAutorizacion);
                objeto.setSerie(serial);
                objeto.setFechaHoraCertificacion(fechaHoraCert);
                objeto.setEstado_certificacion("1");
                String numDTECer = obtiene_numDteCertificado(numAutorizacion) + "";
                objeto.setNumeroDteCer(numDTECer);
            } else {
                XPathExpression expr4 = xpath.compile("//RequestTransactionResult/Response/Result");
                XPathExpression expr5 = xpath.compile("//RequestTransactionResult/Response/Description");
                String result = String.class.cast(expr4.evaluate(XMLDocument, XPathConstants.STRING));
                String description = String.class.cast(expr5.evaluate(XMLDocument, XPathConstants.STRING));
                objeto.setResult(result);
                objeto.setCode(codigo);
                objeto.setDescription(description);
                objeto.setResponseData1("");
                objeto.setEstado_certificacion("0");

            }

        } catch (UnknownHostException e) {
            /*e.printStackTrace();*/
            objeto.setResult("no hay conexion contingencia");
            objeto.setCode("9999");
            objeto.setDescription("no hay internet generar Contingencia");
            objeto.setResponseData1("");
            if (objeto.getEstado_certificacion() == null) {
                objeto.setEstado_certificacion("2");
            }
            return objeto;
        } catch (ConnectTimeoutException e) {
            objeto.setResult("no hay conexion contingencia");
            objeto.setCode("9999");
            objeto.setDescription("timeout conexion internet generar Contingencia");
            objeto.setResponseData1("");
            if (objeto.getEstado_certificacion() == null) {
                objeto.setEstado_certificacion("2");
            }
            return objeto;
        } catch (SocketTimeoutException e) {
            objeto.setResult("no hay conexion contingencia");
            objeto.setCode("9999");
            objeto.setDescription("timeout conexion posiblemente certifico - generar Contingencia");
            objeto.setResponseData1("");
            if (objeto.getEstado_certificacion() == null) {
                objeto.setEstado_certificacion("2");
            }
            return objeto;
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

        return objeto;
    }

    

    public static DatosAnulacion certifica_dte_anulacion(DatosAnulacion objeto) {
        // cliente http
        String url = objeto.getUrlWS();
        HttpClient httpClient = null;
        try {
            String xmlsoap = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ws=\"http://www.fact.com.mx/schema/ws\">\r\n"
                    + "   <soap:Header/>\r\n"
                    + "   <soap:Body>\r\n"
                    + "      <ws:RequestTransaction>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Requestor>" + objeto.getRequestor() + "</ws:Requestor>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Transaction>" + objeto.getTransaction() + "</ws:Transaction>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Country>" + objeto.getCountry() + "</ws:Country>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Entity>" + objeto.getEntity() + "</ws:Entity>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:User>" + objeto.getUser() + "</ws:User>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:UserName>" + objeto.getUserName() + "</ws:UserName>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data1>" + objeto.getData1() + "</ws:Data1>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data2>" + objeto.getData2() + "</ws:Data2>\r\n"
                    + "         <!--Optional:-->\r\n"
                    + "         <ws:Data3>" + objeto.getData3() + "</ws:Data3>\r\n"
                    + "      </ws:RequestTransaction>\r\n"
                    + "   </soap:Body>\r\n"
                    + "</soap:Envelope>";
            // llamada a servicio
            httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);
            StringEntity input = new StringEntity(xmlsoap);
            input.setContentType("application/soap+xml");
            postRequest.setEntity(input);
            // procesar respuesta
            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Error en la llamada : "
                        + response.getStatusLine().getStatusCode());
            }
            // Obtener informaci�n de la respuesta
            DocumentBuilderFactory factoryDoc = DocumentBuilderFactory.newInstance();
            Document XMLDocument = factoryDoc.newDocumentBuilder().parse(response.getEntity().getContent());
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr1 = xpath.compile("//RequestTransactionResult/Response/Code");
            String codigo = String.class.cast(expr1.evaluate(XMLDocument, XPathConstants.STRING));
            if (codigo.equals("1")) {
                XPathExpression expr2 = xpath.compile("//RequestTransactionResult/Response/Identifier/DocumentGUID");
                XPathExpression expr3 = xpath.compile("//RequestTransactionResult/ResponseData/ResponseData1");
                XPathExpression expr4 = xpath.compile("//RequestTransactionResult/Response/Result");
                XPathExpression expr5 = xpath.compile("//RequestTransactionResult/Response/Description");
                String numAutorizacion = String.class.cast(expr2.evaluate(XMLDocument, XPathConstants.STRING));
                String DTE_certificado = String.class.cast(expr3.evaluate(XMLDocument, XPathConstants.STRING));
                String result = String.class.cast(expr4.evaluate(XMLDocument, XPathConstants.STRING));
                String description = String.class.cast(expr5.evaluate(XMLDocument, XPathConstants.STRING));
                objeto.setResult(result);
                objeto.setCode(codigo);
                objeto.setDescription(description);
                objeto.setResponseData1(DTE_certificado);

            } else {
                XPathExpression expr4 = xpath.compile("//RequestTransactionResult/Response/Result");
                XPathExpression expr5 = xpath.compile("//RequestTransactionResult/Response/Description");
                String result = String.class.cast(expr4.evaluate(XMLDocument, XPathConstants.STRING));
                String description = String.class.cast(expr5.evaluate(XMLDocument, XPathConstants.STRING));
                objeto.setResult(result);
                objeto.setCode(codigo);
                objeto.setDescription(description);
                objeto.setResponseData1("");

            }

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
        return objeto;
    }

    public static long obtiene_numDteCertificado(String n) {
        long suma = 0;
        String parte1 = n.substring(9, 18);
        String parte2 = parte1.replaceAll("-", "");
        StringBuilder num = new StringBuilder(parte2).reverse();

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == 'A') {
                suma += 10 * (Math.pow(16, i));
            } else if (num.charAt(i) == 'B') {
                suma += 11 * (Math.pow(16, i));
            } else if (num.charAt(i) == 'C') {
                suma += 12 * (Math.pow(16, i));
            } else if (num.charAt(i) == 'D') {
                suma += 13 * (Math.pow(16, i));
            } else if (num.charAt(i) == 'E') {
                suma += 14 * (Math.pow(16, i));
            } else if (num.charAt(i) == 'F') {
                suma += 15 * (Math.pow(16, i));
            } else {
                suma = suma + Integer.parseInt("" + num.charAt(i)) * (long) Math.pow(16, i);
            }
        }
        return suma;
    }
    
    

}
