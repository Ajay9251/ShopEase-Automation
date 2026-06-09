# ShopEase-Automation

## Overview

ShopEase-Automation is a Hybrid Automation Testing Framework developed using Selenium WebDriver, Java, TestNG, Maven, and Apache POI for automating end-to-end e-commerce workflows.

The framework is designed using the Page Object Model (POM) and Data-Driven Testing approach to ensure maintainability, reusability, and scalability.

## Key Features

* Developed a Hybrid Automation Framework using Page Object Model (POM) and Data-Driven Testing.
* Automated end-to-end e-commerce workflows including Login, Product Selection, Add to Cart, Cart Validation, Checkout, Payment Processing, Order Placement, and Logout functionalities.
* Implemented reusable Page Classes to separate web elements and business logic.
* Created a BaseClass to handle common functionalities such as browser launch, login, logout, and browser closure.
* Developed a FileLib utility class to read test data from Excel files and configuration data from Properties files using Apache POI.
* Integrated TestNG for test execution, assertions, test suite management, and report generation.
* Implemented TestNG Listeners to automatically capture screenshots for failed test cases, supporting debugging and failure analysis.
* Used Maven for dependency management and project configuration.

## Technology Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Apache POI

## Framework Design

* Hybrid Framework
* Page Object Model (POM)
* Data-Driven Testing
* TestNG Listeners

## Project Components

* BaseClass
* FileLib
* ListenerImplementation
* Page Classes
* Test Scripts
* Excel Test Data
* Properties Configuration File
* Screenshot Repository

## Project Structure

DemoWebShop-Automation
├── generic
│   ├── BaseClass.java
│   ├── FileLib.java
│   └── ListenerImplementation.java
│
├── pom
│   ├── LoginPage.java
│   ├── HomePage.java
│   ├── DashBoardPage.java
│   ├── ShoppingCartPage.java
│   ├── GiftCardPage.java
│   ├── VirtualGiftCardPage.java
│   └── CheckOut.java
│
├── testscripts
│   ├── Electronics.java
│   └── GiftCards.java
│
├── resources
│   ├── commondata.properties
│   └── testcase.xlsx
│
├── screenshots
├── test-output
├── pom.xml
└── testng.xml

