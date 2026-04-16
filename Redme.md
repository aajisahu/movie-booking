❓ Why should we NOT return Entity from service?

We should not return entity objects directly because they expose
internal database structure and may leak sensitive data such as 
passwords. It also creates tight coupling between the database and 
API, making future changes difficult.

Instead, we use DTOs (Data Transfer Objects) to return only the required
and safe data to the client, ensuring better security, flexibility, and 
clean architecture.