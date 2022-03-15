package com.geeksforgeeks.jclinkify

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.util.LinkifyCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | Linkify", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){

    val mContext = LocalContext.current
    val mCustomLinkifyText = remember {TextView(mContext)}

    val mText = "GeeksforGeeks\n" +
            "https://www.geeksforgeeks.org\n" +
            "5th & 6th Floor, Royal Kapsons, A- 118,\n" +
            "Sector- 136, Noida, Uttar Pradesh, India\n" +
            "feedback@geeksforgeeks.org\n" +
            "1800 258 4458"

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        AndroidView(factory = { mCustomLinkifyText }) { textView ->
            textView.text = mText
            textView.textSize = 20F
            LinkifyCompat.addLinks(textView, Linkify.ALL)
            textView.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}