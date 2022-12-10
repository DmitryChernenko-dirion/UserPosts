package biz.dirion.userandposts.data

import retrofit2.http.GET

interface ApiService {

    @GET("https://my-json-server.typicode.com/SharminSirajudeen/test_resources/users")
    suspend fun getUsers(): List<UserResponse>

    @GET("https://my-json-server.typicode.com/SharminSirajudeen/test_resources/posts")
    suspend fun getPosts(): List<PostResponse>
}