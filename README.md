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
- se valida si desea más entradas de las disponibles en total en el teatro
- se valida si desea más que las disponibles en cada sector
- se valida si desea cero
- se valida si ingresa string
- se valida si al ingresar el sector ya no quedan entradas disponibles en esa ubicacion seleccionada.

![Captura de pantalla 2025-05-10 140520](https://github.com/user-attachments/assets/d640d86f-1848-499a-9196-37216a095ecf)

![Captura de pantalla 2025-05-10 140157](https://github.com/user-attachments/assets/5fefc5b8-ec28-4833-86fb-011ac7a9771d)

![Captura de pantalla 2025-05-10 140032](https://github.com/user-attachments/assets/c4f28edd-659e-481d-982b-63797a40850d)


Si selecciona VIP que es la fila A , e ingresa el asiento B1, el programa indica que "no pertenece a la ubicación seleccionada"
![Captura de pantalla 2025-05-10 140555](https://github.com/user-attachments/assets/833c9e78-4253-45c1-acfa-0678eeb2d621)

Si el usuario ingresa un asiento que ya está reservado u ocupado infomra que "el asiento no está disponible":
![Captura de pantalla 2025-05-05 151639](https://github.com/user-attachments/assets/0be7453f-b005-41b5-a394-c3c7a0a25278)

Luego de solicitar la cantidad de entradas, por cada entrada
- solicita y valida asiento
- solicita rut y valida que sea número
- solicita nombre
- solicita edad (con lo que calcula el descuento a aplicar)
- solicita y valida el genero (con lo cual calcula el descuento a aplicar)
- realiza un resumen de cada entrada, por entrada, y luego pasa a los datos de la siguiente entrada

![Captura de pantalla 2025-05-10 143037](https://github.com/user-attachments/assets/cdefb085-5ece-4c7b-b231-8338a33a0338)

Al terminar el ingreso de datos por entrada retroalimetna al usuario con los asientos reservados:


![Captura de pantalla 2025-05-10 143422](https://github.com/user-attachments/assets/c0404233-c23a-42ae-8cf4-d477d6023c4a)

Solicita luego ingresar información de quien paga, lo que internamente categoriza como el cliente principal, en el rol de "comprador" y genera un resumen de la reserva con un resumen de los tickets que esta comprando.

![Captura de pantalla 2025-05-10 143606](https://github.com/user-attachments/assets/3dd1f348-67a0-4d84-b953-fd85f48b6650)

Para realizar la compra debe volver al menu principal e ingresar el numero de ID de la compra que se señala dos veces en la imagen anterior, con el mismo ID puede modificar la reserva o eliminarla.


MODIFICACIÓN DE RESERVA 

En la modificacion de la reserva se permite solo la devolución de entradas, retroalimentando constantemente al usuario durante el proceso, valida la cantidad de asientos que desea devolver para modificar su reserva y retroalimenta mostrando el mapa con la liberación de los asientos y manteniendo la reserva pertinente.

![Captura de pantalla 2025-05-10 151029](https://github.com/user-attachments/assets/c4ed3f0c-6322-425b-9935-6a4b1499d7ea)

Se puede verificar que la reserva modificó su información al enlistar las reservas y ahora la reserva figura con solo un asiento

![Captura de pantalla 2025-05-10 144151](https://github.com/user-attachments/assets/ed203b9c-71e9-41a3-896c-c71c20acdb83)


ELIMINACION DE RESERVA

Para la eliminación de reservas, solicita ingresar el id de la reserva que desea eliminar, pidiendo una segunda verificación, si la persona opta por NO eliminar la reserva, los asientos continúan reservados:

Importante: libera los asientos pero todas las reservas eliminadas o confirmadas quedan en un histórico.
Mejoras futuras agregar el estado a cada reserva como " eliminada o confirmada " y se pueden generar dos listas una solo de confirmadas y otra de eliminadas, con el id correlativo de cada una para efectos de contabilidad, trazabilidad y estadísticas.

En el siguiente caso se simularon dos reservas y se eliminó la primera, lo que implica que si luego en el proceso de compra, que solicita id de reserva desea comprar la primera reserva, no podrá

![Captura de pantalla 2025-05-10 144539](https://github.com/user-attachments/assets/45273f9f-aabb-459f-9d29-703fdd344e72)

![Captura de pantalla 2025-05-10 144836](https://github.com/user-attachments/assets/b3bae5ec-8fe3-47e0-b725-4a4933dac779)

![Captura de pantalla 2025-05-10 145818](https://github.com/user-attachments/assets/2090d812-433e-45c6-a736-afab5dd7553e)



Si el usuario ingresa una respuesta no valida, se maneja esto: 

![Captura de pantalla 2025-05-05 153545](https://github.com/user-attachments/assets/cea54a6f-aaa0-4472-bfab-f4da07d5a4f5)


CONFIRMACIÓN DE COMPRA

Si la persona NO confirma la compra, se liberan los asientos de su reserva y se verifican en el mapa: 
![Captura de pantalla 2025-05-10 151449](https://github.com/user-attachments/assets/a33eb955-0f99-4361-8557-b466b23243ba)

El ejercicio fue realizar una reserva, no confimarla como compra, de todas maneras, la lista de reservas la registra como realizada, ya que existió, pero no se generó la compra: 
![Captura de pantalla 2025-05-05 153757](https://github.com/user-attachments/assets/e66c7bcc-d827-4e61-99a7-a1ca6043558b)

Al confirmar la compra, se muestra el mapa con los asientos ocupados "OO":

![Captura de pantalla 2025-05-10 203708](https://github.com/user-attachments/assets/3f1a97b6-9a0b-4e32-94fa-311822f70b8e)






ANULACION DE COMPRA:
En el siguiente caso, se realiza la compra de asiento b1 y b2 y se anula la compra
- mostrando la liberación de los asientos.
- se genera la lista de ventas anuladas
- la venta efectiva se elimina de la lista ventas
- las estadisticas generales contabilizan ventas totales como la sumatoria de las efectivas y anuladas, con sus clasificaciones
  
![Captura de pantalla 2025-05-10 204223](https://github.com/user-attachments/assets/ee431ead-fa4b-431f-aa03-08a8dd00dd21)

Luego de varios movimientos se puede pedir una estadistica general en el estado actual, que incluye la sumatoria o resta de los ingresos según los totales a pagar. 

Se realiza un caso de ejemplo: 
- se realizan cuatro reservas
- la primera reseva con cuatro entradas con distintos descuentos
- se elimina la segunda reserva, los tickets reservados respectivos se anulan pero se conserva su id para registro
- la reserva 1, 3, y 4 pasan a ser compras efectivas y sus id de ventas pasan a ser 1, 2 y 3
- la compra 2 se anula, pasando a la lista de ventas anuladas
- genera las listas respectivas y las estadisticas de todos estos movimientos:
- la lista de clientes registrados se agrego el criterio del rol, identificando a los clientes asistentes asignados a las etnradas y además al cliente principal pagador o comprador
- la lista de tickets vendidos falta el 5 que fue eliminado

  
![Captura de pantalla 2025-05-10 201333](https://github.com/user-attachments/assets/734dfe84-1b7e-4efb-b187-0e67a63f0867)

![Captura de pantalla 2025-05-10 201348](https://github.com/user-attachments/assets/2a330498-125f-4ec3-b293-e6ad4722b3e8)

![Captura de pantalla 2025-05-10 201356](https://github.com/user-attachments/assets/55fcf4dd-5696-42e7-9b48-650ec3533e59)

![Captura de pantalla 2025-05-10 201409](https://github.com/user-attachments/assets/42db85d4-d632-41cf-9e2f-372de86e1bb1)

![Captura de pantalla 2025-05-10 201422](https://github.com/user-attachments/assets/605c6031-118c-4045-a163-70bca29b7991)

![Captura de pantalla 2025-05-10 201438](https://github.com/user-attachments/assets/4888b524-1c87-4161-8ba1-524106096a76)



Se imprime la boleta con el detalle de entradas compradas según id ingresado, indica su número de ticket, asiento y tipo de descuento

![Captura de pantalla 2025-05-10 202054](https://github.com/user-attachments/assets/2804d374-f96f-4b5f-98d8-aed80a327c96)


Se imprimen los tickets respectivos a la compra según ID

![Captura de pantalla 2025-05-10 202321](https://github.com/user-attachments/assets/35e8db01-b88a-4664-a012-ad4aa6f823c7)

![Captura de pantalla 2025-05-10 202329](https://github.com/user-attachments/assets/3b29a96a-9aa9-4656-80ff-5adaf1e6f636)


Se puede observar que en los tickets y en el listado de clientes registrados que se aplica el mayor descuento, por ejemplo si tiene 10 años pero es mujer, se valida el descuento mayor por género y se aplica 20% o si es mujer pero de tercera edad se aplica el 25%

Hay pequeños detalles que quizás pasan por alto como son cuando el programa identifica si el usuario ya ha sido registrado antes: 

![Captura de pantalla 2025-05-10 202857](https://github.com/user-attachments/assets/aa2fa989-471b-4fc7-abce-17b375b93bde)





Con la opción 16 se entrega un mensaje de salida y se cierra el programa:
![Captura de pantalla 2025-05-10 210559](https://github.com/user-attachments/assets/a557e4b6-d7ce-4aab-9aaa-8c9163c4e591)


OPTIMIZACIONES Y PRUEBAS

- Como parte de las optimizaciones se decidió utilizar la estructura de datos Array para los Asientos y de esta manera poder desplegar el mapa del teatro como matriz y se tomó la decisión del resto de utilizar listas.
- Así mismo se presenta un código con menos comentarios que los anteriores, ya que según lo indicado el exceso de comentarios también va cargando tiempos de ejecución del programa.
  
Durante la realización del código se hicieron múltiples pruebas de su ejecución encontrando detalles y se mejoraron como por ejemplo en el siguiente caso que fallaba el ciclo por que estaba mal estructurado: 

![Captura de pantalla 2025-05-10 202632](https://github.com/user-attachments/assets/83e6f236-d10a-4d26-94e8-fb037fc3e697)

O al refactorizar el código anterior y agregar las modificaciones un contador que antes servia ahora estaba causando conflicto: 
![Captura de pantalla 2025-05-10 202720](https://github.com/user-attachments/assets/f4f12b57-2d82-4009-97d0-1b0d62f4ab04)



## Observación:
En esta versión se plantea el programa con la reserva y la compra de manera separada, para efectuar la compra debe salir si o si al menú principal y elegir dicha opción. Las instrucciones se le indican al usuario.





## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
