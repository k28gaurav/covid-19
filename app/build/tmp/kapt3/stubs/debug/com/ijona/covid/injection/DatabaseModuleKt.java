package com.ijona.covid.injection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2 = {"DATABASE_NAME", "", "databaseModule", "Lorg/koin/core/module/Module;", "getDatabaseModule", "()Lorg/koin/core/module/Module;", "provideAppDatabase", "Lcom/ijona/covid/data/database/AppDatabase;", "context", "Landroid/content/Context;", "provideCoronaDao", "Lcom/ijona/covid/data/database/dao/CoronaEntityDao;", "database", "app_debug"})
public final class DatabaseModuleKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module databaseModule = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "corona_db";
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getDatabaseModule() {
        return null;
    }
    
    private static final com.ijona.covid.data.database.AppDatabase provideAppDatabase(android.content.Context context) {
        return null;
    }
    
    private static final com.ijona.covid.data.database.dao.CoronaEntityDao provideCoronaDao(com.ijona.covid.data.database.AppDatabase database) {
        return null;
    }
}