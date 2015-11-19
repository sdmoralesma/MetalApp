# Application - Musical Contest

* *Author* : [Sergio Morales](http://www.linkedin.com/profile/view?id=199182063)
* *Level* : Intermediate
* *Technologies* : Java EE 7 (JPA 2.1, CDI 1.1, Bean Validation 1.1, EJB Lite 3.2, JSF 2.2 (+ Primefaces 5.x), JAX-RS 2.0)
* *Application Servers* : Wildfly 9.x.x
* *DataBase* : MySQL 5.x
* *Summary* : An application for recognize the best headbanging in the history of the music, using Java EE 7

## Installation and Running

1. install docker engine and docker-compose
2. download source code, go to headbanging-app folder and build with: ``` mvn package ```
3. run containers : ``` docker-compose up ```

The Best Headbanging 
======================================

<table border="2" align="center">
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/11271216/a1c0c6b0-8e92-11e5-9b63-bbec03c7d192.png" width="800px" height="400px" />
        </td>
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936919/577911f4-d87a-11e3-9339-19236a069dce.png" width="800px" height="400px" />
        </td>
    </tr>
    <tr>
        <td>
            <img src="https://cloud.githubusercontent.com/assets/1953226/2936920/5781db18-d87a-11e3-96d5-9fe5c83cfd75.png" width="800px" height="400px" />
        </td>
    </tr>    
</table>

Actors:

1. Admin
2. Jury
2. Participant
3. General public (no user/password)

Use cases are:

* Register a Participant
* Register a Jury
* A jury can vote for the presentation of a particular Participant
* Participant can upload his presentation and add personal data
* Query all participants score


## Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">S</span>ergio <span class="uc">M</span>orales</span>
</div>
