package com.mperez.trainingnotes.di

import android.app.Application
import androidx.room.Room
import com.mperez.trainingnotes.workouts.data.datasource.WorkoutDatabase
import com.mperez.trainingnotes.workouts.data.repository.WorkoutsRepositoryImpl
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository
import com.mperez.trainingnotes.workouts.domain.usecase.AddExerciseUseCase
import com.mperez.trainingnotes.workouts.domain.usecase.DeleteExerciseUseCase
import com.mperez.trainingnotes.workouts.domain.usecase.ExerciseUseCases
import com.mperez.trainingnotes.workouts.domain.usecase.GetExerciseUseCase
import com.mperez.trainingnotes.workouts.domain.usecase.GetExercisesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWorkoutDatabase(app: Application): WorkoutDatabase {
        return Room.databaseBuilder(
            app,
            WorkoutDatabase::class.java,
            "workout_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutRepository(db: WorkoutDatabase): WorkoutRepository {
        return WorkoutsRepositoryImpl(db.exerciseDao)
    }

    @Provides
    @Singleton
    fun provideExerciseUseCases(workoutsRepository: WorkoutRepository): ExerciseUseCases {
        return ExerciseUseCases(
            getExercisesUseCase = GetExercisesUseCase(workoutsRepository),
            deleteExerciseUseCase = DeleteExerciseUseCase(workoutsRepository),
            insertExerciseUseCase = AddExerciseUseCase(workoutsRepository),
            getExerciseUseCase = GetExerciseUseCase(workoutsRepository)
        )
    }

}