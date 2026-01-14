function esperar(ms){
    return new Promise((resolve, reject) =>{
        setTimeout(resolve,ms);
    });
}

let crearPedido = async (producto) => {
    console.log(`Creando pedido para: ${producto}...`);
    await esperar(2000);
    const pedido = {id: Date.now(), producto, estado: "Creado"};
    return pedido;
}

let procesarPago = async (pedido) => {
    console.log(`Procesando pago`);
    await esperar(2000);
    pedido.estado = "Pagado";
    return pedido;
}

let enviarPedido = async (pedido) => {
    console.log(`Enviando pedido`);
    await esperar(2000);
    pedido.estado = "Enviado";
    return pedido;
}
let finalizarPedido = async (pedido) => {
    await esperar(2000);
    pedido.estado = "Finalizado";
    return pedido;
}


async function gestionarPedido(){
    let pedido = await crearPedido("Zapatillas");
    console.log(`Pedido creado: `, pedido);
    pedido = await procesarPago(pedido);
    console.log(`Pago procesado: `, pedido);
    pedido = await enviarPedido(pedido);
    console.log(`Pedido enviado: `, pedido);
    pedido = await finalizarPedido(pedido);
    console.log(`Pedido finalizado: `, pedido);
}

gestionarPedido();