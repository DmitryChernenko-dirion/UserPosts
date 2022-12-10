package biz.dirion.userandposts.ui.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import biz.dirion.userandposts.domain.models.User
import coil.compose.AsyncImage

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel(),
    onUserClick: (User) -> Unit
) {
    val uiState = viewModel.uiState

    if (uiState.isEmpty) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Empty",
            color = MaterialTheme.colorScheme.onBackground
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(uiState.list) { item ->
                UserItem(item = item, onUserClick = onUserClick)
            }
        }
    }
}

@Composable
fun UserItem(item: User, onUserClick: (User) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable { onUserClick(item) }
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier.wrapContentSize()) {
                    AsyncImage(
                        modifier = Modifier.size(90.dp),
                        model = item.thumbnailUrl,
                        contentDescription = null
                    )
                }

                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = item.name,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Posts count: ${item.postsCount}",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}