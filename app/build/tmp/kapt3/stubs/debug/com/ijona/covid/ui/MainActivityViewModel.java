package com.ijona.covid.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001fH\u0014J\u0006\u0010$\u001a\u00020\u001fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/ijona/covid/ui/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/ijona/covid/data/repository/Repo;", "(Lcom/ijona/covid/data/repository/Repo;)V", "confirmCase", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ijona/covid/data/database/model/Area;", "confirmedCaseLiveData", "Landroidx/lifecycle/MediatorLiveData;", "getConfirmedCaseLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "setConfirmedCaseLiveData", "(Landroidx/lifecycle/MediatorLiveData;)V", "coronaData", "Lcom/mapbox/geojson/Feature;", "coronaLiveData", "getCoronaLiveData", "setCoronaLiveData", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "interval", "", "getRepo", "()Lcom/ijona/covid/data/repository/Repo;", "timer", "Ljava/util/Timer;", "coronaDataSource", "", "handleError", "throwable", "", "onCleared", "refreshData", "app_debug"})
public final class MainActivityViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MediatorLiveData<java.util.List<com.mapbox.geojson.Feature>> coronaLiveData;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.mapbox.geojson.Feature>> coronaData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MediatorLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> confirmedCaseLiveData;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> confirmCase;
    private final long interval = 10L;
    private java.util.Timer timer;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineExceptionHandler coroutineExceptionHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ijona.covid.data.repository.Repo repo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.mapbox.geojson.Feature>> getCoronaLiveData() {
        return null;
    }
    
    public final void setCoronaLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MediatorLiveData<java.util.List<com.mapbox.geojson.Feature>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> getConfirmedCaseLiveData() {
        return null;
    }
    
    public final void setConfirmedCaseLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MediatorLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> p0) {
    }
    
    public final void refreshData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineExceptionHandler getCoroutineExceptionHandler() {
        return null;
    }
    
    private final void handleError(java.lang.Throwable throwable) {
    }
    
    public final void coronaDataSource() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ijona.covid.data.repository.Repo getRepo() {
        return null;
    }
    
    public MainActivityViewModel(@org.jetbrains.annotations.NotNull()
    com.ijona.covid.data.repository.Repo repo) {
        super();
    }
}