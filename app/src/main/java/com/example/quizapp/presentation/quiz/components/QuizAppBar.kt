package com.example.quizapp.presentation.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

@Composable
fun QuizAppBar(
    category: String,
    onEventIconBack: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = colorResource(R.color.dark_slate_blue),
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    vertical = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = {
                    onEventIconBack.invoke()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(
                        size = 24.dp
                    )
                )
            }

            Spacer(
                modifier = Modifier.width(
                    width = 4.dp
                )
            )

            Text(
                text = category,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }

    /*TopAppBar(
        modifier = Modifier.fillMaxWidth(),

        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(R.color.dark_slate_blue),
            actionIconContentColor = colorResource(R.color.blue_grey),
            navigationIconContentColor = colorResource(R.color.blue_grey)
        ),

        title = {
            Text(
                text = category,
                color = colorResource(R.color.blue_grey),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        },

        navigationIcon = {
            IconButton(
                onClick = {
                    onEventIconBack.invoke()
                }
            ) {
                Icon(
                    modifier = Modifier.size(
                        size = 24.dp
                    ),
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )*/

}

@Preview(showBackground = false)
@Composable
fun PreviewQuizAppBar() {
    QuizAppBar(
        category = "GK",
        onEventIconBack = {}
    )
}