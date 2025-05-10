# Sistema de Venta

Proyecto Academico desarrollado en el primer Bimestre de la carrera que califica como evaluación Final de la Asignatura de Fundamentos de Programación con Java.
Modificando arreglos de manera eficiente, incluyendo la capacidad de agregar, eliminar y actualizar elementos con integridad y coherencia de datos, así como seleccionar la estructura de datos adecuada para optimizar el rendimiento según los requisitos del problema.

## Descripción del Proyecto :scroll:

Caso planteado: 
“El Teatro busca innovar su sistema de venta de entradas para mejorar la experiencia de sus visitantes. Para ello, deberás crear un sistema en Java que simule la venta de entradas, haciendo los descuentos a niños 10 %, mujeres 20 %, estudiantes 15 % y personas de tercera edad 25 %. Deberás considerar que el sistema valide la edad de cada persona y la ubicación del asiento (vip, palco, platea baja, platea alta y galería) asignando asientos e imprimir boleta"

Gestionaremos un sistema de venta de entradas, se ha solicitado la implementación de un programa en Java que permita realizar diferentes operaciones para esto se nos solicita: 
- Gestión de descuentos
- Validación de entradas
- Selección de asientos
- Asignación de asientos
- Impresión de boleta
- Manejo de información de entradas.

Se solicita optimizar el rendimiento al definir la estructura de datos más adecuada (arreglos o listas), que se relacione con el manejo de datos primitivos, asegurando que el sistema responda a las operaciones de venta y descuento.

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Diseño del sistema:

- Definir la estructura general de la aplicación, incluyendo las clases clave, cada una con sus propiedades y responsabilidades específicas.
- Crear métodos fundamentales para determinar el descuento aplicable basado en el tipo de cliente; para permitir a los usuarios elegir su asiento preferido; y para compilar toda la información de la compra para imprimir la boleta.
- Determinar cómo las clases interactuarán entre sí para procesar compras, asignar asientos y aplicar descuentos de manera eficiente.


👌 2. Implementación de la aplicación:

- Utilizar variables para almacenar información como tipo de cliente, sección seleccionada, y cantidad de entradas.
- Aplicar estructuras de control (if-else, switch, for, while) para gestionar la lógica de selección de asientos disponibles y aplicar descuentos.
- Implementar arreglos o listas para manejar las entradas y asientos disponibles o vendidos.
- Incorporar entrada/salida de datos para interacciones con el usuario.
- Asegurar la robustez del sistema frente a entradas de usuario inválidas o errores durante el proceso de compra.


👌 3. Gestión de datos:

Tendrás que implementar funciones o métodos que permitan crear, leer, actualizar y eliminar información para manejar las ventas de entrada y la asignación de asientos, asegurando que la integridad de los datos se mantenga en todo momento. 

👌 4. Optimización del rendimiento: Seleccionar estructuras de datos óptimas (por ejemplo, listas para manejar dinámicamente las ventas de entradas) para mejorar la eficiencia.

👌 5. Pruebas, optimización, depuración: 
- Verifica el correcto funcionamiento de cada método y clase de manera individual y en conjunto.
- Identificar y corregir errores para asegurar que el sistema funcione correctamente bajo diferentes escenarios y entradas de usuario.

👌 6. Presentación: 
Para este paso, tendrás que realizar una presentación en video de tu proyecto con una duración máxima de 5 minutos. Se solicita compartir el proceso completo de construcción de tu aplicación, incluyendo el diseño, las estrategias de implementación que utilizaste, las dificultades que enfrentaste y cómo las superaste, así como las características únicas de tu proyecto.



## Visuales :mage_woman:



Menú interactivo inicial con manjeo de errores según inputs del usuario:
![Captura de pantalla 2025-05-10 120958](https://github.com/user-attachments/assets/75c829cb-376a-469e-a109-56b88a32290a)

En esta ocasión se incorporó la funcionalidad de que al terminar de ejecutar un "case" o una opción del menú, el programa hace una pausa indicandole al usuario que presione ENTER para volver al menú y este se despliega nuevamente para elegir la siguiente acción. 

Opción 1: muestra el menu de promociones.
Se indica al usuario que los descuentos no son acumulativos y que el sistema aplica el mayor descuento según genero y edad. 
![Captura de pantalla 2025-05-10 121155](https://github.com/user-attachments/assets/89804727-6532-44d2-ad9e-8320b8285fa0)


Opción 2: muestra el mapa inicial, con el estado actual cada vez que se inicia una reserva/compra.
En esta versión se agregan las refrencias y un titulo para enriquecer la experiencia del usuario en la parte visual.
Se decidió la estructura de datos de Array ya que es una cantidad definida de elementos con las que se puede trabajar, optimizando así este segmento del código. 

![Captura de pantalla 2025-05-10 122049](https://github.com/user-attachments/assets/4a0d7232-e483-4bb8-b903-ebf0bab90b93)


Opciones 4, 5, 6, 7, 8, 9 no se ejecutan si no existe una reserva o venta previamente: 

![Captura de pantalla 2025-05-10 123446](https://github.com/user-attachments/assets/d012b2f5-2b01-4b74-b263-ae0cfef64bc0)

![Captura de pantalla 2025-05-10 123456](https://github.com/user-attachments/assets/d0e56a06-f97f-4771-95fc-73d937c9e424)

![Captura de pantalla 2025-05-10 123501](https://github.com/user-attachments/assets/fa1b23d1-c492-44ac-8491-97c40dea5a54)

![Captura de pantalla 2025-05-10 123509](https://github.com/user-attachments/assets/3d8f8e85-ae78-4e81-9f22-e6900091c6aa)

![Captura de pantalla 2025-05-10 123515](https://github.com/user-attachments/assets/1c485e12-5b3b-43ea-8f29-8af1854825ac)

![Captura de pantalla 2025-05-10 123541](https://github.com/user-attachments/assets/200740c4-73db-4d03-b43c-57c368d39443)


La opcion 10 de Estadísticas Generales en estado inicial muestra todas las variables e incluye un resumen del mapa en el momento de la consulta. En este caso es antes de hacer alguna operación: 

![Captura de pantalla 2025-05-10 123734](https://github.com/user-attachments/assets/6cb3d7b9-ddd8-492b-a0ad-b268bb15d372)



En las opciones 11, 12, 13, 14, 15 donde se despliegan las listas, al inicio como no tiene información le indica al usuario que no hay registros todavía:


![Captura de pantalla 2025-05-10 124528](https://github.com/user-attachments/assets/3479d35b-3288-4c84-82b5-9a859eca8df3)

![Captura de pantalla 2025-05-10 124538](https://github.com/user-attachments/assets/377be58f-e2b3-43e1-a83b-ef9ae7b6d074)

![Captura de pantalla 2025-05-10 124547](https://github.com/user-attachments/assets/4ce2b0b9-e5f6-4844-aedc-31b2085b2e5f)

![Captura de pantalla 2025-05-10 124615](https://github.com/user-attachments/assets/d17ec2cc-5c8b-462c-a1ad-a00ca0c8327f)

![Captura de pantalla 2025-05-10 124626](https://github.com/user-attachments/assets/45e9d85b-889c-4c25-97b0-91b8e60b1a71)




En el proceso principal que es la reserva de las entradas, se despliega el mapa de manera inicial para que el usuario pueda ver el estado actual de los asientos y se procede a solicitar los datos, por cada dato, se validan inputs del usuario manejando errores: 

![Captura de pantalla 2025-05-10 125117](https://github.com/user-attachments/assets/ecbd40b6-2104-4994-bdcd-de435fa4370c)

Se valida si la ubicación es una opción distinta a las mencionadas: 

![Captura de pantalla 2025-05-10 125209](https://github.com/user-attachments/assets/4aaafc5f-3229-47e1-ba07-baa53c24ce56)


Para la cantidad de entradas:
se valida si desea más entradas de las disponibles en total en el teatro
se valida si desea más que las disponibles en cada sector
se valida si desea cero
se valida si ingresa string
se valida si al ingresar el sector ya no quedan entradas disponibles en esa ubicacion seleccionada.

![Captura de pantalla 2025-05-10 133822](https://github.com/user-attachments/assets/c27395cb-0d4d-4035-ae23-c1f1283f919e)

![Captura de pantalla 2025-05-10 140157](https://github.com/user-attachments/assets/5fefc5b8-ec28-4833-86fb-011ac7a9771d)

![Captura de pantalla 2025-05-10 140032](https://github.com/user-attachments/assets/c4f28edd-659e-481d-982b-63797a40850d)




Si selecciona VIP que es la fila A , e ingresa el asiento B1, el programa indica que "no pertenece a la ubicación seleccionada"

![Captura de pantalla 2025-05-10 140555](https://github.com/user-attachments/assets/7209d4ee-eafb-4cfe-a428-2e7a895b6ae4)




Si el usuario ingresa un asiento que ya está reservado u ocupado infomra que "el asiento no está disponible":
![Captura de pantalla 2025-05-05 151639](https://github.com/user-attachments/assets/0be7453f-b005-41b5-a394-c3c7a0a25278)

Con la selección hecha, retroalimenta al usuario visualmente de su elección y pide siguiente dato:

![Captura de pantalla 2025-05-05 151735](https://github.com/user-attachments/assets/61c2dfba-cfae-4b82-b70b-5109bd68afa8)

Solicita últimos datos para aplicación de descuentos, retroalimentando con el valor de la entrada y el descuento a aplicar: 

![Captura de pantalla 2025-05-05 151923](https://github.com/user-attachments/assets/318d845f-5845-47a9-af4e-ca6238483f04)

Al finalizar el proceso de reserva:
- genera un resumen de la reserva
- si el cliente no ha sido ya registrado, lo registra retroalimentando con un mensaje
- informa el numero de la reserva
- indica instrucciones para proceder, informando que lo devolverán al menú principal
- 
![Captura de pantalla 2025-05-05 152023](https://github.com/user-attachments/assets/c9f18e98-e686-4c4e-95db-eabef7ec6952)

En la opcion 4 de modificación de reserva, valida la cantidad de asientos que desea devolver para modificar su reserva y retroalimenta mostrando el mapa con la liberación de los asientos y manteniendo la reserva pertinente.

![Captura de pantalla 2025-05-05 152833](https://github.com/user-attachments/assets/41067f16-87ea-47ad-9e79-c26c8f32a71b)

Si se desea eliminar la reserva, la opción pide una segunda verificación y si la persona opta por NO eliminar la reserva, los asientos continúan reservados: 

![Captura de pantalla 2025-05-05 153351](https://github.com/user-attachments/assets/b6eacb84-01ac-4786-9a5a-bc177bf1523f)

Si la persona sí desea eliminar la reserva: 

![Captura de pantalla 2025-05-05 153455](https://github.com/user-attachments/assets/d0e1d0fc-4b4c-4d40-ae5a-62a26fb8998e)

Si el usuario ingresa una respuesta no valida, se maneja esto: 

![Captura de pantalla 2025-05-05 153545](https://github.com/user-attachments/assets/cea54a6f-aaa0-4472-bfab-f4da07d5a4f5)

Si la persona NO confirma la compra, se liberan los asientos de su reserva y se verifican en el mapa: 
![Captura de pantalla 2025-05-05 153632](https://github.com/user-attachments/assets/41cf7af0-9cbd-4c89-90e2-9a1bcdc9f13c)

El ejercicio fue realizar una reserva, no confimarla como compra, de todas maneras, la lista de reservas la registra como realizada, ya que existió, pero no se generó la compra: 
![Captura de pantalla 2025-05-05 153757](https://github.com/user-attachments/assets/e66c7bcc-d827-4e61-99a7-a1ca6043558b)

Así mismo se creó el registro del cliente: 
![Captura de pantalla 2025-05-05 153854](https://github.com/user-attachments/assets/1ba22d5e-f005-4a2e-9247-3a29f55a9b54)


Al confirmar la compra, se muestra el mapa con los asientos ocupados "OO":
![Captura de pantalla 2025-05-05 154253](https://github.com/user-attachments/assets/efd90fe1-07aa-4a26-a232-0334800ff776)

ANULACION DE COMPRA:
En el siguiente caso, se realiza la compra de asiento b1 y b2 y se anula la compra
- mostrando la liberación de los asientos.
- se genera la lista de ventas anuladas
- la venta efectiva se elimina de la lista ventas
- las estadisticas generales contabilizan ventas totales como la sumatoria de las efectivas y anuladas, con sus clasificaciones
  
![Captura de pantalla 2025-05-05 154429](https://github.com/user-attachments/assets/b9f89bb5-9bc0-46f3-a0db-d4247da8f4ba)

![Captura de pantalla 2025-05-05 154643](https://github.com/user-attachments/assets/c9734cd2-6d53-4cd0-845d-d6dc762d211a)

En este ejercicio se realizan tres reservas, tres compras y una de ella se anula generando las listas: 
![Captura de pantalla 2025-05-05 160104](https://github.com/user-attachments/assets/4caefb12-f54d-4474-8437-7d3b6f0682bf)

![Captura de pantalla 2025-05-05 160054](https://github.com/user-attachments/assets/ba0634e3-e3ac-417d-9e07-4243426ef19a)

![Captura de pantalla 2025-05-05 160112](https://github.com/user-attachments/assets/c1a43c7a-9593-437f-be61-86baae96bccd)

![Captura de pantalla 2025-05-05 160122](https://github.com/user-attachments/assets/26cd4e1e-b613-4966-918c-f4fda974c94e)


Luego de varios movimientos se puede pedir una estadistica general en el estado actual, que incluye la sumatoria o resta de los ingresos según los totales a pagar. 

![Captura de pantalla 2025-05-05 161435](https://github.com/user-attachments/assets/821f1fb0-7de4-463f-be38-aead619b8412)


Se valida descuentos a aplicar según edad se determina el tipo de Descuento, si es estudiante, tercera edad, sin descuento o
promoción 4 entradas: 
Si bien por la edad identifica aplicar descuento estudiante, en el resumen de la reserva indica el tipo de descuento con mayor beneficio para el cliente, en este caso, el descuento grupal es el válido: 
![Captura de pantalla 2025-05-05 154109](https://github.com/user-attachments/assets/42d22fe6-1b1d-4dea-a0e4-9112feee0565)


Con la opción 13 se entrega un mensaje de salida y se cierra el programa:
![Captura de pantalla 2025-05-05 150811](https://github.com/user-attachments/assets/8da14056-011a-45b8-b11c-f731172497ae)


OPTIMIZACIONES Y PRUEBAS

- Como parte de las optimizaciones se decidió utilizar la estructura de datos Array para los Asientos y de esta manera poder desplegar el mapa del teatro como matriz y se tomó la decisión del resto de utilizar listas.
- Así mismo se presenta un código con menos comentarios que los anteriores, ya que según lo indicado el exceso de comentarios también va cargando tiempos de ejecución del programa.
  
Durante la realización del código se hicieron múltiples pruebas de su ejecución encontrando detalles como estos y mejorandolos: 
Por ejemplo en este caso, cuando se entregaba la retroalimentación al usuario el programa se quedaba estancado, se identificaron errores y corrigieron: 
![Captura de pantalla 2025-05-05 152737](https://github.com/user-attachments/assets/545d8b69-c3b0-4ff7-acdf-b54745368a93)

O en este otro caso donde aparecía el valor de "null" y no se entendía por qué .... finalmente comprendí que era por que al inicializar la variable String por defecto viene cargada de null y su primera lectura es esa, para que esto no suceda debe cambiarse a " String codigos = ""; " dejando el String vacío:

![Captura de pantalla 2025-05-05 142642](https://github.com/user-attachments/assets/693ba998-afb6-458d-add8-e58c5f86e4f8)

![Captura de pantalla 2025-05-05 142650](https://github.com/user-attachments/assets/61207285-8355-49af-a009-7188a011391e)








## Observación:
En esta versión se plantea el programa con la reserva y la compra de manera separada, para efectuar la compra debe salir si o si al menú principal y elegir dicha opción. Las instrucciones se le indican al usuario:





## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
