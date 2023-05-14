# home-assignment
This is a home assignment repository

# Project Title

A brief description of what this project does.

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
3. The caseID is generated independently by each CRM system and is unique per CRM system
4. he customerID, Provider and Product name are identical across all CRM systems
5. If a case is added with the same ID as n existing case in the repository, it will overwrite the existing case with the new one.

## Technical Assumptions ##


## Usage
Instructions on how to use this project.

Open the browser and set the following:
http://localhost:8080/api/v1/cases
http://localhost:8080/api/v1/cases?aggregated
http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

Run the commands:
curl -X GET http://localhost:8080/api/v1/cases?aggregated
curl -X GET http://localhost:8080/api/v1/cases
curl -X GET http://localhost:8080/api/v1/cases?error_code=404&provider=provider_1&product_name=Green

Open the H2 DB Console: http://localhost:8080/h2-console/

