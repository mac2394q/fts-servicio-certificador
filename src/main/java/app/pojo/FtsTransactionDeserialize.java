package app.pojo;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
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

public class FtsTransactionDeserialize extends StdDeserializer<FtsTransaction> {

    public FtsTransactionDeserialize(Class<?> vc) {
        super(vc);
    }
    public FtsTransactionDeserialize() {
        this(null);
    }

    @Override
    public FtsTransaction deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        System.out.println("entro:---------------------");
        FtsTransaction ftsTransaction = new FtsTransaction();
        while(!parser.isClosed()){
            System.out.println("entro1:---------------------"+parser.nextToken().name());
            JsonToken jsonToken = parser.nextToken();
            System.out.println("entro2:---------------------");
            if(JsonToken.FIELD_NAME.equals(jsonToken)){
            System.out.println("entro3:---------------------");
                String fieldName = parser.getCurrentName();
                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                if("Serial".equals(fieldName)){
                    // ftsTransaction.setSerial(parser.getValueAsLong());

                }
            }
        }
        return ftsTransaction;
    }

//    @Override
//    public FtsTransaction deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
//        System.out.println("entro:---------------------");
//        FtsTransaction ftsTransaction = new FtsTransaction();
//        final ObjectCodec codec = parser.getCodec();
//        System.out.println("entro1:---------------------"+codec.toString());
//        final JsonNode node = codec.readTree(parser);
//        System.out.println("entro2:---------------------");
//        try {
//            final JsonNode colorNode = node.get("Serial");
//            ftsTransaction.setSerial(Long.parseLong(colorNode.asText()));
//        } catch (final Exception e) {
//           // Logger.debug("101_parse_exeption: unknown json.");
//     System.out.println("error:---------------------");
//        }
//        return ftsTransaction;
//    }

}