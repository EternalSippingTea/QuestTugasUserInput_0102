package com.example.questtugasuserinput_102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.questtugasuserinput_102.ui.theme.QuestTugasUserInput_102Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTugasUserInput_102Theme {
                FormDataDiri()
            }
        }
    }
}
