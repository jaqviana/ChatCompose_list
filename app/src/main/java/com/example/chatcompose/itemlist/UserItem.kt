package com.example.chatcompose.itemlist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.chatcompose.model.User
import com.example.chatcompose.ui.theme.WHITE

//faz parte do lista (seria o Recyclerview do xml, desenha aqui os itens da lista.
@Composable
fun UserItem(
    userList: MutableList<User>,
    position: Int,
    context: Context
) {

    val name = userList[position].name
    val photoUser = userList[position].photo

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(WHITE)
    ) {

        val (txtName, photo, msg, line) = createRefs()

        Image(
            painter = painterResource(id = photoUser!!),
            contentDescription = "Photo Rachel",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(photo) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                },
            contentScale = ContentScale.Crop
        )

        androidx.compose.material.TextButton(
            onClick = {
                Toast.makeText(context, "User: $name", Toast.LENGTH_SHORT).show()
            },
            colors = androidx.compose.material.ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = WHITE
            ),
            modifier = Modifier.constrainAs(txtName) {
                start.linkTo(photo.end, margin = 20.dp)
                top.linkTo(parent.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        ) {
            Text(
                text = name!!,
                fontSize = 18.sp,


                )
        }
        Text(
            text = "You and that girl fron the copy place...",
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(msg) {
                top.linkTo(txtName.bottom)
                start.linkTo(photo.end, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        )

        Row(
            modifier = Modifier
                .background(Color.Gray)
                .width(250.dp)
                .height(1.dp)
                .constrainAs(line) {
                    start.linkTo(photo.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(msg.bottom, margin = 10.dp)
                }
        ) {

        }
    }
}



