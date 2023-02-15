# Pokemon Companion App

This is an Android application built using Kotlin that allows users to view a list of Pokemon and their details using the PokeAPI. The app utilizes several popular Android libraries, including Retrofit, ViewModel, LiveData, Coroutines, Navigation, and Glide.

## Table of Contents

- [Features](#features)
- [Libraries Used](#libraries-used)
- [API Used](#api-used)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [License](#license)

## Features

The Pokemon Companion App includes the following features:

- View a list of all Pokemon available in the PokeAPI
- View details of each Pokemon, including its name, image, height, weight, and abilities
- Navigate between the list of Pokemon and the details page using the Navigation library
- Load and display images using the Glide library
- Make API calls using the Retrofit library
- Use LiveData and ViewModel to manage and update UI state
- Use Coroutines to manage asynchronous tasks in a simple and efficient way

## Libraries Used

The following libraries were used to build this app:

| Library     | Purpose                                           |
| ----------- | ------------------------------------------------- |
| Retrofit    | Used for making API calls to the PokeAPI           |
| ViewModel   | Used for managing and updating UI state            |
| LiveData    | Used for observing and updating data in real time  |
| Coroutines  | Used for managing asynchronous tasks in the app   |
| Navigation  | Used for navigating between different screens     |
| Glide       | Used for loading and displaying images in the app |

Each library was chosen for a specific purpose based on its features and functionality. For example, Retrofit was used to make API calls because it simplifies the process of making network requests and parsing JSON data. ViewModel and LiveData were used to manage UI state because they provide a simple and efficient way to update the UI in response to changes in the underlying data. Coroutines were used to manage asynchronous tasks because they provide a simpler and more readable alternative to traditional threading models. Navigation was used to provide a simple and intuitive way for users to navigate between different screens in the app. Finally, Glide was used to load and display images because it provides a fast, efficient, and easy-to-use image loading solution.

## API Used

This app utilizes the PokeAPI, a public API that provides information about Pokemon. The API returns data in JSON format, which is parsed using Retrofit and displayed in the app.

## Screenshots

Here are some screenshots of the app in action:

![Screenshot_1676488673](https://user-images.githubusercontent.com/16981896/219138630-105f34c0-f63c-4161-9957-aa463072f560.png)
![Screenshot_1676488681](https://user-images.githubusercontent.com/16981896/219138633-42be3060-3608-46ef-9cfd-dc41c983e213.png)

## Installation

To install the app, follow these steps:

1. Clone the repository to your local machine
2. Open the project in Android Studio
3. Build the project and run it on an emulator or physical device

## License

This project is licensed under the MIT License. See the LICENSE file for details.
