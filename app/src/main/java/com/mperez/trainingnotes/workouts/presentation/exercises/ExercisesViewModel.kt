package com.mperez.trainingnotes.workouts.presentation.exercises

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory
import com.mperez.trainingnotes.workouts.domain.usecase.ExerciseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val exerciseUseCases: ExerciseUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ExercisesState())
    val state: State<ExercisesState> = _state

    private var getExercisesJob: Job? = null

    init {
        getExercises()
    }

    fun onEvent(event: ExercisesEvent) {
        when (event) {
            is ExercisesEvent.DeleteNote -> {
                viewModelScope.launch {
                    exerciseUseCases.deleteExerciseUseCase(exercise = event.exercise)
                }
            }

            is ExercisesEvent.Filter -> getExercises(event.category)
        }
    }

    private fun getExercises(category: ExerciseCategory? = null) {
        getExercisesJob?.cancel()
        getExercisesJob = exerciseUseCases.getExercisesUseCase(category).onEach { exercises ->
            _state.value = state.value.copy(exercises = exercises)
        }.launchIn(viewModelScope)
    }

}