# Prueba-BackEnd-Accenture


Se incluye el archivo de exportación de insomnia *Insomnia_2021-02-07.json* donde se encuentran los requests de abajo.



## Historia de usuario 1

### Endpoint POST
`localhost:8080/pedido`

### Ejemplo de body del request
```
{
  "productos": [{"nombre": "changua", "cantidad":4}]
}
```

Los productos disponibles para pedir son :

|Nombre   	|Precio   	|
|---	      |---	      |
|changua   	|20.000     |
|tamal    	|50.000    	|



## Historia de usuario 2

### Endpoint PUT
`localhost:8080/pedido?id={id del pedido}`

### Ejemplo de body del request
```
{
  "productos": [{"nombre": "changua", "cantidad":5}]
}
```
## Historia de usuario 3

### Endpoint DELETE
`localhost:8080/pedido?id={id del pedido}`




