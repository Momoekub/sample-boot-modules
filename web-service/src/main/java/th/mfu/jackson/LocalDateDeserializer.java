package th.mfu.jackson;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public LocalDateDeserializer() {
        this(null);
    }
    public LocalDateDeserializer(Class<LocalDate> clazz) {
        super(clazz);
    }
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        return LocalDate.parse(jsonParser.getText(), FORMATTER);
    }

}


