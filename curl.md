CURL COMMANDS:

GET
``` bash
curl localhost:8080/coffees | json_pp
```
POST
``` bash
curl -H 'Content-Type: application/json' -d '{"id": "`perigfvd-fpeorhfv-033-sfkgvjpdifvd", "name": "Colombiano mijo"}' -X POST localhost:8080/coffees | json_pp
```
PUT
``` bash
curl -H 'Content-Type: application/json' -d '{"id": "666", "name": "Colombiano mijo"}' -X PUT localhost:8080/coffees | json_pp
```
DELETE
``` bash
curl -X DELETE localhost:8080/coffees/<id>
```