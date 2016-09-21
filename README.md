# Address-book

## Introduction

A simple java application to query the contents of an address book. Using maven for build and dependency management.
Tried to keep the dependencies to a minimum. The output is pushed through to the console.
Typically wouldn't use System.out.println in production systems but for the purpose of this demo it is ok.

## Useage

Run the following:-

mvn clean package shade:shade

This will create an executable jar file.

Then run the following:-

java -jar target/address-book-1.0.0-SNAPSHOT.jar

This will output the specified answers straight to the console.


