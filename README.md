# Application - Musical Contest

* *Author* : [Sergio Morales](http://www.linkedin.com/profile/view?id=199182063)
* *Level* : Intermediate
* *Technologies* : Java EE 7 (JPA 2.1, CDI 1.1, Bean Validation 1.1, EJB Lite 3.2, JSF 2.2 (+ Primefaces 3.5), JAX-RS 2.0, JAX-WS 2.2)
* *Application Servers* : Wildfly 9.x.x
* *DataBase* : MySQL 5.x
* *Summary* : An application for recognize the best headbanging in the history of the music, using Java EE 7


The Best Headbanging 
======================================

<table border="2" align="center">
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936924/579694ea-d87a-11e3-958f-0697302a5710.png" width="400px" height="200px" />
        </td>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936919/577911f4-d87a-11e3-9339-19236a069dce.png"         width="400px" height="200px" />
        </td>
    </tr>
    
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936920/5781db18-d87a-11e3-96d5-9fe5c83cfd75.png" width="400px" height="200px" />
        </td>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936923/57953f46-d87a-11e3-8a84-d91d816147c5.png" width="400px" height="200px" />
        </td>
    </tr>
    
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936922/578fa37e-d87a-11e3-9dd1-9a77fa59c2e7.png" width="400px" height="200px" />
        </td>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936921/578ae5f0-d87a-11e3-96dd-03e5dbabd463.png" width="400px" height="200px" />
        </td>
    </tr>
</table>

**Under development ... this could explode in anytime**

Esta aplicaciòn es un reality donde una serie de concursantes con amplios conocimientos musicales seleccionan las canciones más perfectas del metal y hacen una presentación de la misma mediante su representación histriónica, algo similar a un baile, conocido como headbanging.

Una serie de jurados votan al final cada presentación, colocando una puntuación del headbanging mostrado por el concursante. El headbanging se evalúa en dos partes el movimiento de las manos y el movimiento de la cabeza.

El puntaje de un concursante en una participación por jurado será el número dado por el headbanging, multiplicado por el número de coherencia del genero con el headbanging desarrollado más los atributos de musicalidad y perfección de la composición de cada canción.

Así por ejemplo, la canción “Ace of spades” pertenece al genero “speed metal”. El “speed metal” tiene como headbang de mano 5 y 10 de cabeza. A su vez “Ace of spades” tiene una musicalidad de 8 y una perfección de la composición de 7. La concursante Laura hace una presentación usando esta canción. El jurado uno le da a Laura un 4 en mano y un 8 en cabeza. El jurado 2 le da un 3 en mano y un 9 en cabeza.

La puntuación de Laura en la presentación es igual al promedio del Jurado 1 y del Jurado 2, así

Jurado 1 = (5*4) + (10*8)+ 8 + 7 = 20 + 80 + 8 + 7 = 115
Jurado 2 = (5*3) + (10*9) + 8 + 7 = 15 + 90 + 8 + 7 = 120

Calculando el promedio del Jurado 1 y el Jurado 2, la presentación de Laura tiene un puntaje
de 117.5

La puntuación total de Laura es el promedio de todas sus presentaciones. El número de
jurados es variable para cada presentación.

Existen los siguientes actores:

1. Administrador
2. Jurado
3. Publico en general (No requiere usuario y contraseña)

El listado general de funcionalidades es:

## 1. Registrar un concursante
Es una pantalla web, donde se puede registrar el identificador del concursante, su
nombre y otra información personal que a su criterio sea valiosa. Es una funcionalidad
que esta protegida por usuario y contraseña, y solo puede ser efectuada por un
usuario con rol administrador.

## 2. Registrar un jurado
Es una pantalla web, donde se puede registrar el identificador del jurado, su nombre,
su nombre de usuario y su contraseña. Es una funcionalidad que esta protegida por
usuario y contraseña, y solo puede ser efectuada por un usuario con rol administrador.

## 3. Que un jurado pueda votar después de la actuación de un concursante
Es una pantalla web, donde después de previa autenticación con usuario y password,
el jurado puede seleccionar el nombre de un concursante, el numero de la
participación del concursante, el nombre de una canción y el puntaje de la actuación
del concursante tanto para sus movimientos de mano como para sus movimientos de
cabeza.
Lo registrado por este jurado debe ser almacenado en la base de datos, y afectar el
puntaje de la presentación del concursante.

## 4. Que se pueda consolidar el puntaje de la presentación del concursante
Pantalla donde se sumen las votaciones de los jurados, se de una puntuación por
presentación y adicionalmente se afecte el puntaje total del concursante. Es una
funcionalidad que esta protegida por usuario y contraseña, y solo puede ser efectuada
por un usuario con rol administrador.

## 5. Que un jurado pueda votar por una canción
Es una pantalla web, donde después de previa autenticación con usuario y password,
el jurado puede seleccionar el nombre de una canción y colocar su puntaje de
musicalidad y perfección de la composición. Esta votación afecta directamente el
promedio de la canción.

## 6. Registrar canción
Pantalla donde se puede registrar una canción, su titulo, genero, artista y demás
información. Es una funcionalidad que esta protegida por usuario y contraseña, y solo
puede ser efectuada por un usuario con rol administrador.

## 7. Registrar genero
Pantalla donde se puede registrar un género, su nombre y sus puntajes de headbang
de mano y de cabeza. Es una funcionalidad que esta protegida por usuario y
contraseña, y solo puede ser efectuada por un usuario con rol administrador.

## 8. Consulta de votación general de concursantes
Pantalla donde sale el listado de concursantes y su puntuación general actual.
Exponerla por web Service SOAP. No exige ningún tipo de autenticación.

## 9. Consulta de votación general de canciones

Pantalla donde sale el listado de canciones, su género, su puntaje de musicalidad y
perfección de la composición, al igual que sus puntajes de headbang de mano y de
cabeza según el género. No exige ningún tipo de autenticación.
Exponerla por web Service SOAP.

## 10. Consulta de votación detallada de un concursante
Pantalla donde sale por cada concursante el historial de votación que ha tenido.
Exponerla por web Service SOAP. No exige ningún tipo de autenticación.

Adicionalmente, se sugiere el uso de los siguientes services y una fachada.
### 1. Service de administración
a. Contiene las funcionalidades de 1 y 2, adicionalmente aquellas que tengan
que ver con el ingreso seguro
### 2. Service de jurado
a. Contiene las funcionalidades de votación, es decir, 3 y 5
### 3. Service de puntuación
a. Contiene la funcionalidad 4, 6 y 7
### 4. Service de consultas generales
a. 8, 9 y 10

## Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">S</span>ergio <span class="uc">M</span>orales</span>
</div>
