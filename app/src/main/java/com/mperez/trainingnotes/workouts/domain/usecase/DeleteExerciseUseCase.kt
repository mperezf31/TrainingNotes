package com.mperez.trainingnotes.workouts.domain.usecase

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository

class DeleteExerciseUseCase(private val repository: WorkoutRepository) {

    suspend operator fun invoke(exercise: Exercise){
        repository.deleteExercise(exercise)
    }
}