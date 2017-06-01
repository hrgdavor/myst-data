package hr.hrg.myst.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DirectSerializer  extends StdSerializer<DirectSerializerReady>{

	private static final long serialVersionUID = 1L;

	public DirectSerializer() {
		super(DirectSerializerReady.class);
	}
	
	@Override
	public void serialize(DirectSerializerReady value, JsonGenerator jgen, SerializerProvider provider)throws IOException {
		value.serialize(jgen, provider);
	}
	
}
