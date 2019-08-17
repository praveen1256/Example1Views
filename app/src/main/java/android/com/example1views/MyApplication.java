package android.com.example1views;

import android.app.Application;
import android.com.example1views.dagger.component.DaggerImageDownloaderComponent;
import android.com.example1views.dagger.component.ImageDownloaderComponent;
import android.com.example1views.dagger.module.DatabaseModule;
import android.com.example1views.dagger.module.ImageDownloaderModule;

public class MyApplication extends Application {

    private static MyApplication app;
    private ImageDownloaderComponent imageDownloaderComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        imageDownloaderComponent = DaggerImageDownloaderComponent.
                builder().
                databaseModule(new DatabaseModule(this)).
                imageDownloaderModule(new ImageDownloaderModule(this)).build();

    }

    public static MyApplication app() {
        return app;
    }

    public ImageDownloaderComponent getImageDownloaderComponent() {
        return this.imageDownloaderComponent;
    }

}
