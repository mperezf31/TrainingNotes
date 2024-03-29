package com.mperez.trainingnotes.workouts.domain.usecase

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository

class GetExerciseUseCase(private val repository: WorkoutRepository) {

    suspend operator fun invoke(id: Int): Exercise? {
        return repository.getExerciseById(id)
    }
}