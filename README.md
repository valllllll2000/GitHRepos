# GitHRepos

Displays a list of github repositories in a list screen and some detail about them in a detail screen. We use this github API https://developer.github.com/v3/search/. Written in Kotlin.

### Screenshots
<img src="https://user-images.githubusercontent.com/923280/51608877-f913a080-1f18-11e9-94c5-91545440fa19.png" width="200">
<img src="https://user-images.githubusercontent.com/923280/51608876-f913a080-1f18-11e9-8a43-74282eaf896f.png" width="200">

### Libraries used 
* [Koin](https://github.com/InsertKoinIO/koin): for dependency injection
* [Retrofit 2](https://github.com/square/retrofit): for network call
* [Glide](https://github.com/bumptech/glide): for loading images (user avatar)

We also use AndroidX, RecyclerView (for the list), ConstraintLayout (for the detail), Databinding (for the list), ModelView and Lifecycle extensions (for the list only for now), clean architecture. I use [Travis](https://travis-ci.org/valllllll2000/GitHRepos) as CI and there is a [ktlint](https://github.com/shyiko/ktlint) file to verify code style. 

### Download
A debug build can be downloaded directly to a device using [https://bit.ly/2FUUbkc](https://bit.ly/2FUUbkc)
