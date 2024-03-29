package com.mperez.trainingnotes.workouts.presentation.workout

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory

sealed class WorkoutEvent {
    data class Filter(val category: ExerciseCategory) : WorkoutEvent()
    data class DeleteExercise(val exercise: Exercise) : WorkoutEvent()
    object AddExercise : WorkoutEvent()
}