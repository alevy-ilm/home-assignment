# home-assignment
This is a home assignment repository

# Supporting Aggregation Hub

This is an aggregation application that pulls data from 2 support cases CRM sources (AKA Banana and Strawberry) and aggregates it.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)


## Installation

A step-by-step guide on how to install this project.

1. Open your terminal or Git Bash (on Windows) and navigate to the directory where you want to clone the repository.
2. Open your terminal or Git Bash (on Windows) and navigate to the directory where you want to clone the repository.
3. Run the following command: # git clone https://github.com/alevy-ilm/home-assignment.git. 
4. Building the project: In the project root run the following command: mvn clean package spring-boot:repackage
5. Running the project : Switch to the new created #target# folder and run: java -jar aggregation-0.0.1-SNAPSHOT.jar

## Functional Assumptions ##
Assumptions on the Data being Aggregated:
1. The fields - CaseID, CustomerID, Provider, Error_code, Ticket_creation_date and Product_name are Immutable
2. The fields - Status and Last_modified_date can be updated
3. The caseID is generated independently by each CRM system and is unique per CRM system - from that reason, the concatentation of the CRM system and the caseID provides us a global ID across the system.
4. The customerID, Provider and Product name are identical across all CRM systems
6. If a case is added with the same ID as n existing case in the repository, it will overwrite the existing case with the new one.

## Technical Assumptions ##
- The application is using H2 DB for the purpose of the assignment only, thus the supported scale is a function of the local running machine.
- Following a priorotozation process, it was decided not to implement the "invoke now" option.


## Usage
Instructions on how to use this project.

This project is built from 2 services: Data service and Case service.

**Data Service**
- The Data service pulls data from 2 support cases CRM endpoints.
- For each case, it prepares the data and sending it to the Case service for processing
- For the porpose of this assignment, the Data service mocks the generation of 1,000 records of cases information every 10 seconds from both CRM endpoints.
- The data records have range of values according to the assignment. Since their ID has defines set of values, the records are overwritten every round instead of being added for not loading on the machine memeory from one side and to get new data every 10 seconds from the other side

**Case Service**


Open the browser and set the following:
- http://localhost:8080/api/v1/cases
- http://localhost:8080/api/v1/cases?aggregated
- http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

Alternatively, run the following shell commands respectively:
- curl -X GET http://localhost:8080/api/v1/cases?aggregated
- curl -X GET http://localhost:8080/api/v1/cases
- curl -X GET http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

The application is using the in memory DB H2. To access it while the application is running:
- Open the H2 DB Console: http://localhost:8080/h2-console/
- Type "Select * from cases" in order to see the whole set of cases in the system

