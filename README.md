# Spring Boot Hibernate Issue Showcase

Simple Spring Boot Project using Hibernate `5.6.9.Final` to showcase an issue with JPA Attribute Converters for Basic Types
when using converted fields in a `WHERE` Clause inside a Criteria API Query ([HHH-14756](https://hibernate.atlassian.net/browse/HHH-14756)).

## Prerequisites

The project requires JDK 17. 

## Project Layout 

The project contains a single entity, `Car`, which has a generated numeric ID and a serial number persisted as
an uppercase Hex String. `BigIntegerHexAttributeConverter` performs the conversion between `BigInteger`s and uppercase 
Hex Strings.

The `CarRepositoryTest` contains two test cases which query the in-memory H2 Database using the serial of a car. Only
one of the test cases succeeds though. One fails because the serial is not converted into a `VARCHAR` before executing
the query.
