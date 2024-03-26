package com.mperez.trainingnotes.workouts.domain.usecase

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetExercisesUseCase(private val repository: WorkoutRepository) {

    operator fun invoke(category: ExerciseCategory? = null): Flow<List<Exercise>> {
        return category?.let {
            repository.getExercises().map { exercises -> exercises.filter { it.category == category } }
        } ?: repository.getExercises()
    }
}