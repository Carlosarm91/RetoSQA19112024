#language:es
#Autor: Carlos S.

Característica: Login

  @Escenario_1
  Escenario: Agregar un producto al carro de compras de manera exitosa
    Dado que estoy en la pagina de inicio de aliexpress
    Y busco un producto
    Cuando lo agrego al carro de compras
    Y selecciono las cantidades del producto
    Entonces valido el producto agregado
    Y el precio del producto