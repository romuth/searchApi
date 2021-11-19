# searchApi
test task

Simple restful web program.
Have a repository/service layer.
Models and necessary dto's.
Using h2 database as a inmemory db.
Implemented authorization and authentication.

# requirements 

It should be a simple java application based on Spring Boot framework.
 The application should have a REST API that allows users to search by address and get all addresses by coordinates. 
The result should be printed in JSON format.
 Your code should be version controlled and publicly accessible for us to review (github/bit-bucket/gitlab/etc).

# Task description.

You need to implement application that uses third party api Nominatim API and create the following endpoints:
To search by address and save coordinates(latitude,longitude) in H2 DB or any Persistence Db
To get all addresses by coordinates that have been stored in DB. The application must be called by REST API for receiving all addresses from Nominatim API  by saved coordinates.
