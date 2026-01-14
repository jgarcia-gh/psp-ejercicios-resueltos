// En primer lugar creamos el objeto

/*
// Opción 1
let producto = {
    id: 4,
    nombre: 'Mesita de noche',
    precio: 49.90,
    descripcion: () => `${this.id} - ${this.nombre} - ${this.precio}`
}*/

// Opción 2
let producto = {
    id: 4,
    nombre: 'Mesita de noche',
    precio: 49.90,
    descripcion: function() {
        return `${this.id} - ${this.nombre} - ${this.precio}`
    }
}

// Mostramos su descripción
console.log(producto.descripcion());


// Recorremos sus propiedades y las mostramos
for(let prop in producto){
    console.log(`Propiedad: ${prop} Valor: ${producto[prop]}`);
}
