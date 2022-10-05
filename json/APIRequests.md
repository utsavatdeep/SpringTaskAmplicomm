## GET : http://localhost:8080/getAddress
## GET : http://localhost:8080/isAddressIdAvailable
#Example1: 
{
"addressId": "a01"
}
#Example2:
{
"addressId": "a02"
}

## POST: http://localhost:8080/updateAddress
{
"addressId": "a01",
"address" : "Random Sample Address, Dehradun"
}

## POST: http://localhost:8080/addNewUserAddress
{
"username": "jeremy",
"addressId": "a02",
"address" : "Random HULALA Address, Bangalore"
}

# POST: http://localhost:8080/deleteUserAddress
{
"username": "jeremy",
"addressId": "a02"
}

