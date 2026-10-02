# Vacation Booking Application

A Spring Boot vacation-booking backend built with Java, Spring Data JPA,
Spring Data REST, MySQL, and Maven. The application models vacations,
excursions, customers, shopping carts, cart items, countries, and
divisions and exposes database-backed REST resources for application
integration.

## Overview

The Vacation Booking Application is a full-stack application project
centered on a Java/Spring Boot backend and relational MySQL database.

The backend uses JPA entities and Spring Data repositories to model the
travel-booking domain. Spring Data REST exposes repository resources
under an `/api` base path, while a custom checkout service handles
purchase processing and order tracking.

The repository currently contains the Spring Boot backend and its
supporting database configuration. The backend is configured for
integration with an Angular client running on `http://localhost:4200`.

## Features

-   Vacation and excursion data management
-   Customer data management
-   Country and division relationships
-   Shopping cart management
-   Cart-item relationships
-   Vacation/excursion relationships
-   Checkout processing
-   Order tracking-number generation
-   Cart status management
-   REST resources through Spring Data REST
-   Cross-origin configuration for an Angular frontend
-   JPA/Hibernate relational mapping
-   Bean validation for customer data
-   MySQL persistence

## Technical Highlights

### Layered Spring Architecture

The application separates responsibilities across:

``` text
controllers/
entities/
dao/
services/
config/
bootstrap/
```

The structure separates HTTP request handling, business logic,
persistence, domain entities, and application configuration.

### REST API

Spring Data REST is configured with:

``` text
spring.data.rest.base-path=/api
```

Repository interfaces expose REST resources for:

-   Vacations
-   Excursions
-   Customers
-   Carts
-   Cart Items
-   Countries
-   Divisions

The repositories use Spring Data JPA and are configured with explicit
REST resource paths.

Example resource paths include:

``` text
/api/vacations
/api/excursions
/api/customers
/api/carts
/api/cart_items
/api/countries
/api/divisions
```

### Database and Entity Relationships

The application uses MySQL and JPA/Hibernate to map the travel-booking
domain.

Key relationships include:

-   A vacation can contain multiple excursions
-   An excursion belongs to a vacation
-   A customer can have multiple carts
-   A cart contains cart items
-   A cart item references a vacation
-   A cart item can contain multiple excursions
-   Customers belong to divisions
-   Divisions are associated with countries

The cart/excursion relationship is represented through the
`excursion_cartitem` join table.

### Checkout

Checkout processing is implemented through:

``` text
CheckoutController
CheckoutService
CheckoutServiceImpl
Purchase
PurchaseResponse
```

The checkout controller exposes a purchase endpoint and delegates
processing to the checkout service.

The checkout service:

1.  Validates that a cart is present.
2.  Validates that cart items are available.
3.  Generates an order tracking number.
4.  Updates the cart status to `ordered`.
5.  Saves the updated cart.
6.  Returns a purchase response containing customer and order
    information.

### Validation

Customer fields use Jakarta Bean Validation annotations such as:

-   `@NotBlank`
-   `@Size`

This provides server-side validation for required customer information.

### CORS

Repository resources are configured to allow requests from:

``` text
http://localhost:4200
```

This supports communication between the Spring Boot backend and a local
Angular development client.

## Technologies

| Technology | Purpose | 
| -------- | -------- | 
| Java 17 | Backend development | 
| Spring Boot 3.3.6 | Application framework | 
| Spring Data JPA | Persistence and ORM | 
| Spring Data REST | REST resource exposure | 
| Spring Validation | Input validation | 
| Hibernate | JPA implementation | 
| MySQL | Relational database | 
| Maven | Build and dependency management | 
| Lombok | Boilerplate reduction | 
| Git / GitHub | Version control and source hosting |

## Project Structure

``` text
src/
├── main/
│   ├── java/com/example/lane/
│   │   ├── bootstrap/
│   │   ├── config/
│   │   ├── controllers/
│   │   ├── dao/
│   │   ├── entities/
│   │   └── services/
│   └── resources/
│       └── application.properties
└── test/
```

### Key Components

**Entities**

``` text
Customer
Vacation
Excursion
Cart
CartItem
Country
Division
StatusType
```

**Repositories**

``` text
CustomerRepository
VacationRepository
ExcursionRepository
CartRepository
CartItemRepository
CountryRepository
DivisionRepository
```

**Services**

``` text
CheckoutService
CheckoutServiceImpl
Purchase
PurchaseResponse
```

**Controller**

``` text
CheckoutController
```

## Database Configuration

The application is configured for a local MySQL database named:

``` text
full-stack-ecommerce
```

The configured database connection uses MySQL Connector/J and
Hibernate's MySQL dialect.

For security, database credentials should be supplied through a local
configuration or environment-specific configuration rather than
committed to a public repository.

## Getting Started

### Requirements

-   Java 17
-   Maven or the included Maven wrapper
-   MySQL
-   IntelliJ IDEA or another Java IDE

### Database

Create the required MySQL database and configure the connection values
in:

``` text
src/main/resources/application.properties
```

Do not commit personal database credentials to a public repository.

### Run

From the project root:

``` bash
./mvnw spring-boot:run
```

On Windows:

``` bash
mvnw.cmd spring-boot:run
```

The Spring Boot application runs on the default port:

``` text
8080
```

REST resources are available under:

``` text
http://localhost:8080/api
```

## Engineering Focus

This project demonstrates practical experience with:

-   Java backend development
-   Spring Boot
-   REST API design
-   Spring Data JPA
-   Relational database modeling
-   Entity relationships
-   Repository-based persistence
-   Service-layer business logic
-   Checkout processing
-   Input validation
-   CORS configuration
-   MySQL integration
-   Maven build management

## Author

**Lane Brents**
