package cf.varazdinevents.croatiaevents.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by antonio on 27/07/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForFragment {}
