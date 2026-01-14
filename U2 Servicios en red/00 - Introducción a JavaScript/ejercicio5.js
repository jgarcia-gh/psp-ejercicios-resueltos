let crearPedido = (producto) => {
    console.log(`Creando pedido para: ${producto}...`);
    return new Promise((res) => {
        setTimeout(() => {
            const pedido = {id: Date.now(), producto, estado: "Creado"};
            //console.log(`Pedido creado`);
            res(pedido);
        },2000);
    });
}

let procesarPago = (pedido) => {
    console.log(`Procesando pago`);
    return new Promise((res)=>{
        setTimeout(() => {
            //console.log(`Pago procesado`);
            pedido.estado = "Pagado";
            res(pedido);
        }, 2000);
    });
}

let enviarPedido = (pedido) => {
    console.log(`Enviando pedido`);
    return new Promise((res) => {
        setTimeout(() => {
            //console.log(`Pedido enviado`);
            pedido.estado = "Enviado";
            res(pedido);
        }, 2000);
    });
}
let finalizarPedido = (pedido) => {
    return new Promise((res)=>{
        //console.log(`Finalizando pedido`);
        pedido.estado = "Finalizado";
        res(pedido);
    });
}

// Callback hell
/*crearPedido("Zapatillas").then((pedido)=>{
    console.log(`Pedido creado: `, pedido);
    procesarPago(pedido).then((pedido) =>{
        console.log(`Pago procesado: `, pedido);
        enviarPedido(pedido).then((pedido) =>{
            console.log(`Pedido enviado: `, pedido);
            finalizarPedido(pedido).then((pedido) =>{
                console.log(`Pedido finalizado: `, pedido);
            });
        });
    });
});*/

// Si retornamos las promesas podemos reducir el callback hell
crearPedido("Zapatillas")
    .then((pedido)=>{
        console.log(`Pedido creado: `, pedido);
        return procesarPago(pedido)})
    .then((pedido) =>{
        console.log(`Pago procesado: `, pedido);
        return enviarPedido(pedido)})
    .then((pedido) =>{
        console.log(`Pedido enviado: `, pedido);
        return finalizarPedido(pedido)})
    .then((pedido) =>{
        console.log(`Pedido finalizado: `, pedido);});
