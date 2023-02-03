# Android Common

In this project I keep the list of most libraries and helper classes that I commonly use during the development of my Android apps. I will try to keep this project updated constantly as I find better libraries to do the tasks or when I improve code in one of my classes.

## 🏛️ Architecture

This project uses of the [MVVM](https://en.wikipedia.org/wiki/Model–view–viewmodel) pattern and makes de binding between the Views and the ViewModels through reactive programming, with Kotlin Flow.

## ⚙️ Dependencies

I used a set of well-known Android libraries so we don't have to reinvent the wheel 🙃

* __Retrofit:__ to make HTTP requests and process the responses.

## 🎨 Code Correctness

This project uses [Ktlint](https://github.com/pinterest/ktlint) to keep the code formatted and [Detekt](https://github.com/detekt/detekt) to follow best practices. The linting is done by running the command below in the project's root dir:

```
$ ./gradlew ktlintFormat detekt
```

## 👨🏾‍💻 Author

Vinicius Egidio ([vinicius.io](http://vinicius.io))
