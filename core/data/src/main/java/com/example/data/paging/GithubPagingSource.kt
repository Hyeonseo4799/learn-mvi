package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.dto.User
import com.example.network.dto.UserResponse

private const val STARTING_PAGE = 1

internal class GithubPagingSource(
    private val searchUsers: suspend (page: Int) -> UserResponse
) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val currentPage = params.key ?: STARTING_PAGE
        val data = searchUsers(currentPage)

        return LoadResult.Page(
            data = data.users,
            prevKey = if (currentPage == STARTING_PAGE) null else currentPage - 1,
            nextKey = if (currentPage == data.total) null else currentPage + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let { anchorPage ->
                anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
            }
        }
    }
}