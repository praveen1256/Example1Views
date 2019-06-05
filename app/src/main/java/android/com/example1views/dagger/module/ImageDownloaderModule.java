package android.com.example1views.dagger.module;


import android.com.example1views.dagger.model.ImageDownloader;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ImageDownloaderModule {

    // Module,Provides,Singleton,Inject,Component

    private Context context;

    public ImageDownloaderModule(Context context){
        this.context = context;
    }

    @Provides @Singleton
    Context provideContext(){
        return context;
    }

    @Provides @Singleton
    ImageDownloader provideImageDownloader(Context context){
        return new ImageDownloader(context);
    }
}
