package ifsp.vitaesangue.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredPermission {
	ResourcesAllow resource();           
    TipoAcaoHistorico action() default TipoAcaoHistorico.READ;
}