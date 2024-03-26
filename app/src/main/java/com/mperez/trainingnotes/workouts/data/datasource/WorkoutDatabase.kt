package com.mperez.trainingnotes.workouts.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mperez.trainingnotes.workouts.domain.model.Exercise


@Database(entities = [Exercise::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {

    abstract val exerciseDao: ExerciseDao

}