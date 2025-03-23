package com.example.quizapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

@Composable
fun BtnBox(
    textValue: String = stringResource(R.string.btn_gen_quiz),
    onEventGenerateQuiz: () -> Unit
) {
    TextButton (
        modifier = Modifier.fillMaxWidth()
            .padding(
                horizontal = 12.dp
            )
            .clip(
                shape = RoundedCornerShape(
                    size = 24.dp
                )
            )
            .background(
                color = colorResource(R.color.blue_grey)
            ),
        onClick = {
            onEventGenerateQuiz.invoke()
        }
    ) {
        Text(
            text = textValue,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}