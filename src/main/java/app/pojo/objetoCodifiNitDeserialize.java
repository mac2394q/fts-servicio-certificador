/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.pojo;

/**
 *
 * @author Priceleggan
 */

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class objetoCodifiNitDeserialize extends StdDeserializer<objetoCofidiNit> {
    
    public objetoCodifiNitDeserialize(Class<?> vc) {
        super(vc);
    }
    public objetoCodifiNitDeserialize() {
        this(null);
    }

    @Override
    public objetoCofidiNit deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        System.out.println("entro:---------------------");
        objetoCofidiNit objCifidiNit = new objetoCofidiNit();
        while(!jp.isClosed()){
            System.out.println("entro1:---------------------"+jp.nextToken().name());
            JsonToken jsonToken = jp.nextToken();
            System.out.println("entro2:---------------------");
            if(JsonToken.FIELD_NAME.equals(jsonToken)){
            System.out.println("entro3:---------------------");
                String fieldName = jp.getCurrentName();
                System.out.println(fieldName);

                jsonToken = jp.nextToken();

                if("Serial".equals(fieldName)){
                    // ftsTransaction.setSerial(parser.getValueAsLong());

                }
            }
        }
        return objCifidiNit;
    }

    
}
