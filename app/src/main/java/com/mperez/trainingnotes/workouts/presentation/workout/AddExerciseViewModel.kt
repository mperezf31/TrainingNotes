package com.mperez.trainingnotes.workouts.presentation.workout

import androidx.lifecycle.ViewModel
import com.mperez.trainingnotes.workouts.domain.usecase.ExerciseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddExerciseViewModel @Inject constructor(
    private val exerciseUseCases: ExerciseUseCases
) : ViewModel() {

}