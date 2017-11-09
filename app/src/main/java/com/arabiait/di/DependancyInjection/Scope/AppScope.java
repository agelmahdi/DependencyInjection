package com.arabiait.di.DependancyInjection.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
