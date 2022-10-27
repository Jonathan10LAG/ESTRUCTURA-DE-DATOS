package HITO2;

public class MAIN {crear base de  datos  function_agregation ;

    uso función_agregación;

    crear  tabla  estudiantes (
            id_est entero auto_increment clave principal  no nula ,
            nombres varchar ( 50 ),
    apellidos varchar ( 50 ),
    edad entero ,
    entero de     gestión ,
    fono entero ,
    correo electrónico varchar ( 100 ),
    direccion varchar ( 100 ),
    sexo varchar ( 10 )
);

    seleccionar estimación *
    de estudiantes como est;

    INSERTAR EN estudiantes (nombres, apellidos, edad, fono, email, direccion, sexo)
    VALORES ( ' Miguel ' , ' Gonzales Veliz ' , 20 , 2832115 , ' miguel@gmail.com ' , ' Av. 6 de Agosto ' , ' masculino ' );
    INSERTAR EN estudiantes (nombres, apellidos, edad, fono, email, direccion, sexo)
    VALORES ( ' Sandra ' , ' Mavir Uria ' , 25 , 2832116 , ' sandra@gmail.com ' , ' Av. 6 de Agosto ' , ' femenino ' );
    INSERTAR EN estudiantes (nombres, apellidos, edad, fono, email, direccion, sexo)
    VALORES ( ' Joel ' , ' Adubiri Mondar ' , 30 , 2832117 , ' joel@gmail.com ' , ' Av. 6 de Agosto ' , ' masculino ' );
    INSERTAR EN estudiantes (nombres, apellidos, edad, fono, email, direccion, sexo)
    VALORES ( ' Andrea ' , ' Arias Ballesteros ' , 21 , 2832118 , ' andrea@gmail.com ' , ' Av. 6 de Agosto ' , ' femenino ' );
    INSERTAR EN estudiantes (nombres, apellidos, edad, fono, email, direccion, sexo)
    VALORES ( ' Santos ' , ' Montes Valenzuela ' , 24 , 2832119 , ' santos@gmail.com ' , ' Av. 6 de Agosto ' , ' masculino ' );

# Crear la consulta sql
# que modifique el campo GESTION
# y que asigne a todos el valor 2022

    actualizar estudiantes
    establecer gestión =  ' 2022 '
    donde id_est >  0 ;

    CREAR  TABLA  materias
            (
                    id_mat INTEGER AUTO_INCREMENT CLAVE PRIMARIA   NO NULL ,
                    nombre_mat VARCHAR ( 100 ),
    cod_mat VARCHAR ( 100 )
);

    CREAR  TABLA  inscripción
            (
                    id_ins INTEGER AUTO_INCREMENT CLAVE PRIMARIA  NO NULL ,
                    id_est INT  NO NULO ,

                    id_mat INT  NO NULO ,
                    semestre VARCHAR ( 20 ),
    gestión INTEGER ,
    CLAVE EXTRANJERA (id_est) REFERENCIAS estudiantes (id_est),
    CLAVE EXTRANJERA (id_mat) REFERENCIAS materias (id_mat)
            );

    INSERTAR EN materias (nombre_mat, cod_mat) VALORES
    ( ' Introducción a la Arquitectura ' , ' ARQ-101 ' ),
            ( ' Urbanismo y Diseño ' , ' ARQ-102 ' ),
            ( ' Dibujo y Pintura Arquitectonico ' , ' ARQ-103 ' ),
            ( ' Matemática discreta ' , ' ARQ-104 ' ),
            ( ' Fisica Básica ' , ' ARQ-105 ' );

    INSERTAR EN inscripcion (id_est, id_mat, semestre, gestion) VALORES
( 1 , 1 , ' 1er Semestre ' , 2015 ),
        ( 1 , 2 , ' 2do Semestre ' , 2015 ),
        ( 2 , 4 , ' 1er Semestre ' , 2016 ),
        ( 2 , 3 , ' 2do Semestre ' , 2016 );

    INSERTAR EN inscripcion (id_est, id_mat, semestre, gestion) VALORES
( 3 , 3 , ' 2do Semestre ' , 2017 ),
        ( 3 , 1 , ' 3er Semestre ' , 2017 ),
        ( 4 , 4 , ' 4to Semestre ' , 2017 ),
        ( 5 , 5 , ' 5to Semestre ' , 2017 );


# Mostrar los nombres y apellidos de los estudiantes inscritos en la materia
# ARQ-104, además mostrar el nombre de la materia.
# tablas relacionadas:
            #estudiantes _
# inscripción
# materia

    seleccione  est . nombres , est . apellidos , mat . nombre_mat
    de inscripción como ins
    unión interna estudiantes como est en  ins . id_est  =  est . id_est
    materiales de unión interna como tapete en  ins . id_mat  =  mat . id_mat
    donde  estera . cod_mat  =  ' ARQ-104 ' ;

# Contar cuantos registros tiene la tabla estudiantes

    seleccione  count ( est . id_est ) como  ' Cantidad de Estudiantes '
    de estudiantes como est;

# Mostrar el promedio de edad en la tabla de estudiantes.

    seleccione  avg ( est . edad ) como  ' Promedio de Edad '
    de estudiantes como est;

# Mostrar la máxima edad que se tiene en la tabla de estudiantes.

    SELECCIONE  MAX ( edad est . )
    DESDE estudiantes AS est;


# Mostrar la edad minima que se tiene en los estudiantes.
    SELECCIONE  MIN ( edad est . )
    DESDE estudiantes AS est;

# Determinar la maxima edad de los estudiantes cuyo genero sea masculino o femenino

    seleccione  max ( est . edad ) como  ' Edad Máxima '
    de estudiantes como est
    donde  esta _ sexo  =  ' Masculino ' && est . edad  > 20 ;

# Crear una función que devuelve el máximo valor del campo edad en la tabla estudiantes.

    función  crear o reemplazar get_max_edad ()
    devuelve entero

    empezar
    devolver (
            SELECCIONE  MAX ( edad est . )
    DESDE estudiantes AS est
            ) ;
    final;

    selecciona get_max_edad() como MaxEdad;



# Crear una función que obtenga la menor edad de los estudiantes.
# Crear una función que obtenga el promedio de las edades.
            # Crear una función que obtenga la mayor edad de los estudiantes (cuyo sexo seas masculino o femenino).

    función  crear o reemplazar get_min_edad ()
    devuelve entero

    empezar
    devolver (
            SELECCIONE  MIN ( edad est . )
    DESDE estudiantes AS est
            );
    final;

    selecciona get_min_edad() como MinEdad;

    función  crear o reemplazar get_promedio ()
    devuelve entero

    empezar
    devolver (
            seleccione  avg ( est . edad ) como  ' Promedio de Edad '
    de estudiantes como est
                );

    final;


    seleccione get_promedio() como Promedio;

    función  crear o reemplazar get_edad_mayor ()
    devuelve entero

    empezar
                return ( seleccione  max ( est . edad ) como  ' Edad Máxima '
    de estudiantes como est
    donde  esta _ sexo  =  ' Masculino ' && est . edad  > 20 );
    final;

    selecciona get_edad_mayor() como Edadmayor;

#   Mostrar el registro de la tabla estudiantes (nombre y apellidos) donde cuyo id_est sea el máximo.

    crear o reemplazar  la función  get_max_id () devuelve un número entero
    empezar
    devolver (
            seleccione  max ( est . id_est )
    de estudiantes como est
            );
    final;

    seleccione get_max_id();

    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde  esta _ id_est  = get_max_id();


# Crear una función que obtenga la suma de las edades de los estudiantes Masculino/Femenino

    funcion  crear o reemplazar suma_de_edades () devuelve entero

    empezar
    devolver (
            seleccionar  suma ( est . edad )
    de estudiantes como est
    donde  esta _ sexo  =  ' Femenino '
            );
    final;

    selecciona suma_de_edades();

    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde suma_de_edades() % 2  = 0 ;


# Crear una función que obtenga la suma de las edades de los estudiantes Femeninos.
    funcion  crear o reemplazar suma_de_edades () devuelve entero

    empezar
    devolver (
            seleccionar  suma ( est . edad )
    de estudiantes como est
    donde  esta _ sexo  =  ' Femenino '
            );
    final;

    selecciona suma_de_edades();

    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde suma_de_edades() % 2  = 0 ;


# Volver parametrizable la funcion anterior. v1
    función  crear o reemplazar suma_de_edades_v1 (genero_valor varchar ( 10 )) devuelve entero

    empezar
    devolver (
            seleccionar  suma ( est . edad )
    de estudiantes como est
    donde  esta _ sexo  = genero_valor
            );
    final;

    selecciona suma_de_edades_v1( ' masculino ' );
    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde suma_de_edades_v1( ' Masculino ' ) % 2  = 0 ;

# Volver parametrizable la funcion anterior. v2
    función  crear o reemplazar suma_edadesv2 (genero varchar ( 10 )) devuelve entero
    empezar
# Esto sirve para declarar una vsariable en una funcion
    declarar sumaedad entero por defecto 0 ;
# default sirve para asignar un valor.
# into sirve para asignarle el resultado de una consulta a la variable
    select  sum ( est . edad ) into sumaedad
    de estudiantes como est
    donde  esta _ sexo  = genero;

    volver sumaedad;
    final;

    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde suma_edadesv2( ' Masculino ' ) % 2  = 0 ;


    función  crear o reemplazar get_promedio_varones (sexo varchar ( 10 )) devuelve entero
    empezar
    declarar promedio entero por defecto 0 ;

    seleccione  avg ( est . edad ) en promedio
    de estudiantes como est
    donde  esta _ sexo  = sexo;

    volver promedio;
    final;

    selecciona get_promedio_varones( ' Masculino ' );
    seleccione  est . nombres , est . apellidos
    de estudiantes como est
    donde suma_edadesv2( ' Masculino ' ) % 2  = 0 ;

# Crear una función que permita concatenar dos columnas.
            # Concatena el nombre y apellidos de la tabla estudiante.
# El nombre de la función deberá ser getNombreCompleto
# La función deberá recibir 2 parámetros (nombre y apellidos)

    select concat( ' Andres ' , '  ' , ' Quiroga ' );

    crear o reemplazar  la función  getNombreCompleto (part1 varchar ( 25 ), part2 varchar ( 35 )) devuelve varchar ( 50 )
    empezar
    declarar concatenado varchar ( 50 ) por defecto ' ' ; -- concatenado = '';
    establecer concatenado = concat(part1, ' - ' , part2);
    retorno concatenado;
    final;

    select getNombreCompleto( ' Popeye ' , ' Espinaca ' );

    seleccione getNombreCompleto( est . nombres , est . apellidos ) como nombre completo
    de estudiantes como est;

# TRIM elimina los espacios de izquierda a derecha

    Seleccione concat_ws( ' - '  ' DBA II ' , ' 2022 ' , ' 2do Semestre ' ) como concat;

#Concatenar ; Generar el siguiente formato de salida
# Concatenar nombres y apellidos de la siguiente forma: Nombres: Andres, Apellidos: Quiroga
# Concatenar gestion y edad de la siguiente forma: Gestion: 2022, edad: (10)

    crear o reemplazar  la función  output_fullname (nombres varchar ( 20 ), apellidos varchar ( 20 )) devuelve varchar ( 100 )
    empezar
    declarar resultado varchar ( 100 ) default ' ' ;

    set resultado = concat( ' Nombres: ' , nombres , ' , Apellidos: ' , apellidos);
    volver resultado;
    final;

    seleccione salida_nombre_completo( ' Andrés ' , ' Quiroga ' );

# gestion y edad
    select output_fullname( est . nombres , est . apellidos )
    de estudiantes como est;
#
    crear o reemplazar  la función  output_age (gestion int , edad int ) devuelve varchar ( 100 )
    empezar
    declarar resultado varchar ( 100 ) default ' ' ;

    set resultado = concat( ' Gestion: ' , gestion , ' , Edad:( ' , edad , ' ) ' );
    volver resultado;
    final;

    seleccione edad_salida ( 2022 , 23 );

    select output_age( est . gestion , est . edad )
    de estudiantes como est;

# las dos funciones anteriores unidas a una sola
    crear o reemplazar  la función  output_full (nombres varchar ( 20 ), apellidos varchar ( 20 ), gestion int , edad int ) devuelve varchar ( 100 )
    empezar
    declarar resultado varchar ( 100 ) default ' ' ;
    set resultado = concat( ' Nombres: ' , nombres , ' Apellidos: ' , apellidos , ' Gestion: ' , gestion , ' Edad:( ' , edad , ' ) ' );
    volver resultado;
    final;

    select output_full( ' Andres ' , ' Quiroga ' , 2022 , 23 );

    select output_full( est . nombres , est . apellidos , est . gestion , est . edad )
    de estudiantes como est;

#
    crear o reemplazar  la función  full_datos (Nombres varchar ( 30 ), Apellidos varchar ( 30 ), Edad int ) devuelve varchar ( 60 )
    empezar
    declarar resultado varchar ( 60 ) por defecto ' ' ;
    set resultado = concat( ' Nombres: ' , Nombres , ' Apellidos: ' , Apellidos , ' Edad:( ' , Edad , ' ) ' );
    volver resultado;
    final;




# Mostrar el nombre, apellidos y el semestre de todos los estudiantes que esten inscritos.
# en la gestión 2015

    seleccione  est . nombres , est . apellidos , m . nombre_mat , yo . gestion
    de estudiantes como est
    unión interna inscripcion i on  est . id_est  =  yo . id_est
    unión interna materias m en  i . id_mat  =  metro . id_mat
    donde  yo _ gestion  =  ' 2015 '  y  m . cod_mat  =  ' ARQ-101 '  y  yo . semestre  =  ' 5to Semestre ' ;

    seleccione  est . nombres , est . apellidos , i . gestion
    de estudiantes como est
    unión interna inscripcion i on  est . id_est  =  yo . id_est
    donde  yo _ gestion  = 2016  o  i . gestión  =  2017 ;
}
