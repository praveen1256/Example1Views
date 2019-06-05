package android.com.example1views.dagger.component;
import android.com.example1views.MainActivity;
import android.com.example1views.dagger.module.ImageDownloaderModule;
import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component (modules = ImageDownloaderModule.class)
public interface ImageDownloaderComponent {
    void inject(MainActivity mainActivity);
}
