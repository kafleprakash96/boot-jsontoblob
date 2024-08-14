# Spring Boot Application Setup

## Overview

This document provides instructions on how to run the Spring Boot application, including details on configuring `application.properties` and `.sql` files. You will also find code snippets and a guide on using the POST API.

#### A database schema with table is required in database. I have ran the following query in mysql.


<div class="code-container">
    <button class="copy-btn" onclick="copyToClipboard('sql-file')">Copy</button>
    <pre id="sql-file">
-- SQL schema for the article_blob database

CREATE DATABASE article_blob;

USE article_blob;

CREATE TABLE IF NOT EXISTS articles (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(255) NOT NULL,
content BLOB
);
</pre>
</div>
## Configuration Files

### `application.properties`

To configure the Spring Boot application, use the following properties in your `application.properties` file:
#### Replace url with your schema url if you are using other than article_blob.
#### Replace with your username and password.


<div class="code-container">
    <button class="copy-btn" onclick="copyToClipboard('application-properties')">Copy</button>
    <pre id="application-properties">
spring.datasource.url = jdbc:mysql://localhost:3306/article_blob
spring.datasource.username = root
spring.datasource.password = password

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto = update
</pre>
</div>

<style>
.code-container {
   font-size: 12px;
    position: relative;
    border-radius: 4px;
    padding: 10px;
    margin-top: 10px;
    font-family: monospace;

}
.code-container pre {
    margin: 0;
    white-space: pre-wrap;
    word-break: break-word;
}
.code-container .copy-btn {
    position: absolute;
    right: 15px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    padding: 5px 10px;
    cursor: pointer;
    font-size: 12px;
    z-index: 10;
}
.code-container .copy-btn:hover {
    background-color: #0056b3;
}
.filename {
    font-weight: bold;
    margin-bottom: 5px;
}
</style>

<script>
function copyToClipboard(id) {
    const codeElement = document.getElementById(id);
    const range = document.createRange();
    range.selectNode(codeElement);
    window.getSelection().removeAllRanges();
    window.getSelection().addRange(range);
    try {
        document.execCommand('copy');
        alert('Code copied to clipboard!');
    } catch (err) {
        console.error('Failed to copy code: ', err);
    }
    window.getSelection().removeAllRanges();
}
</script>

## Running the Spring Boot Application

To start the Spring Boot application, follow these steps:

1. **Build and Run**: Open your terminal, navigate to your project directory, and run the following command:

    ```bash
    ./mvnw spring-boot:run
    ```

   This will start the application on `localhost:8080`.


![Springboot Screenshot](/Users/prakashkafle/code/github-ss/blobtojson/spring-boot.png)


2. **Send a POST Request**: Use Postman to send a POST request to `http://localhost:8080/article/save`.

   **Sample Request Body: Use file article.json**


![Postman Screenshot](/Users/prakashkafle/code/github-ss/blobtojson/postman.png)

3. **Verify your database** : See if the content is stored as blob
4.
 ```bash
   select * from article;
 ```

![Database Screenshot](/Users/prakashkafle/code/github-ss/blobtojson/db.png)

