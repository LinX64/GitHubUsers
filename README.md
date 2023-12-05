# GitHub Users - Assessment

## Introduction

This is a sample project for dealing with GitHub APIs (more specifically,
the [GitHub Users API](https://docs.github.com/en/rest/reference/users)). This project was built
100% using Jetpack Compose and the MVVM architecture.

The only issue with the `/users` endpoint is that it doesn't return all users from GitHub. It is
the limitation of the API. It only returns the first 30 users per page, as it is using pagination.

**TODO:** One solution to that is
using: [Search Users API](https://docs.github.com/en/rest/reference/search#search-users)

## Features

- Search for GitHub users
- View user details
- Material 3 SearchBar - totally customizable & new
- Version Catalog - for managing dependencies
- Jetpack Compose
- MVVM
- Kotlin Coroutines
- Offline caching - using the http interceptor
- Dependency Injection - using Koin
- Unit tests - using JUnit 4 & Koin + Turbine for testing Flows

## Screenshots

<p>
<img src="https://i.imgur.com/49xm4dn.png" height="400px" />

<img src="https://i.imgur.com/ao3Ehid.png" height="400px" />

<img src="https://i.imgur.com/hGvz7SF.png" height="400px" />

<img src="https://i.imgur.com/NaR4pnd.png" height="400px" />
</p>    