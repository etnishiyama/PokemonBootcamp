package br.inatel.pokemonbootcamp.di.qualifier;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Qualifier to identify injections related to {@link retrofit2.Retrofit}.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface RetrofitQualifier {
}