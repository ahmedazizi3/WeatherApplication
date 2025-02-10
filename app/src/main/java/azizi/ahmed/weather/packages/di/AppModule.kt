package azizi.ahmed.weather.packages.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import azizi.ahmed.weather.packages.data.WeatherDAO
import azizi.ahmed.weather.packages.data.WeatherDatabase
import azizi.ahmed.weather.packages.network.WeatherAPI
import azizi.ahmed.weather.packages.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideWeatherDAO(weatherDatabase: WeatherDatabase): WeatherDAO = weatherDatabase.weatherDAO()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext applicationContext: Context): WeatherDatabase
    = Room
        .databaseBuilder(
            context = applicationContext,
            klass = WeatherDatabase::class.java,
            name = "weatherDatabase"
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideWeatherAPI(): WeatherAPI {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }
}