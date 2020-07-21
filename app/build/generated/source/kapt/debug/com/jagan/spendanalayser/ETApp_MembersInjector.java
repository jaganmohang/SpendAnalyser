// Generated by Dagger (https://google.github.io/dagger).
package com.jagan.spendanalayser;

import android.app.Activity;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ETApp_MembersInjector implements MembersInjector<ETApp> {
  private final Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;

  public ETApp_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<ETApp> create(
      Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider) {
    return new ETApp_MembersInjector(dispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(ETApp instance) {
    injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
  }

  public static void injectDispatchingAndroidInjector(
      ETApp instance, DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
    instance.dispatchingAndroidInjector = dispatchingAndroidInjector;
  }
}