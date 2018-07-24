package br.inatel.pokemonbootcamp.di.qualifier;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Interface used to keep the Shared preference api token.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ApiTokenPreference {
}