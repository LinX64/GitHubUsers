package com.client.githubusers.ui.views.util

import com.client.githubusers.data.model.UserDetailResponse
import com.client.githubusers.data.model.UserItem

object ViewUtil {

    fun getDummyUsers(): List<UserItem> {
        return mutableListOf(
            UserItem(
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                eventsUrl = "https://api.github.com/users/mojombo/events{/privacy}",
                followersUrl = "https://api.github.com/users/mojombo/followers",
                followingUrl = "https://api.github.com/users/mojombo/following{/other_user}",
                gistsUrl = "https://api.github.com/users/mojombo/gists{/gist_id}",
                gravatarId = "",
                htmlUrl = "",
                id = 1,
                login = "mojombo",
                nodeId = "MDQ6VXNlcjE=",
                organizationsUrl = "https://api.github.com/users/mojombo/orgs",
                receivedEventsUrl = "https://api.github.com/users/mojombo/received_events",
                reposUrl = "https://api.github.com/users/mojombo/repos",
                siteAdmin = false,
                starredUrl = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
                subscriptionsUrl = "https://api.github.com/users/mojombo/subscriptions",
                type = "User",
                url = "https://api.github.com/users/mojombo"
            ),
            UserItem(
                avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                eventsUrl = "https://api.github.com/users/mojombo/events{/privacy}",
                followersUrl = "https://api.github.com/users/mojombo/followers",
                followingUrl = "https://api.github.com/users/mojombo/following{/other_user}",
                gistsUrl = "https://api.github.com/users/mojombo/gists{/gist_id}",
                gravatarId = "",
                htmlUrl = "",
                id = 1,
                login = "defunkt",
                nodeId = "MDQ6VXNlcjE=",
                organizationsUrl = "https://api.github.com/users/mojombo/orgs",
                receivedEventsUrl = "https://api.github.com/users/mojombo/received_events",
                reposUrl = "https://api.github.com/users/mojombo/repos",
                siteAdmin = false,
                starredUrl = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
                subscriptionsUrl = "https://api.github.com/users/mojombo/subscriptions",
                type = "User",
                url = "https://api.github.com/users/mojombo"
            ),
        )
    }

    fun getDummyUser(): UserItem {
        return UserItem(
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            eventsUrl = "https://api.github.com/users/mojombo/events{/privacy}",
            followersUrl = "https://api.github.com/users/mojombo/followers",
            followingUrl = "https://api.github.com/users/mojombo/following{/other_user}",
            gistsUrl = "https://api.github.com/users/mojombo/gists{/gist_id}",
            gravatarId = "",
            htmlUrl = "",
            id = 1,
            login = "mojombo",
            nodeId = "MDQ6VXNlcjE=",
            organizationsUrl = "https://api.github.com/users/mojombo/orgs",
            receivedEventsUrl = "https://api.github.com/users/mojombo/received_events",
            reposUrl = "https://api.github.com/users/mojombo/repos",
            siteAdmin = false,
            starredUrl = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
            subscriptionsUrl = "https://api.github.com/users/mojombo/subscriptions",
            type = "User",
            url = "https://api.github.com/users/mojombo"
        )
    }

    fun getDummyUserDetail(): UserDetailResponse {
        return UserDetailResponse(
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            bio = "bio",
            blog = "blog",
            company = "company",
            createdAt = "createdAt",
            email = "email",
            eventsUrl = "eventsUrl",
            followers = 1,
            followersUrl = "followersUrl",
            following = 1,
            followingUrl = "followingUrl",
            gistsUrl = "gistsUrl",
            gravatarId = "gravatarId",
            hireable = true,
            htmlUrl = "htmlUrl",
            id = 1,
            location = "location",
            login = "login",
            name = "name",
            nodeId = "nodeId",
            organizationsUrl = "organizationsUrl",
            publicGists = 1,
            publicRepos = 1,
            receivedEventsUrl = "receivedEventsUrl",
            reposUrl = "reposUrl",
            siteAdmin = true,
            starredUrl = "starredUrl",
            subscriptionsUrl = "subscriptionsUrl",
            twitterUsername = "twitterUsername",
            type = "type",
            updatedAt = "updatedAt",
            url = "url"
        )
    }
}