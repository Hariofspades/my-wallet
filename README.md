# ₿ Wallet History
App to showcase the list of transactions made from the bitcoin wallet.

## Sneak-peek :tada:
![alt text](https://github.com/Hariofspades/my-wallet/blob/master/art/app.gif "app")
![alt text](https://github.com/Hariofspades/my-wallet/blob/master/art/error.png "error state")

## The big picture
The app is built to showcase the following

* Multi-module concept
* Tweaked clean architecture with MVVM
* Using DI
* Accomplishing MVVM using Architecture components
* Handling configuration changes using ViewModel
* Unit testing modules
* Animations using MotionLayout
* Handling states - Loading, Success and Error
* RxJava 2
* Material Design

## Libraries and Languages
* [Kotlin](https://kotlinlang.org/)
* [kodein](http://kodein.org)
* [RxJava2](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Timber](https://github.com/JakeWharton/timber)
* [Architecture Components & LiveData](https://developer.android.com/topic/libraries/architecture/)
* [MotionLayout](https://developer.android.com/reference/android/support/constraint/motion/MotionLayout)
* [Mockito](https://github.com/nhaarman/mockito-kotlin)
and few more design oriented libraries

## Architecture Layers (bottom to top)
* remote layer - provides remote services for API calls and takes care of all network related ops
* domain layer - core business logic residing area which has usecases and other interactors
* presentation layer - handles view data, place for ViewModels to reside
* app layer - UI of the app, contains all screens

## App Design
* Material collapsing toolbar
* Skeleton loading
* Green and orange colors to represent credit and debit
* Inspired by the app Rally, a Material 2.0 case study app

## My thoughts
* I have tweaked the mapping and layers of clean-architecture to fit this use-case. No data and cache layer
* I felt for a finance app, dark theme would be more appropriate to make the numbser stand out
* I did not show some of the data, like 'output' on the list. That data would be more suitable for a detail view which I thought it's out of scope
