package com.mperez.trainingnotes.workouts.domain.usecase

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.model.InvalidExerciseException
import com.mperez.trainingnotes.workouts.domain.repository.WorkoutRepository
import kotlin.jvm.Throws

class AddExerciseUseCase(private val repository: WorkoutRepository) {

    @Throws(InvalidExerciseException::class)
    suspend operator fun invoke(exercise: Exercise){
        if (exercise.title.isBlank()){
            throw InvalidExerciseException("The title of the exercise can not be empty")
        }else if (exercise.content.isBlank()){
            throw InvalidExerciseException("The content of the exercise can not be empty")
        }
        repository.insertExercise(exercise)
    }
}