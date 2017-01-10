package fr.gtm.biblio.inventaire.cdi.interceptors;




import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;



@InterceptorBinding
@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Transaction {

}
 