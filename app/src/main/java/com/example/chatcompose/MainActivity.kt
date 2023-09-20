package com.example.chatcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatcompose.itemlist.UserItem
import com.example.chatcompose.model.User
import com.example.chatcompose.ui.theme.ChatComposeTheme
import com.example.chatcompose.ui.theme.GREEN200
import com.example.chatcompose.ui.theme.WHITE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ChatComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar (
                            backgroundColor = GREEN200,
                           title = {
                               androidx.compose.material.Text(text = "Chat")
                           },
                            contentColor = WHITE
                        )
                    },
                    backgroundColor = WHITE
                ) {
                    UserList()
               // }
            }
        }
    }
}

//faz parte do "RecyclerView"
@Composable
fun UserList(){

    val context = LocalContext.current

    //dados fake
    val userList: MutableList<User> = mutableListOf(
        User("Ross Geller", R.drawable.ross),
        User("Rachel Green", R.drawable.rachel),
        User("Monica Geller", R.drawable.rachel),
        User("Ross Geller", R.drawable.ross),
        User("Rachel Green", R.drawable.rachel),
        User("Rachel Green", R.drawable.rachel),
        User("Ross Geller", R.drawable.ross),
        User("Rachel Green", R.drawable.rachel),
        User("Rachel Green", R.drawable.rachel),
        User("Ross Geller", R.drawable.ross),
        User("Rachel Green", R.drawable.rachel),
        User("Rachel Green", R.drawable.rachel),
    )
    //"RecyclerView" na horizontal LazyRow
    LazyColumn{
        itemsIndexed(userList){positon,_ -> //_ eh o item de lista (UserItem)
            UserItem(userList = userList, position = positon, context = context )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatComposeTheme {

    }
}