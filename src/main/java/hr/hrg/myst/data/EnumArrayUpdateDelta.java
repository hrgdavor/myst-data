package hr.hrg.myst.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=DirectSerializer.class)
public final class EnumArrayUpdateDelta<E extends Enum<E>> implements UpdateDelta<E>, EnumGetter<E>, DirectSerializerReady{

	protected long changeSet;
	protected Object[] values;
	private E[] universe;

	public EnumArrayUpdateDelta(long changeSet, Object[] values, E[] universe) {
		this.changeSet = changeSet;
		this.values = values;
		this.universe = universe;
	}

	@Override
	public final boolean isEmpty() {
		return changeSet == 0;
	}
	
	@Override
	public final boolean isChanged(E column) {
        return (changeSet & (1L << column.ordinal())) != 0;
	}

	@Override
	public final boolean isChanged(int ordinal) {
		return (changeSet & (1L << ordinal)) != 0;
	}

	@Override
	public final Object getValue(E column) {
		return values[column.ordinal()];
	}

	@Override
	public final Object getValue(int ordinal) {
		return values[ordinal];
	}

	@Override
	public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		jgen.writeStartObject();

		int count = values.length;
		for(int i=0; i<count; i++){
			if((changeSet & (1L << i)) != 0) jgen.writeObjectField(universe[i].name(), values[i]);
		}

		jgen.writeEndObject();		
	}

}