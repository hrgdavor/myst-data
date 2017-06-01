package hr.hrg.myst.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

public interface DirectSerializerReady {

	public void serialize( JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException;
	
}
