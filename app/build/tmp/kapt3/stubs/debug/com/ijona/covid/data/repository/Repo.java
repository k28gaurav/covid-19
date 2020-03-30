package com.ijona.covid.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010!\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J!\u0010#\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/ijona/covid/data/repository/Repo;", "", "apiService", "Lcom/ijona/covid/data/network/category/ApiService;", "coronaEntityDao", "Lcom/ijona/covid/data/database/dao/CoronaEntityDao;", "(Lcom/ijona/covid/data/network/category/ApiService;Lcom/ijona/covid/data/database/dao/CoronaEntityDao;)V", "confirmCase", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ijona/covid/data/database/model/Area;", "getConfirmCase", "()Landroidx/lifecycle/MutableLiveData;", "setConfirmCase", "(Landroidx/lifecycle/MutableLiveData;)V", "coronaLiveData", "Lcom/mapbox/geojson/Feature;", "getCoronaLiveData", "countryNameList", "", "", "longLatList", "buildAreaListRecursive", "", "areaList", "area", "buildData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLocationData", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAllBingCovidAreaByAreaParentId", "parentId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCovidDataFromBingAPiAndSaveToDb", "forceUpdate", "", "(Lkotlin/coroutines/CoroutineContext;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLngLatFromCountryName", "countryName", "app_debug"})
public final class Repo {
    private final java.util.List<java.lang.String> countryNameList = null;
    private final java.util.List<com.mapbox.geojson.Feature> longLatList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.mapbox.geojson.Feature>> coronaLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> confirmCase;
    private final com.ijona.covid.data.network.category.ApiService apiService = null;
    private final com.ijona.covid.data.database.dao.CoronaEntityDao coronaEntityDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.mapbox.geojson.Feature>> getCoronaLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> getConfirmCase() {
        return null;
    }
    
    public final void setConfirmCase(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.ijona.covid.data.database.model.Area>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchCovidDataFromBingAPiAndSaveToDb(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.CoroutineContext coroutineContext, boolean forceUpdate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    private final void buildAreaListRecursive(java.util.List<com.ijona.covid.data.database.model.Area> areaList, com.ijona.covid.data.database.model.Area area) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAllBingCovidAreaByAreaParentId(@org.jetbrains.annotations.NotNull()
    java.lang.String parentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ijona.covid.data.database.model.Area>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object buildLocationData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    private final void getLngLatFromCountryName(java.lang.String countryName) {
    }
    
    public Repo(@org.jetbrains.annotations.NotNull()
    com.ijona.covid.data.network.category.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.ijona.covid.data.database.dao.CoronaEntityDao coronaEntityDao) {
        super();
    }
}