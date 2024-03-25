package com.mperez.trainingnotes.workouts.data.datasource

import androidx.room.Database
import com.mperez.trainingnotes.workouts.domain.model.Exercise


@Database(entities = [Exercise::class], version = 1)
abstract class WorkoutDatabase {

    abstract val exerciseDao: ExerciseDao

}