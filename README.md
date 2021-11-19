# searchApi
test task

Simple restful web program.
Have a repository/service layer.
Models and necessary dto's.
Using h2 database as a inmemory db.
Implemented authorization and authentication.

# requirements 

It should be a simple java application based on Spring Boot framework.<br/>
 The application should have a REST API that allows users to search by address and get all addresses by coordinates.<br/>
The result should be printed in JSON format.<br/>
 Your code should be version controlled and publicly accessible for us to review (github/bit-bucket/gitlab/etc).<br/>

# Task description.

You need to implement application that uses third party api [Nominatim API](https://nominatim.org/release-docs/develop/api/Overview/) and create the following endpoints:<br/>
To search by address and save coordinates(latitude,longitude) in H2 DB or any Persistence Db<br/>
To get all addresses by coordinates that have been stored in DB.<br/>
The application must be called by REST API for receiving all addresses from Nominatim API  by saved coordinates.
