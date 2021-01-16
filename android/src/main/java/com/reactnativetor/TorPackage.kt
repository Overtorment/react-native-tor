package com.reactnativetor

import java.util.Arrays
import java.util.Collections

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.facebook.react.bridge.JavaScriptModule
import android.content.pm.PackageManager

class TorPackage : ReactPackage {

  //init {
  //      val manager = reactContext.getPackageManager();
  //      val ai = manager.getApplicationInfo(reactContext.getPackageName(), PackageManager.GET_META_DATA);
  //      val bundle = ai.metaData;
  //      val libName = bundle.getString("android.app.sifir_android");
  //      System.loadLibrary(libName);
  ////  System.loadLibrary("sifir_android");
  //}

  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    val manager = reactContext.getPackageManager();
    val ai = manager.getApplicationInfo(reactContext.getPackageName(), PackageManager.GET_META_DATA);
    val bundle = ai.metaData;
    val libName = bundle.getString("android.app.sifir_android");
    System.loadLibrary(libName);
    return Arrays.asList<NativeModule>(TorModule(reactContext))
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return emptyList<ViewManager<*, *>>()
  }
}
