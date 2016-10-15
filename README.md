# VideoClub

Se desea diseñar una base de datos relacional que almacene la información sobre los préstamos de las películas de un vídeo club.

En la actualidad la gestión de esta información se lleva cabo del siguiente modo:
Cuando se hace un préstamo se rellena una ficha en la que se anota el socio que se lleva la película, la
fecha y el número de la cinta que se lleva, que es único (de cada película hay varias copias en cintas
distintas).

Esta ficha se deposita en el archivador de películas prestadas. Cuando el socio devuelve la cinta, la ficha se pasa al archivador de películas devueltas.

El vídeo club tiene, además, un archivador con fichas de películas ordenadas por título; cada ficha tiene además el género de la película (comedia, terror, ...), su director y los nombres de los actores que intervienen.

También se tiene un archivador con las fichas de los socios, ordenadas por el código que el vídeo club les da cuando les hace el carnét; cada ficha tiene el nombre del socio, su dirección y teléfono, los nombres de sus directores favoritos, los nombres de sus actores favoritos y los géneros cinematográficos de su preferencia. Cuando un socio quiere tomar prestada una película de la que no hay copias disponibles, se le puede anotar en la lista de espera de esa película.

Cada vez que se devuelve una película, se comprueba si hay alguien en su lista de espera, y si es así se llama por teléfono al primer socio de la lista para decirle que ya puede pasar a recogerla, borrándolo después de la lista.


#### Diagrama de Procesos
![diagramaprocesos](https://cloud.githubusercontent.com/assets/12077561/18757584/b6d2d2b6-80b1-11e6-88c6-4f986c3d178a.png)

#### Diagrama de Entidad - Relación
![diagramaentidad](https://cloud.githubusercontent.com/assets/12077561/18758926/4af761c8-80b7-11e6-9794-3b6e486fa25a.png)

#### Diagrama de Clases
![diagramaclases](https://cloud.githubusercontent.com/assets/12077561/18759007/b9390ad8-80b7-11e6-9e26-07b1e71f68a1.png)

#### Base de Datos
Para conectarse a su base de datos en la clase "Conexion" debera cambiar el nombre de la base de datos, el usuario y la contraseña de dicha conexión.

#### Pruebas Unitarias
El modelo cuenta con pruebas unitarias, para que las pruebas unitarias tengan exito, se deberan cambiar los datos dependiendo de los datos que se encuentren en su base de datos.
