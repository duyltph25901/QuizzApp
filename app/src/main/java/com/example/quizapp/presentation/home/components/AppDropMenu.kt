package com.example.quizapp.presentation.home.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.presentation.common.ListMenu.getListNumberOfQuestions
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropMenu(
    menuName: String = stringResource(R.string.menuName1),
    menuList: List<String> = getListNumberOfQuestions(),
    text: String = "",
    onDropdownClick: (item: String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp
            )
    ) {
        Text(
            text = menuName,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(
            modifier = Modifier.height(
                height = 8.dp
            )
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpand ->
                isExpanded = isExpand
            }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                value = text,
                onValueChange = { _ ->

                },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = isExpanded
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = colorResource(R.color.blue_grey),
                    unfocusedTextColor = colorResource(R.color.blue_grey),
                    focusedTrailingIconColor = colorResource(R.color.orange),
                    unfocusedTrailingIconColor = colorResource(R.color.orange),
                    focusedContainerColor = colorResource(R.color.dark_slate_blue),
                    unfocusedContainerColor = colorResource(R.color.dark_slate_blue),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(
                    size = 16.dp,
                ),
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            )

            Box (
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                DropdownMenu(
                    modifier = Modifier
                        .fillMaxWidth(fraction = .9f)
                        .background(
                            color = colorResource(R.color.mid_night_blue)
                        ),
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                    },
                ) {
                    menuList.forEachIndexed { index: Int, menu ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = menu,
                                    color = colorResource(R.color.blue_grey)
                                )
                            },
                            onClick = {
                                isExpanded = false
                                onDropdownClick.invoke(menuList[index])
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }
    }

}