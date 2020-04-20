# customer-api

Prerequisites:
- Java 8
- Gradle

Quick Links:

- [Customer.java](src/main/java/com/kavlad/customerapi/Customer.java)
- [Address.java](src/main/java/com/kavlad/customerapi/Address.java)
- [CustomerController.java](src/main/java/com/kavlad/customerapi/CustomerController.java)
- [Problem Statement (PDF file)](java-test.pdf)

In this project, I am creating a simple REST API to provide CRUD functionality for customer records.

[Customer](src/main/java/com/kavlad/customerapi/Customer.java) Object:
```json
{
    "firstName": "String",
    "lastName": "String",
    "phoneNumber": "String",
    "email": "String",
    "address": {
        "type": int,
        "city": "String",
        "country": "String",
        "addressLine": "String"
    }
}
```

[Address](src/main/java/com/kavlad/customerapi/Address.java) Object:

```json
{
    "type": int,
    "city": "String",
    "country": "String",
    "addressLine": "String"
}
```

The customer records should ideally be stored in an external database. However, this is not the scope of this project. Therefore, ``` HashMap<Integer, Customer>``` was the data structure of choice due to its flexibility with records retrieval.

The [Customer Controller](src/main/java/com/kavlad/customerapi/CustomerController.java) is responsible of handeling all the REST mappings.

### Note on creating customers
When creating a customer, a customer ID is being generated at run-time upon calling the ```createCustomers()``` method. This obviously is a huge design question, and generating the ID might depend on my other technical requirements; however, for simplicity, I have decided to generate random **positive** integers for the ID. The chance of collision is extremely low, so I decided to ignore handling that.