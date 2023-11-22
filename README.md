
#  TODO App Backend


Backend made with Kotlin + Spring + PostgreSQL


## Features

Set with proper controller, basic data validation and CORS optimalization for frontend.


## Tech Stack

**Client:** HERE: [https://github.com/Repith/todo-app-front](https://github.com/Repith/todo-app-front)

**Backend:** Kotlin + Spring + PostgreSQL



## Installation

Install PostgreSQL using Docker:

```bash
  docker run --name contains-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres  
```

Configure your **application.properties** file with PostgreSQL settings.

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

Run project with proper Java compiler.

By default server should run on http://localhost:8080 and move forward to set up a frontend.



## Screenshots

![Landing](https://github.com/Repith/Repith/blob/main/public/TODO/todo1.png)
![Edit](https://github.com/Repith/Repith/blob/main/public/TODO/todo2.png)
![Responsivness](https://github.com/Repith/Repith/blob/main/public/TODO/todo-resp.png)

