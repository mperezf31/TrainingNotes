package com.mperez.trainingnotes.workouts.domain.repository

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {

    fun getExercises(): Flow<List<Exercise>>
    suspend fun getExerciseById(id: Int): Exercise?
    suspend fun insertExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)
}