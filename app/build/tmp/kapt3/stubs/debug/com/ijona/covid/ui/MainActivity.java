package com.ijona.covid.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\u0017H\u0014J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0014J\b\u0010#\u001a\u00020\u0017H\u0014J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0014J\b\u0010)\u001a\u00020\u0017H\u0014J\u0014\u0010*\u001a\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\b\u0010.\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/ijona/covid/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ICON_ID", "", "LAYER_ID", "SOURCE_ID", "adapterS2", "Lcom/ijona/covid/ui/adapter/CovidAdapter;", "mapboxMap", "Lcom/mapbox/mapboxsdk/maps/MapboxMap;", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/LinearLayout;", "style", "Lcom/mapbox/mapboxsdk/maps/Style$Builder;", "viewModel", "Lcom/ijona/covid/ui/MainActivityViewModel;", "getViewModel", "()Lcom/ijona/covid/ui/MainActivityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addClusteredGeoJsonSource", "", "loadedMapStyle", "Lcom/mapbox/mapboxsdk/maps/Style;", "initBottomSheet", "initMap", "savedInstanceState", "Landroid/os/Bundle;", "initObserver", "onCreate", "onDestroy", "onLowMemory", "onPause", "onResume", "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "onStart", "onStop", "refreshMapData", "data", "", "Lcom/mapbox/geojson/Feature;", "setupRvS2", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.mapbox.mapboxsdk.maps.MapboxMap mapboxMap;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.LinearLayout> sheetBehavior;
    private com.ijona.covid.ui.adapter.CovidAdapter adapterS2;
    private com.mapbox.mapboxsdk.maps.Style.Builder style;
    private final java.lang.String SOURCE_ID = "SOURCE_ID";
    private final java.lang.String ICON_ID = "ICON_ID";
    private final java.lang.String LAYER_ID = "LAYER_ID";
    private java.util.HashMap _$_findViewCache;
    
    private final com.ijona.covid.ui.MainActivityViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public void onLowMemory() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState, @org.jetbrains.annotations.NotNull()
    android.os.PersistableBundle outPersistentState) {
    }
    
    private final void initBottomSheet() {
    }
    
    private final void initObserver() {
    }
    
    private final void setupRvS2() {
    }
    
    private final void addClusteredGeoJsonSource(com.mapbox.mapboxsdk.maps.Style loadedMapStyle) {
    }
    
    public final void refreshMapData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mapbox.geojson.Feature> data) {
    }
    
    private final void initMap(android.os.Bundle savedInstanceState) {
    }
    
    public MainActivity() {
        super();
    }
}