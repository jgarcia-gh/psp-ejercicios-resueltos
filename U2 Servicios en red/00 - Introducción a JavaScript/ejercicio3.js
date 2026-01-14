const estudiantes = [
  {
    nombre: "Ana",
    edad: 20,
    asignaturas: [
      { nombre: "Matemáticas", nota: 8 },
      { nombre: "Historia", nota: 6 },
      { nombre: "Inglés", nota: 9 }
    ]
  },
  {
    nombre: "Luis",
    edad: 22,
    asignaturas: [
      { nombre: "Matemáticas", nota: 5 },
      { nombre: "Historia", nota: 7 },
      { nombre: "Inglés", nota: 6 }
    ]
  },
  {
    nombre: "Carla",
    edad: 19,
    asignaturas: [
      { nombre: "Matemáticas", nota: 9 },
      { nombre: "Historia", nota: 9 },
      { nombre: "Inglés", nota: 10 }
    ]
  }
];


// Parte a)
const[primerEstudiante] = estudiantes;
const {nombre, edad} = primerEstudiante;
console.log(`El primer estudiante es ${nombre} y tiene ${edad} años.`);

// Parte b)
// Sin desestructuración
/*const nombres = estudiantes.map((estudiante)=>estudiante.nombre);
console.log(`Los nombres de los estudiantes son ` , nombres);*/

// Con desestructuración
const nombres = estudiantes.map(({nombre})=>nombre);
console.log(`Los nombres de los estudiantes son ` , nombres);

// Parte c)
// Sin desestructuración
/*const filtrado = estudiantes.filter((estudiante) => {
    const asignatura = estudiante.asignaturas.find((a) => a.nombre = 'Matemáticas');
    return asignatura.nota > 7;
});
console.log(filtrado);*/


// Con desestructuración
const filtrado = estudiantes.filter(({asignaturas}) => {
    const {nota} = asignaturas.find((a) => a.nombre = 'Matemáticas');
    return nota > 7;
});
console.log(filtrado);

// Parte d)
const filtradoNombres = estudiantes.filter(({asignaturas}) => {
    const {nota} = asignaturas.find((a) => a.nombre = 'Matemáticas');
    return nota > 7;
}).map(({nombre}) => nombre);
console.log(filtradoNombres);