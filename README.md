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
- For the porpose of this assignment, the Data service mocks the generation of 1,000 records of cases information every 10 seconds from both CRM endpoints. The assignment ask for 4 hours of refresh rate, for the porpose of the assignment I have set it to 10 seconds.
- The data records have range of values according to the assignment. Since their ID has defines set of values, the records are overwritten every round instead of being added for not loading on the machine memeory from one side and to get new data every 10 seconds from the other side

**Case Service**
- The Case service is responsible for managing the raw data arrives from the CRM data sources, meaning all the Create, Read, Update and Delete operations.
- It exposes 3 main capabilities:
1. Getting all the cases in the system
2. Getting aggregated data based on the fields error_code, provider_name and product_name
3. Providing Filtering capabilities on top of the raw data for the fields error_code, provider_name and product_name

Open the browser and set the following:
1. http://localhost:8080/api/v1/cases
2. http://localhost:8080/api/v1/cases?aggregated
3. http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

Alternatively, run the following shell commands respectively:
1. curl -X GET http://localhost:8080/api/v1/cases?aggregated
2. curl -X GET http://localhost:8080/api/v1/cases
3. curl -X GET http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

The application is using the in memory DB H2. To access it while the application is running:
- Open the H2 DB Console: http://localhost:8080/h2-console/
- Type "Select * from cases" in order to see the whole set of cases in the system

**A Possible Flow from the Client Side**
1. According to the above, the client pulls aggregated data by calling the Case service (option 2 above) every 30 seconds and displays the information on a dedicated pane to the user by a table.
2. The user is instersted in a specific entry in the aggregation table and clicks it for a drill down.
3. The client pulls raw data by calling the Case service (option 3 above) with the desired parameters for filtering
4. The client gets a response from the Case service and displays the cases raw data in a new pane for the desired set
