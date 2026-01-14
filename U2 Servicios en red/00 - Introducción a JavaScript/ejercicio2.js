let crearPedido = (producto, callback) => {
    console.log(`Creando pedido para: ${producto}...`);
    setTimeout(() => {
        const pedido = {id: Date.now(), producto, estado: "Creado"};
        //console.log(`Pedido creado`);
        callback(pedido);
    },2000);
}

let procesarPago = (pedido, callback) => {
    console.log(`Procesando pago`);
    setTimeout(() => {
        //console.log(`Pago procesado`);
        pedido.estado = "Pagado";
        callback(pedido);
    }, 2000);
}

let enviarPedido = (pedido, callback) => {
    console.log(`Enviando pedido`);
    setTimeout(() => {
        //console.log(`Pedido enviado`);
        pedido.estado = "Enviado";
        callback(pedido);
    }, 2000);
}
let finalizarPedido = (pedido, callback) => {
    //console.log(`Finalizando pedido`);
    pedido.estado = "Finalizado";
    callback(pedido);
}

crearPedido("Zapatillas", (pedido)=>{
    console.log(`Pedido creado: `, pedido);
    procesarPago(pedido, (pedido) =>{
        console.log(`Pago procesado: `, pedido);
        enviarPedido(pedido, (pedido) =>{
            console.log(`Pedido enviado: `, pedido);
            finalizarPedido(pedido, (pedido) =>{
                console.log(`Pedido finalizado: `, pedido);
            });
        });
    });
});


