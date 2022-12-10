package biz.dirion.userandposts.ui.userposts

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import biz.dirion.userandposts.domain.models.Post
import biz.dirion.userandposts.ui.theme.UserPostsTheme

@Composable
fun PostItemHolder(item: Post) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Box {
            Column(modifier = Modifier.wrapContentSize()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp).width(40.dp),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Cursive,
                        text = "Title:",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                        text = item.title,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp).width(40.dp),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Cursive,
                        text = "Body:",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = item.body,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Preview(showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PostItemHolderPreview() {
    UserPostsTheme {
        PostItemHolder(
            Post(
                id = 1L,
                userId = 1L,
                title = "SimpleTitle",
                body = "SimpleSubtitle"
            )
        )
    }
}