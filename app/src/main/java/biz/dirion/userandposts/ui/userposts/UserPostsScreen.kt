package biz.dirion.userandposts.ui.userposts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import biz.dirion.userandposts.domain.models.Post
import biz.dirion.userandposts.domain.models.User
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import timber.log.Timber

@Composable
fun UserPostsScreen(
    viewModel: UserPostsViewModel = hiltViewModel()
) {
    val lazyListState = rememberLazyListState()
    val uiState = viewModel.uiState

    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 20.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
            ) {

                Image(
                    painter = rememberAsyncImagePainter(uiState.user?.thumbnailUrl),
                    contentDescription = "User avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
        items(uiState.list) { item ->
            PostItemHolder(item)
            Timber.d(item.toString())
        }
    }
}