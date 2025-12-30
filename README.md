# Album Manager

## Overview

**Album Manager** is an Android application developed in Kotlin for managing music albums. The app allows users to view a list of albums, search by album title or singers, and create new albums with relevant details. It demonstrates the use of **Fragments, RecyclerView, ViewModel, LiveData, and JSON-based local storage**.

---

## Features

### Home Screen

* Displays a list of albums in a card/list view.
* Search bar to filter albums by title or singers.
* Floating Action Button (FAB) to navigate to the "Create Album" screen.
* Uses **LiveData** for reactive updates when albums are added or filtered.

### Create Album Screen

* Allows users to create a new album with:

  * **Album Title**: Accepts alphanumeric characters and special characters `[-,'&#()]` only.
  * **Publishing Year**: Dropdown menu (Spinner) from 1990 to 2030.
  * **Singers**: Multi-select AutoComplete with suggestions from a local JSON file; selected singers are displayed as chips.
* Validates input before saving.
* Adds new album to the existing list in Home Screen.

---

## Tech Stack

**Programming Language:**

* Kotlin

**Framework / Architecture:**

* Android Jetpack

  * ViewModel
  * LiveData
  * Navigation Component

**UI / Design:**

* XML Layouts
* RecyclerView
* Material Components (FloatingActionButton, Chips, TextInputLayout, Spinner)

**Data Management:**

* JSON (local storage in `assets`)
* In-memory state management via ViewModel / LiveData


**Tools / IDE:**

* Android Studio
* Gradle (build system)

---


## Author

Imthiyas Alam

