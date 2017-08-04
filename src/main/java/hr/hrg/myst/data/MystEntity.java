package hr.hrg.myst.data;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MystEntity {
	public String table();

	public boolean genMeta() default true;

	boolean genUpdate() default true;
}
