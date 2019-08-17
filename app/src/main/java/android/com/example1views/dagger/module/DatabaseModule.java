package android.com.example1views.dagger.module;


import android.com.example1views.dagger.model.DatabaseSqlite;
import android.com.example1views.dagger.model.ImageDownloader;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    // Module,Provides,Singleton,Inject,Component

    private Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

//    @Provides @Singleton
//    Context provideDbContext(){
//        return context;
//    }

    @Provides @Singleton
    DatabaseSqlite provideDatabase(Context context){
        return new DatabaseSqlite(context);
    }
}
