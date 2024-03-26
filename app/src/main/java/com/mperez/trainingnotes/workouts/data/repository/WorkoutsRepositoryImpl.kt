package com.mperez.trainingnotes.workouts.data.repository

import com.mperez.trainingnotes.workouts.data.datasource.ExerciseDao
import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow

class WorkoutsRepositoryImpl(private val dao: ExerciseDao) : WorkoutRepository {

    override fun getExercises(): Flow<List<Exercise>> = dao.getExercises()

    override suspend fun getExerciseById(id: Int): Exercise? = dao.getExerciseById(id)

    override suspend fun insertExercise(exercise: Exercise) = dao.insertExercise(exercise)

    override suspend fun deleteExercise(exercise: Exercise)= dao.deleteExercise(exercise)
}