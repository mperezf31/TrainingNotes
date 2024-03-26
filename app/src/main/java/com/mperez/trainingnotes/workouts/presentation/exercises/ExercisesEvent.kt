package com.mperez.trainingnotes.workouts.presentation.exercises

import com.mperez.trainingnotes.workouts.domain.model.Exercise
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory

sealed class ExercisesEvent {
    data class Filter(val category: ExerciseCategory): ExercisesEvent()
    data class DeleteNote(val exercise: Exercise): ExercisesEvent()
}