package com.mperez.trainingnotes.workouts.domain.usecase

data class ExerciseUseCases(
    val getExercisesUseCase: GetExercisesUseCase,
    val deleteExerciseUseCase: DeleteExerciseUseCase,
    val insertExerciseUseCase: AddExerciseUseCase,
    val getExerciseUseCase: GetExerciseUseCase
)