❓ Why should we NOT return Entity from service?

We should not return entity objects directly because they expose
internal database structure and may leak sensitive data such as 
passwords. It also creates tight coupling between the database and 
API, making future changes difficult.

Instead, we use DTOs (Data Transfer Objects) to return only the required
and safe data to the client, ensuring better security, flexibility, and 
clean architecture.


👉http://localhost:8081/api/v1/users/profile
    Bearer Token
👉http://localhost:8081/api/v1/auth/login { "email":"aash@gmail.com", "password":"aldiso"}
👉http://localhost:8081/api/v1/auth/register {"name":"ahish","email":"aash@gmail.com","password":"aldiso"}